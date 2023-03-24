package at.rangel.games.sinefunction;

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
        this.addState(new SineFunction());
        this.addState(new Explanation());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new SetupSineFunction("Test"));
        app.setDisplayMode(1600, 900, false);
        app.setAlwaysRender(true);
        app.start();
    }
}
