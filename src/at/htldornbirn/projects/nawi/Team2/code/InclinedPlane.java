package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Team2.code.slider.BackgroundSlider;
import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InclinedPlane extends BasicGameState {

    private Triangle triangle;
    private Slider slider;
    private InputField inputField;
    private CalculateButton calculateButton;

    private SetAngle setAngle = new SetAngle();


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.triangle = new Triangle();

        this.slider = new Slider(200, 200,40,300);

        this.inputField = new InputField("", 100, 100);

        this.calculateButton = new CalculateButton();

        slider.addListener(setAngle);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);

        slider.render(gameContainer,graphics);

        inputField.render(graphics);
        calculateButton.render(gameContainer, graphics);

        graphics.setBackground(Color.blue);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        slider.update(gameContainer);
        calculateButton.update(gameContainer);

        triangle.setAngle(setAngle.getSliderValue());
    }

    public void keyPressed(int key, char c) {
        if (key == Input.KEY_BACK){
               this.inputField.back();
        }else{
            if (Character.isDigit(c)) {
                this.inputField.append(Character.toString(c));
            }
        }
    }
}
