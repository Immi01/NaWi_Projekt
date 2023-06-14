package at.htldornbirn.projects.nawi.Team2.code.Background;

import at.htldornbirn.projects.nawi.navigation.Actor;
import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;


public class Snowflake implements Actor {
    private Image image;
    private float x, y;
    private float speed;



    public Snowflake(float x, float y, float speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        image = new Image("src/at/htldornbirn/projects/nawi/Team2/code/Background/snowflake.png");

    }


    @Override
    public void render(Graphics graphics) {
        Image scaledImage = image.getScaledCopy(0.1f);
        scaledImage.draw(x, y);




    }

    @Override
    public void update(int delta) {
        image.draw(x, y);

        this.y += (float)delta/this.speed;
        if(this.y >800){
            this.y = 0;
        }
        if(this.speed == 0){
            this.speed = 5;
        }
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }
}
