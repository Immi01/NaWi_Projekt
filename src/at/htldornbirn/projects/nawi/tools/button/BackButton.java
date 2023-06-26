package at.htldornbirn.projects.nawi.tools.button;

import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.navigation.Actor;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;
import org.newdawn.slick.state.StateBasedGame;

public class BackButton implements Actor {
    private float y,x;
    StateBasedGame stateBasedGame;


    public BackButton(StateBasedGame stateBasedGame) {
        this.stateBasedGame = stateBasedGame;
    }


    @Override
    public void render(Graphics graphics) {
    }

    @Override
    public void update(int delta) {

    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }


    public void changeState(GameContainer gameContainer) throws SlickException {
        if(stateBasedGame.getState(Constants.NAVIGATION) != stateBasedGame.getCurrentState())
        {
            AppGameContainer gc = (AppGameContainer) gameContainer;
            gc.setDisplayMode(800, 600, false);
            stateBasedGame.enterState(Constants.NAVIGATION);
            return;
        }
        System.out.println("Already in Navigation");

    }


}

