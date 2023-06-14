package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class Ball implements ProjectActor{
    private float t,y,x;
    private float speedY;
    private float Gforce;
    private float radius;
    private float speedX;
    private float weight;
    private List<Float> positionsX;
    private List<Float> positionsY;


    public Ball(float x, float y, float speedY, float gForce, float radius, float speedX, float weight) {
        this.x = x;
        this.y = y;
        this.speedY = speedY;
        this.Gforce = gForce;
        this.radius = radius;
        this.speedX = speedX;
        this.weight = weight;
        this.positionsX = new ArrayList<>();
        this.positionsY = new ArrayList<>();
        //System.out.println(this.toString());
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Ball{" +
                "t=" + t +
                ", y=" + y +
                ", x=" + x +
                ", speedY=" + speedY +
                ", Gforce=" + Gforce +
                ", radius=" + radius +
                ", speedX=" + speedX +
                ", weight=" + weight +
                ", positionsX=" + positionsX +
                ", positionsY=" + positionsY +
                '}';
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.radius, this.radius);
        if (this.positionsX.size() > 1) {
            for (int i = 1; i < this.positionsX.size(); i++) {
                float prevX = this.positionsX.get(i - 1);
                float prevY = this.positionsY.get(i - 1);
                float currX = this.positionsX.get(i);
                float currY = this.positionsY.get(i);
                graphics.drawLine(prevX, prevY, currX, currY);
            }
        }
    }


    @Override
    public void update(GameContainer gc, int delta) {
        this.t += delta / 1000f;
        this.x += this.speedX * t;
        if (this.x >= 300){
            this.y +=  (this.speedX) * this.t + (this.Gforce*((float)Math.pow(this.t,2)))/2;
        }

        this.positionsX.add(this.x);
        this.positionsY.add(this.y);
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

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
}
