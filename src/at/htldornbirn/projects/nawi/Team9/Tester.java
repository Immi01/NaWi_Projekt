package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Tester extends StateBasedGame {
    public Tester(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Team9Game());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Tester("NaWi Portal"));
        container.setDisplayMode(1600,800,false);
        container.start();
    }
}
