package at.htldornbirn.projects.nawi.Team6.sinefunction;

import at.htldornbirn.projects.nawi.Team6.Gravitation.GameState;
import at.htldornbirn.projects.nawi.Team6.Gravitation.GravityExplanation;
import at.htldornbirn.projects.nawi.Team6.Gravitation.GravitySimulation;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupSineFunction extends StateBasedGame {
    private static final int containerWidth = 1280;
    private static final int containerHeight = 960;

    public SetupSineFunction(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new Explanation());
        this.addState(new SineFunctionSandBox());
        this.addState(new Interference());
        this.addState(new GravityExplanation());
        this.addState(new GameState());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupSineFunction("Sine Function"));
        app.setDisplayMode(containerWidth, containerHeight, false);
        app.setTargetFrameRate(60);
        app.setAlwaysRender(true);
        app.start();
    }
}
