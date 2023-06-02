package at.htldornbirn.projects.nawi.Team2.code.Background;

import at.htldornbirn.projects.nawi.navigation.Actor;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class Background implements Actor {
    private float x;
    private float y;
    private float speed;
    private Color backgroundColor;
    private Image image;


    public Background() {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }



    @Override
    public void render(Graphics graphics) {


    }

    @Override
    public void update(int delta) {



    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getX() {
        return x;
    }
}
