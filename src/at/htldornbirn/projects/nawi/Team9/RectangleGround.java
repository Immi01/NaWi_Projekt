package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class RectangleGround implements Actor {
    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    ;
    private float x;
    private float y;
    private float width;
    private float height;

    public RectangleGround(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.drawRect(this.x, this.y, width, height);
        graphics.fillRect(this.x, this.y, this.width, this.height);
    }

    public void update(int delta) {

    }
}
