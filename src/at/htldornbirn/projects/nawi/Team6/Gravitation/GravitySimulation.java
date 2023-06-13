package at.htldornbirn.projects.nawi.Team6.Gravitation;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GravitySimulation extends StateBasedGame {
    private static final int containerWidth = 1280;
    private static final int containerHeight = 960;

    public GravitySimulation(String title) {
        super(title);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer app = new AppGameContainer(new GravitySimulation("Gravitationssimulation"));
            app.setDisplayMode(containerWidth, containerHeight, false);
            app.setTargetFrameRate(60);
            app.setAlwaysRender(true);
            app.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        addState(new GravityExplanation());
        addState(new GameState());
    }
}
