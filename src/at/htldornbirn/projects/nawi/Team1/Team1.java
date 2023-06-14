package at.htldornbirn.projects.nawi.Team1;

import at.htldornbirn.projects.nawi.Team1.ElementInferno.ElementInferno;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;


public class Team1 extends StateBasedGame {
    public Team1(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new ElementInferno());
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Team1("ElementInferno"));
            container.setDisplayMode(800, 600, false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
