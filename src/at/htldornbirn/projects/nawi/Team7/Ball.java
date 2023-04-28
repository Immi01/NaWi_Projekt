package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Ball implements ProjectActor{
    private float x,y;
    private float speed;
    private float realisticSpeed;
    private float Gforce;
    private float radius;

    public Ball(float x, float y, float speed, float gForce, float radius) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.Gforce = gForce;
        this.radius = radius;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }

    @Override
    public void update(GameContainer gc, int delta) {

        this.x = this.y + delta*this.speed - ((this.Gforce*(delta * delta))/2);
    }
}
