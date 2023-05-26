package at.htldornbirn.projects.nawi.Team2.code;
import at.htldornbirn.projects.nawi.Team2.code.Background.*;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.Random;


import java.util.ArrayList;
import java.util.List;

public class InclinedPlane2 extends  BasicGameState{
    private List<Actor> actors;
    private Rectangle rectangle;
    private float angle;
    private float speed;
    private float getX;
    private float getY;
    private boolean isMoving;




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        getX = 100;
        getY = 700;
        isMoving = true;

        rectangle = new Rectangle(getX, getY, 150, 50);
        angle = 135.0f;
        speed = 5.0f;


        for (int i = 0; i <1; i++) {
            Sky sky = new Sky();
            this.actors.add(sky);
        }
        for (int i = 0; i <1; i++) {
            Background background = new Background();
            this.actors.add(background);
        }
        for (int i = 0; i <1; i++) {
            Sun sun = new Sun();
            this.actors.add(sun);
        }

        for (int i = 0; i <1; i++) {
            Cloud cloud = new Cloud();
            this.actors.add(cloud);
        }
        for (int i = 0; i <100; i++) {
            Snowflake snowflake = new Snowflake(random.nextInt(1500), random.nextInt(100), random.nextInt(50));
            this.actors.add(snowflake);
        }
    }



    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Actor actors:this.actors){
            actors.render(graphics);

            graphics.setColor(Color.white);
            graphics.pushTransform();
            graphics.rotate(rectangle.getCenterX(), rectangle.getCenterY(), angle);
            graphics.fillRect(getX, getY, 150, 50);
            graphics.popTransform();
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        for (Actor actors : this.actors) {
            actors.update(delta);
        }
        if (getY > 200){
            getX -= (float)delta/this.speed;
        }else{
            this.speed = 0;
        }
    }
}


