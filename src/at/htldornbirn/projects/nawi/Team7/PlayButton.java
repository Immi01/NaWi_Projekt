package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class PlayButton implements ProjectActor{
    private float x,y,height,width;
    private Color color;
    private String describtion;

    public PlayButton(float x, float y, float height, float width, Color color, String describtion) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.color = color;
        this.describtion = describtion;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRect(this.x, this.y, this.width, this.height);
        graphics.drawString(this.describtion, this.x, this.y);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
