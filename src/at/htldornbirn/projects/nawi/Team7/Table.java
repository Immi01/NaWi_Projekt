package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Table implements ProjectActor {
    private float y, x;
    private float high;
    private float width;
    private float minWidth;
    private float minlength;
    private float originOffSet;

    public Table(float high, float x, float minWidth, float width) {
        this.high = high;
        this.x = x;
        this.width = width;
        this.minWidth = minWidth + this.width;
        this.y = 599-this.high;
        this.minlength = 100;
        this.originOffSet = -10;
    }

    @Override
    public void render(Graphics graphics) {




        graphics.drawRect(this.x, this.y, this.width, this.high);
        graphics.drawRect((this.x - this.minWidth), this.y, this.width, this.high);
        graphics.drawRect(0 + this.originOffSet, this.y - this.width, this.x + this.minlength - this.originOffSet ,  this.width);
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }
}
