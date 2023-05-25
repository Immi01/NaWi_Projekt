package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Team2.code.inputField.InputField;
import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;
import java.awt.Font;

public class InclinedPlane extends BasicGameState {

    private Triangle triangle;
    private Slider slider;
    private InputField inputFieldWeight;
    private InputField inputFieldDistance;
    private CalculateButton calculateButton;

    private SetAngle setAngle = new SetAngle();

    private Image backgroundImage;

    private TrueTypeFont font;


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        backgroundImage = new Image("src/at/htldornbirn/projects/nawi/Team2/pictures/background.png");

        this.triangle = new Triangle();

        this.slider = new Slider(100, 200,40,300, setAngle.getSliderValue());
        this.inputFieldWeight = new InputField("", 100, 100,false, "Gewicht: ");
        this.inputFieldDistance = new InputField("", 300, 100,false, "Strecke: ");

        this.calculateButton = new CalculateButton(setAngle.getSliderValue(), inputFieldWeight.getText(), inputFieldDistance.getText(), 100, 700, 150, 30);

        Font awtFont = new Font("Arial", Font.BOLD, 32);
        font = new TrueTypeFont(awtFont, true);

        slider.addListener(setAngle);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawImage(backgroundImage, 0, 0);

        graphics.setColor(Color.white);

        graphics.setLineWidth(5.0f);
        triangle.render(gameContainer,graphics);
        graphics.setLineWidth(1.0f);

        slider.render(gameContainer,graphics);
        inputFieldWeight.render(graphics);
        inputFieldDistance.render(graphics);

        calculateButton.render(gameContainer, graphics);

        graphics.setBackground(Color.blue);

        graphics.setColor(Color.black);
        graphics.setFont(font);
        graphics.drawString("Schiefe Ebene", stateBasedGame.getContainer().getWidth()/2-font.getWidth("Schiefe Ebene")/2, 20);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        slider.update(gameContainer, setAngle.getSliderValue());
        calculateButton.update(gameContainer,this.setAngle.getSliderValue(),this.inputFieldWeight.getText(), this.inputFieldDistance.getText());

        triangle.setAngle(setAngle.getSliderValue());

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
