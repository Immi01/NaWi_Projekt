package at.htldornbirn.projects.nawi.Team1;

import at.htldornbirn.projects.nawi.Team2.code.Test;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.GameState;
import org.newdawn.slick.state.StateBasedGame;

public class Team1 extends StateBasedGame {
    public Team1(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Team1Game());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Team1("Team1"));
            container.setDisplayMode(800, 600, false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
