package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Rectangle implements ProjectActor{
    private float x,y,z;

    public Rectangle(float x, float z) {
        this.z = z;
        this.x = x;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y, this.z, this.z);
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

    public float getZ() {
        return z;
    }
}
