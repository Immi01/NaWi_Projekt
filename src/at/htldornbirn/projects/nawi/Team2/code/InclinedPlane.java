package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.*;

public class InclinedPlane extends BasicGame {

    private Triangle triangle;


    public InclinedPlane(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.triangle = new Triangle(20);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        triangle.render(gameContainer,graphics);
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
