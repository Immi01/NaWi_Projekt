package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Ball implements ProjectActor{
    private float t,y,x;
    private float speedY;
    private float Gforce;
    private float radius;
    private float speedX;
    private float weight;


    public Ball(float x, float y, float speedY, float gForce, float radius, float speedX, float weight) {
        this.x = x;
        this.y = y;
        this.speedY = speedY;
        this.Gforce = gForce;
        this.radius = radius;
        this.speedX = speedX;
        this.weight = weight;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
    }


    @Override
    public void update(GameContainer gc, int delta) {
        this.t += delta / 1000f;
        this.x += this.speedX * t;
        if (this.x >= 400){
            this.y +=  (this.speedY) * this.t + (this.Gforce*((float)Math.pow(this.t,2)))/2;
        }
    }

    public float getGforce() {
        return Gforce;
    }

    public float getRadius() {
        return radius;
    }

    public float getWeight() {
        return weight;
    }
}
