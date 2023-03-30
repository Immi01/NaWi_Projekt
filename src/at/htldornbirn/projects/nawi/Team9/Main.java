package at.htldornbirn.projects.nawi.Team9;
import org.newdawn.slick.*;

public class Main extends BasicGame {
    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        }




    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }
        try {
            AppGameContainer container = new AppGameContainer(new Main("Horsepower"));
            container.setDisplayMode(1600, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

