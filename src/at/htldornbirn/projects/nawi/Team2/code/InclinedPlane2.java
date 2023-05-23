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




    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        Random random = new Random();

        rectangle = new Rectangle(500, 600, 150, 50);
        angle = 135.0f;
        speed = 5.0f;
        this.getX = getX;
        this.getY = getY;


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
            graphics.fillRect(500, 600, 150, 50);
            graphics.popTransform();
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        for (Actor actors:this.actors){
            actors.update(delta);
        }
        this.getX += (float)delta/this.speed;
        this.getY += (float)delta/this.speed;
        if (getX > 800 && getY > 600){
            speed = 0;
        }
        else{
            this.getX += (float)delta/this.speed;
            this.getY += (float)delta/this.speed;
        }





    }


}


