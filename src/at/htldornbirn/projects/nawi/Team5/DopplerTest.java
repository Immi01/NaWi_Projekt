package at.htldornbirn.projects.nawi.Team5;

import at.htldornbirn.projects.nawi.Team6.SinusFunction;
import at.htldornbirn.projects.nawi.Team6.SinusTest;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class DopplerTest extends StateBasedGame {
    public DopplerTest(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Dopplereffect());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SinusTest("NaWi Portal"));
        container.setDisplayMode(800,600,false);
        container.start();
    }
}
