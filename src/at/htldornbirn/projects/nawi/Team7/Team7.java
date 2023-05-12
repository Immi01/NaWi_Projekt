package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.List;

public class Team7 extends BasicGameState {
    private Ball ball;
    private List<Ball> balls;
    private Table table;


    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        ball = new Ball(0,80, 0.0f,(float) 5, 10, 0.5f);
        table = new Table(150, 200, 150, 30);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        this.ball.render(graphics);
        this.table.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        this.ball.update(gameContainer, delta);

    }



}
