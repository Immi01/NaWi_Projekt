package at.htldornbirn.projects.nawi.Team2.code;

import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.*;

public class InclinedPlane extends BasicGame{

    private Triangle triangle;
    private Slider slider;


    private SetAngle setAngle = new SetAngle();


    public InclinedPlane(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.triangle = new Triangle(20);
        this.slider = new Slider(200, 200);

        slider.addListener(setAngle);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        float sliderValue = slider.update(gameContainer);
        sliderValue = sliderValue/10;
        triangle.setAngle(sliderValue);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);
        slider.render(gameContainer,graphics);
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
