package at.htldornbirn.projects.nawi.Team7;

import at.htldornbirn.projects.nawi.NaWiGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Team7Game extends StateBasedGame {


    public Team7Game(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Team7());
        //this.addState(new Sandbox());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Team7Game("NaWi Portal"));
        container.setDisplayMode(1440,1080,false);
        container.start();
    }
}
