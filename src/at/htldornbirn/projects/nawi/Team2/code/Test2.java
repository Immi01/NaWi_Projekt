package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Test2 extends StateBasedGame {
    public Test2(String name) {
        super(name);
    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new Test2("InclinedPlane2"));
            container.setDisplayMode(1500,800,false);

            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new InclinedPlane2());
    }
}