package at.htldornbirn.projects.nawi;
import at.htldornbirn.projects.nawi.Team1.ElementInferno.ElementInferno;
import at.htldornbirn.projects.nawi.Team2.code.InclinedPlane;
import at.htldornbirn.projects.nawi.Team3.StopingDistance;
import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Substanzensimulator;
import at.htldornbirn.projects.nawi.Team5.Dopplereffect;
import at.htldornbirn.projects.nawi.Team6.Gravitation.GameState;
import at.htldornbirn.projects.nawi.Team6.Gravitation.GravityExplanation;
import at.htldornbirn.projects.nawi.Team6.sinefunction.Explanation;
import at.htldornbirn.projects.nawi.Team6.sinefunction.Interference;
import at.htldornbirn.projects.nawi.Team6.sinefunction.SineFunctionSandBox;
import at.htldornbirn.projects.nawi.Team7.Sandbox;
import at.htldornbirn.projects.nawi.Team7.Team7;
import at.htldornbirn.projects.nawi.Team8.RotationGame;
import at.htldornbirn.projects.nawi.Team9.Team9Game;
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
        addState(new ElementInferno());
        addState(new InclinedPlane());
        addState(new StopingDistance());
        addState(new Dopplereffect());
        addState(new Substanzensimulator("Substanzensimulator"));
        addState(new Explanation());
        addState(new Sandbox());
        addState(new GravityExplanation());
        addState(new GameState());
        addState(new Interference());
        addState(new SineFunctionSandBox());
        addState(new Team7());
        addState(new at.htldornbirn.projects.nawi.Team8.Explanation());
        addState(new RotationGame());
        addState(new Team9Game());



    }
    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new NaWiGame("NaWi Portal"));
        container.setDisplayMode(800,600,false);
        container.start();
    }
}
