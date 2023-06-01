package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.Team2.code.Background.*;
import at.htldornbirn.projects.nawi.Team2.code.inputField.InputField;
import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;
import org.newdawn.slick.Image;
import java.util.ArrayList;
import java.util.List;

public class InclinedPlane2 extends  BasicGameState{

    private Triangle triangle;
    private Slider slider;
    private InputField inputFieldWeight;
    private InputField inputFieldDistance;
    private CalculateButton calculateButton;

    private SetAngle setAngle = new SetAngle();

    private Image backgroundImage;

    private TrueTypeFont font;

    private Image buttonImage;
    private Image pictureImage;
    private boolean showPicture;
    private int buttonX;
    private int buttonY;
    private int pictureX;
    private int pictureY;


    private List<Actor> actors;
    private Rectangle rectangle;
    private float angle;
    private float speed;
    private float getX;
    private float getY;
    private boolean isMoving;


    @Override
    public int getID() {
        return Constants.TEAM2;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        getX = 100;
        getY = 700;
        isMoving = true;
        rectangle = new Rectangle(getX, getY, 150, 50);
        angle = 135.0f;
        speed = 5.0f;


        for (int i = 0; i <100; i++) {
            Snowflake snowflake = new Snowflake(random.nextInt(1500), random.nextInt(100), random.nextInt(50));
            this.actors.add(snowflake);
        }



        backgroundImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/backgoundimage.png");

        this.triangle = new Triangle();

        this.slider = new Slider(100, 200,40,300, setAngle.getSliderValue());
        this.inputFieldWeight = new InputField("", 100, 100,false, "Gewicht in kg: ");
        this.inputFieldDistance = new InputField("", 300, 100,false, "Strecke in m: ");

        this.calculateButton = new CalculateButton(setAngle.getSliderValue(), inputFieldWeight.getText(), inputFieldDistance.getText(), 100, 710, 150, 30);


        java.awt.Font awtFont = new java.awt.Font("Arial", java.awt.Font.BOLD, 32);
        font = new TrueTypeFont(awtFont, true);

        slider.addListener(setAngle);

        buttonImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/infoImage.png");
        pictureImage = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/animationImage.png");
        showPicture = false;

        buttonX = 1400;
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
            graphics.pushTransform();
            graphics.rotate(rectangle.getCenterX(), rectangle.getCenterY(), angle);
            graphics.fillRect(getX, getY, 150, 50);
            graphics.popTransform();
        }




        graphics.setColor(Color.white);

        graphics.setLineWidth(5.0f);
        triangle.render(gameContainer,graphics);
        graphics.setLineWidth(1.0f);

        slider.render(gameContainer,graphics);
        inputFieldWeight.render(graphics);
        inputFieldDistance.render(graphics);

        calculateButton.render(gameContainer, graphics);




        graphics.setColor(Color.black);
        graphics.setFont(font);
        graphics.drawString("Schiefe Ebene", stateBasedGame.getContainer().getWidth()/2-font.getWidth("Schiefe Ebene")/2, 20);

        Image scaledButton = buttonImage.getScaledCopy(0.1f);
        scaledButton.draw(buttonX, buttonY);
        if (showPicture) {
            Image scaledExplination = pictureImage.getScaledCopy(0.35f);
            scaledExplination.draw(pictureX, pictureY);
        }


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        for (Actor actors : this.actors) {
            actors.update(delta);
        }
        if (getY > 200){
            getX -= (float)delta/this.speed;
        }else{
            this.speed = 0;
        }


        slider.update(gameContainer, setAngle.getSliderValue(), false);
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
        if (key == Input.KEY_BACK){
            this.inputFieldWeight.back();
            this.inputFieldDistance.back();
        }else{
            if (Character.isDigit(c)) {
                this.inputFieldWeight.append(Character.toString(c));
                this.inputFieldDistance.append(Character.toString(c));
            }
        }
    }

    public void mousePressed(int button, int x, int y) {

        if (x >= this.inputFieldWeight.getX() && x <= this.inputFieldWeight.getX() + this.inputFieldWeight.getRectWidth()
                && y >= this.inputFieldWeight.getY() && y <= this.inputFieldWeight.getY() + this.inputFieldWeight.getRectHeight()) {
            this.inputFieldWeight.setHasFocus(true);
        } else {
            this.inputFieldWeight.setHasFocus(false);
        }


        if (x >= this.inputFieldDistance.getX() && x <= this.inputFieldDistance.getX() + this.inputFieldDistance.getRectWidth()
                && y >= this.inputFieldDistance.getY() && y <= this.inputFieldDistance.getY() + this.inputFieldDistance.getRectHeight()) {
            this.inputFieldDistance.setHasFocus(true);
        } else {
            this.inputFieldDistance.setHasFocus(false);
        }
    }
}