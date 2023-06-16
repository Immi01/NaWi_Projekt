package at.htldornbirn.projects.nawi.Team8;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public class Ball implements Actor {
    private float x;
    private float y;
    private float radius;
    private float angle;
    private double angleVelocity;

    public Ball(float x, float y, float radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.angle = 0;
    }

    public double getAngleVelocity() {
        return angleVelocity;
    }

    public void setAngleVelocity(double angleVelocity) {
        this.angleVelocity = angleVelocity;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getRadius() {
        return radius;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }

    public float getAngle() {
        return angle;
    }

    public void setAngle(float angle) {
        this.angle = angle;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.orange);
        graphics.fillOval(this.x, this.y, radius * 2, radius * 2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}