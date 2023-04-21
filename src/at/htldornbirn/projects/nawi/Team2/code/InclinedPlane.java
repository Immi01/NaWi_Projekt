package at.htldornbirn.projects.nawi.Team2.code;

import at.htldornbirn.projects.nawi.Team2.code.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team2.code.slider.Slider;
import org.newdawn.slick.*;

public class InclinedPlane extends BasicGame{

    private Triangle triangle;
    private Slider slider;
    private Color backgroundColor;


    private SetAngle setAngle = new SetAngle();


    public InclinedPlane(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.triangle = new Triangle(20);
        this.slider = new Slider(200, 200);

        slider.addListener(setAngle);

        backgroundColor = Color.blue;
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        slider.update(gameContainer);

        triangle.setAngle(setAngle.getSliderValue());
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);
        slider.render(gameContainer,graphics);

        graphics.setBackground(backgroundColor);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new InclinedPlane("InclinedPlane"));
            container.setDisplayMode(1500,800,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
