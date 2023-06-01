package at.htldornbirn.projects.nawi.Team5;
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
        AppGameContainer container = new AppGameContainer(new DopplerTest("NaWi Portal"));
        container.setDisplayMode(1000,750,false);
        container.setTargetFrameRate(60);
        container.start();
    }
}
