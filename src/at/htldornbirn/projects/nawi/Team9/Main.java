package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;

public class Main extends BasicGame {
    //Add actors
    private Horse horse;

    //Constructor
    public Main(String title) {
        super(title);
    }

    //Main method - executable
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Horsepower"));
            container.setDisplayMode(1600, 900, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.horse = new Horse(100, 100, 1);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        this.horse.update(delta);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        this.horse.render(graphics);
    }
}
