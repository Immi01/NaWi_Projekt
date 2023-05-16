package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class LocationButton implements ProjectActor{
    private float x,y,height,width;

    public LocationButton(float x, float y, float height, float width) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
        graphics.drawString("Hallo", 10,20);
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
