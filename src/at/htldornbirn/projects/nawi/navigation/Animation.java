package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;

public class Animation implements Actor{

    private float y;
    private float x;
    private float a;
    private int yGoal;
    private int xGoal;
    private int aGoal;
    private float time;
    private float xSpeed;
    private float ySpeed;
    private float aSpeed;


    public Animation(int y, int x, int a) {
        this.y = y;
        this.x = x;
        this.a = a;
        xGoal = 20;
        yGoal = 20;
        aGoal = 500;
        float speed = 0.01f;
        xSpeed = (x - xGoal) * speed;
        ySpeed = (y - yGoal) * speed;
        aSpeed = (aGoal - a) * speed;
    }


    @Override
    public void update(int delta) {
        time += delta/1000f;
        if (x >= xGoal)
            x -= time * xSpeed;

        if (y >= yGoal)
            y -= time * ySpeed;

        if (a <= aGoal)
            a += time * aSpeed;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(x,y,a,a);
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }
}
