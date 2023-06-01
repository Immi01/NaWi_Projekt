package at.htldornbirn.projects.nawi.Team6.sinefunction;

import at.htldornbirn.projects.nawi.Constants;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Vector2f;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class GravitySimulation extends BasicGameState {
    private Circle ball;
    private Vector2f velocity;
    private boolean jumping;
    private static final float GRAVITY = 0.050f;
    private static final float JUMP_FORCE = -7.0f;
    private static final float BALL_RADIUS = 15.0f;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;
    private List<Actor> actors;
    private Button stateButton1;
    private AngelCodeFont font;
    Image land = null;

    @Override
    public int getID() {
        return 4;
    }

    public void init(GameContainer gc, StateBasedGame sb) throws SlickException {
        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
        land = new Image("at/htldornbirn/projects/nawi/Team6/sinefunction/assets/background.png");
        ball = new Circle(WIDTH / 2, HEIGHT / 2, BALL_RADIUS);
        velocity = new Vector2f(0, 0);
        jumping = false;
        this.actors = new ArrayList<>();
        this.stateButton1 = new Button((float) gc.getWidth() / 2, gc.getHeight() - 150, 325, 100, "Go back to sine function", Color.black);
        this.stateButton1.setX((float) gc.getWidth() * 8 / 10 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) gc.getHeight() * 0.99f - this.stateButton1.getHeight());
        this.actors.add(stateButton1);
    }

    public void update(GameContainer gc, StateBasedGame sb, int delta) throws SlickException {
        Input input = gc.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gc.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gc.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                sb.enterState(Constants.TEAM6);
            }
        }

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
        for (Actor actor : this.actors) {
            actor.render(g);
        }
        stateButton1.render(g);

        g.setColor(Color.white);
        g.fill(ball);
    }
}
