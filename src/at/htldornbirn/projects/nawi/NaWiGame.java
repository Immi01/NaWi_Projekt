package at.htldornbirn.projects.nawi;

import at.htldornbirn.projects.nawi.navigation.Navigation;
import at.htldornbirn.projects.nawi.sinusfunction.SinusFunction;
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
        addState(new SinusFunction());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new NaWiGame("NaWi Portal"));
        container.setDisplayMode(800,600,false);
        container.start();
    }
}
