package at.htldornbirn.projects.nawi.Team3;

import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.GameContainer;

public class Test extends StateBasedGame {
    public Test(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new StopingDistance());
    }


    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Test("Nawi Portal"));
        container.setDisplayMode(800, 600, false);
        container.start();
    }

}


