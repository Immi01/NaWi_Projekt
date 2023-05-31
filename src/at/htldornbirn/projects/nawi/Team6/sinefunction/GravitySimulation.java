package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GravitySimulation extends BasicGameState {
    private Circle ball;
    private Vector2f velocity;
    private boolean jumping;
    private static final float GRAVITY = 0.050f;
    private static final float JUMP_FORCE = -7.0f;
    private static final float BALL_RADIUS = 15.0f;
    private static final int WIDTH = 1152;
    private static final int HEIGHT = 864;
    Image land = null;

    @Override
    public int getID() {
        return 4;
    }

    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        land = new Image("at/htldornbirn/projects/nawi/Team6/sinefunction/assets/background.png");
        ball = new Circle(WIDTH / 2, HEIGHT / 2, BALL_RADIUS);
        velocity = new Vector2f(0, 0);
        jumping = false;
    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        Input input = gc.getInput();

        if (input.isKeyDown(Input.KEY_SPACE) && !jumping) {
            velocity.y = JUMP_FORCE;
            jumping = true;
        }

        velocity.y += GRAVITY;

        ball.setCenterX(ball.getCenterX() + velocity.x);
        ball.setCenterY(ball.getCenterY() + velocity.y);

        if (ball.getCenterY() + BALL_RADIUS >= HEIGHT) {
            ball.setCenterY(HEIGHT - BALL_RADIUS);
            velocity.y *= -0.7f; // Abschwächung des Sprungs (bounce)

            if (Math.abs(velocity.y) < 0.8f) { // Wenn die vertikale Geschwindigkeit sehr gering ist, stoppe den Ball
                jumping = false;
                velocity.y = 0;
            }
        }
    }

    public void render(GameContainer gc, StateBasedGame sb, Graphics g) throws SlickException {
        g.drawImage(land, 0, 0);
        g.setColor(Color.white);
        g.fill(ball);
    }
}
