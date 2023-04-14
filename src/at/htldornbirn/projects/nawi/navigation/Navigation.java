package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;
import net.java.games.input.Component;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Navigation extends BasicGameState {
    @Override
    public int getID() {
        return Constants.NAVIGATION;
    }


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {


        if (gameContainer.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)){
            System.out.println("OUT");
            stateBasedGame.enterState(Constants.SINUS_FUNKTION_GAME);
        }
    }
}
