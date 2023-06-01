package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Rope implements Actor{
    private float x1;
    private float y1;
    private float x2;
    private float y2;

    public Rope() {
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(Color.black);
        graphics.drawLine(x1,y1,x2,y2);
    }

    @Override
    public void update(int delta) {
        x1 = 750;
        y1 = 300;
        x2 = 750;
        y2 = 700;
    }
}
