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

<<<<<<< HEAD
=======
<<<<<<< HEAD
        /*input = gameContainer.getInput();*/
=======
        offset = new Vector2f();;
>>>>>>> 78aab877dbdc3c1b4aa042c540096e75b07b091d
>>>>>>> b2d475c8dbac8f97bd524f34ae66a59848faf527
        slider.addListener(setAngle);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        slider.update(gameContainer);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);
        slider.render(gameContainer,graphics);
        graphics.setBackground(new Color(255, 255, 255));
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
