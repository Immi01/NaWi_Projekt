package at.htldornbirn.projects.nawi;
import at.htldornbirn.projects.nawi.Team2.code.InclinedPlane;
import at.htldornbirn.projects.nawi.Team3.StopingDistance;
import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Substanzensimulator;
import at.htldornbirn.projects.nawi.Team5.Dopplereffect;
import at.htldornbirn.projects.nawi.Team6.sinefunction.Explanation;
import at.htldornbirn.projects.nawi.Team8.Sandbox;
import at.htldornbirn.projects.nawi.navigation.Navigation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class NaWiGame extends StateBasedGame {
    public NaWiGame(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Navigation());
        addState(new InclinedPlane());
        addState(new StopingDistance());
        addState(new StopingDistance());
        addState(new Substanzensimulator("Substanzensimulator"));
        addState(new Explanation());
        addState(new Sandbox());



    }
    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new NaWiGame("NaWi Portal"));
        container.setDisplayMode(800,600,false);
        container.start();
    }
}
