package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupSineFunction extends StateBasedGame {

    public SetupSineFunction(String title) {
        super(title);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new Explanation());
        this.addState(new SineFunctionSandBox());
        this.addState(new Interference());
        this.addState(new GravitySimulation());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupSineFunction("Sine Function"));
        app.setDisplayMode(1280, 960, false);
        app.setAlwaysRender(true);
        app.start();
    }
}
