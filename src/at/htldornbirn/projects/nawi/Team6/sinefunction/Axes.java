package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Axes implements Actor {
    public float x, y, labelX, labelY;
    public float width, height;
    private String label;

    public Axes(float x, float y, float width, float height, String label, float labelX, float labelY) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.labelX = labelX;
        this.labelY = labelY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
        graphics.drawString(this.label, this.labelX, this.labelY);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
