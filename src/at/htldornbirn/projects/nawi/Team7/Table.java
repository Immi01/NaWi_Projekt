package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Table implements ProjectActor {
    private float y, x;
    private float high;
    private float width;
    private float minWidth;
    private float minlength;

    public Table(float high, float x, float minWidth) {
        this.high = high;
        this.x = x;
        this.minWidth = minWidth + 15;
    }

    @Override
    public void render(Graphics graphics) {
        this.y = 599-this.high;
        this.minlength = 100;
        this.width = 20;
        graphics.drawRect(this.x, this.y, this.width, this.high);
        graphics.drawRect((this.x - this.minWidth), this.y, this.width, this.high);
        graphics.drawRect(0, this.y - this.width, this.x + (this.x- (2 * this.minlength)),  this.width);
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }
}
