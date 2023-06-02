package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class DefinitionBoxes implements ProjectActor{
    private float x,y,z, width;

    public DefinitionBoxes(float x, float z, float width) {
        this.z = z;
        this.x = x;
        this.width = width;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y, this.width, this.z);
    }

    @Override
    public void update(GameContainer gc, int delta) {

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

    public float getX() {
        return x;
    }

    public float getZ() {
        return z;
    }
}
