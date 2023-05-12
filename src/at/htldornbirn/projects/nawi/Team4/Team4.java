package at.htldornbirn.projects.nawi.Team4;

import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Substanzensimulator;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Game;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Team4 extends StateBasedGame {
    public Team4(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new Substanzensimulator("sf"));
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Team4("ehu"));
            container.setDisplayMode(800,600,false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
