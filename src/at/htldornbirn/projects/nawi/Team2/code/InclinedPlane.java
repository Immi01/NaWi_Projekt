package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.Team2.code.Background.*;
import at.htldornbirn.projects.nawi.Team2.code.inputField.InputField;
import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.Font;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class InclinedPlane extends BasicGameState {

    private Triangle triangle;
    private Slider slider;
    private InputField inputFieldWeight;
    private InputField inputFieldDistance;
    private CalculateButton calculateButton;
    private Sled sled;

    private SetAngle setAngle = new SetAngle();

    private Image backgroundImage;
    private TrueTypeFont headlineFont;
    private TrueTypeFont writing;

    private boolean calculateButtonPushed;


    private List<Actor> actors;
    private float angleSled;
    private float speedSled;

    private Image buttonImage;
    private Image pictureImage;
    private boolean showPicture;
    private int buttonX;
    private int buttonY;
    private int pictureX;
    private int pictureY;

    private String calculateButtonName;


    @Override
    public int getID() {
        return Constants.TEAM2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        this.actors = new ArrayList<>();
        Random random = new Random();


        for (int i = 0; i <1; i++) {
            Background background = new Background();
            this.actors.add(background);
        }

        for (int i = 0; i <100; i++) {
            Snowflake snowflake = new Snowflake(random.nextInt(1500), random.nextInt(100), random.nextInt(30)+10);
            this.actors.add(snowflake);
        }

        this.calculateButtonName = "Calculate";
        this.speedSled = 5.0f;
        this.angleSled = setAngle.getSliderValue()*-1;
        sled = new Sled(this.angleSled,this.speedSled,300,600, 150, 40);



        backgroundImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/background3.jpg");

        this.triangle = new Triangle();

        this.slider = new Slider(100, 200,40,300, setAngle.getSliderValue());
        this.inputFieldWeight = new InputField("", 100, 100,false, "Gewicht in kg: ");
        this.inputFieldDistance = new InputField("", 300, 100,false, "Strecke in m: ");

        Font writing = new Font("Arial", Font.BOLD, 18);
        this.writing = new TrueTypeFont(writing, true);
        int buttonStringWidth = this.writing.getWidth(this.calculateButtonName);
        int buttonStringHeight = this.writing.getHeight(this.calculateButtonName);

        this.calculateButton = new CalculateButton(setAngle.getSliderValue(), inputFieldWeight.getText(), inputFieldDistance.getText(), 100, 710, 150, 30, this.calculateButtonName, buttonStringWidth, buttonStringHeight);

        Font headline = new Font("Arial", Font.BOLD, 42);
        headlineFont = new TrueTypeFont(headline, true);

        slider.addListener(setAngle);

        buttonImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/infoImage.png");
        pictureImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/animationImage.png");
        showPicture = false;

        buttonX = 1430;
        buttonY = 20;
        pictureX = 1230;
        pictureY = 100;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        backgroundImage.draw(0, 0, gameContainer.getWidth(), gameContainer.getHeight());

        for (Actor actors:this.actors){
            actors.render(graphics);
            graphics.setColor(Color.white);
        }
        graphics.setFont(writing);

        sled.render(gameContainer, graphics);

        graphics.setColor(Color.white);

        graphics.setLineWidth(5.0f);
        triangle.render(gameContainer,graphics);
        graphics.setLineWidth(1.0f);

        slider.render(gameContainer,graphics);
        inputFieldWeight.render(graphics);
        inputFieldDistance.render(graphics);

        calculateButton.render(gameContainer, graphics);

        graphics.setColor(Color.black);
        graphics.setFont(headlineFont);
        graphics.drawString("Schiefe Ebene", stateBasedGame.getContainer().getWidth()/2-headlineFont.getWidth("Schiefe Ebene")/2, 20);

        Image scaledButton = buttonImage.getScaledCopy(0.1f);
        scaledButton.draw(buttonX, buttonY);
        if (showPicture) {
            Image scaledExplination = pictureImage.getScaledCopy(0.35f);
            scaledExplination.draw(pictureX, pictureY);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (sled.isAtBottom()){
            calculateButton.setPushed(false);
            sled.setAtBottom(false);
        }
        this.angleSled = setAngle.getSliderValue()*-1;
        sled.update(gameContainer, this.angleSled, delta, this.speedSled, calculateButton.isPushed(),calculateButton.getCalculations().getA());

        for (Actor actors : this.actors) {
            actors.update(delta);
        }

        this.calculateButtonPushed = calculateButton.isPushed();
        //System.out.println(calculateButtonPushed);



        slider.update(gameContainer, setAngle.getSliderValue(), calculateButtonPushed);
        calculateButton.update(gameContainer,this.setAngle.getSliderValue(),this.inputFieldWeight.getText(), this.inputFieldDistance.getText());

        triangle.setAngle(setAngle.getSliderValue());

        buttonImage.draw(buttonX, buttonY);
        pictureImage.draw(buttonX, buttonY);
        Input input = gameContainer.getInput();
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = input.getMouseX();
            int mouseY = input.getMouseY();
            if (mouseX >= buttonX && mouseX <= buttonX + buttonImage.getWidth()
                    && mouseY >= buttonY && mouseY <= buttonY + buttonImage.getHeight()) {
                showPicture = !showPicture;
            }
        }

    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_BACK && calculateButtonPushed != true){
            this.inputFieldWeight.back();
            this.inputFieldDistance.back();
        }else{
            if (Character.isDigit(c) && calculateButtonPushed != true) {
                this.inputFieldWeight.append(Character.toString(c));
                this.inputFieldDistance.append(Character.toString(c));
            }
        }
    }

    public void mousePressed(int button, int x, int y) {

        if (x >= this.inputFieldWeight.getX() && x <= this.inputFieldWeight.getX() + this.inputFieldWeight.getRectWidth()
                && y >= this.inputFieldWeight.getY() && y <= this.inputFieldWeight.getY() + this.inputFieldWeight.getRectHeight()&& calculateButtonPushed != true) {
            this.inputFieldWeight.setHasFocus(true);
        } else {
            this.inputFieldWeight.setHasFocus(false);
        }


        if (x >= this.inputFieldDistance.getX() && x <= this.inputFieldDistance.getX() + this.inputFieldDistance.getRectWidth()
                && y >= this.inputFieldDistance.getY() && y <= this.inputFieldDistance.getY() + this.inputFieldDistance.getRectHeight() && calculateButtonPushed != true) {
            this.inputFieldDistance.setHasFocus(true);
        } else {
            this.inputFieldDistance.setHasFocus(false);
        }
    }
}
