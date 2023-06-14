package at.htldornbirn.projects.nawi.Team8;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class SetupRotation extends StateBasedGame {

    public SetupRotation(String name) {
        super(name);
    }

    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        this.addState(new Explanation());
        this.addState(new RotationGame());
    }

    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new SetupRotation("Rotation"));
        container.setDisplayMode(1600, 960, false);
        container.start();
    }
}

