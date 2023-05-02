package at.htldornbirn.projects.nawi.Team2.code.Background;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;



public class Snowflake implements Actor{
    private float speed;
    private float direction;
    private Image image;

    public Snowflake(float speed, float direction) throws SlickException {
        this.speed = speed;
        this.direction = direction;
        image = new Image("Background/snowflake.jpg");
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(int delta) {

    }
}
