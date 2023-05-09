package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;

public class Team1 implements Actor{

    private float x;
    private float y;

    public Team1(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,60,60);
    }

    @Override
    public void update(int delta) {

    }
}
