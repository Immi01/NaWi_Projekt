package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;

public class Team1 implements Actor{

    private float x;
    private float y;
    private int a;

    public Team1(float x, float y, int a) {
        this.x = x;
        this.y = y;
        this.a = a;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getSize() {
        return a;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.a,this.a);
    }

    @Override
    public void update(int delta) {

    }
}
