package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Interference extends BasicGameState {
    private List<Actor> actors;
    private Button stateButton1;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.stateButton1 = new Button(675, gameContainer.getHeight() - 150, 175, 100, "Go to sandbox");
        this.actors.add(stateButton1);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();
        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }
    }
}
