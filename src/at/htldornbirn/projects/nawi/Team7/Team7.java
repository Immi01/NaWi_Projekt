package at.htldornbirn.projects.nawi.Team7;

import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.tools.button.BackButton;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.List;

public class Team7 extends BasicGameState {
    private Ball ball;
    private List<Ball> balls;
    private Table table;
    private BackButton back;


    @Override
    public int getID() {
        return 71;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        back = new BackButton(stateBasedGame);
        ball = new Ball(0,500, 0.1f,(float) 0.4, 20, 1f, 00f);
        table = new Table(150, 200, 150, 30);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.ball.render(graphics);
        this.table.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = gameContainer.getInput();
        if(input.isKeyPressed(Input.KEY_ESCAPE)){
            back.changeState(gameContainer);
        }
        this.ball.update(gameContainer, delta);


    }



}
