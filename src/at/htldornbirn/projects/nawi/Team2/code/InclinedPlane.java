package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class InclinedPlane extends BasicGameState {

    private Triangle triangle;
    private Rectangle rectangle;
    private Slider slider;

    private SetAngle setAngle = new SetAngle();


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.triangle = new Triangle(20);
        this.slider = new Slider(200, 200);
        this.rectangle = new Rectangle();

        slider.addListener(setAngle);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);

        graphics.setColor(Color.black);
        rectangle.render(gameContainer,graphics);
        graphics.setColor(Color.white);

        slider.render(gameContainer,graphics);

        graphics.setBackground(Color.blue);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        slider.update(gameContainer);

        triangle.setAngle(setAngle.getSliderValue());
    }
}
