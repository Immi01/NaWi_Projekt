package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class CustomBalls implements ProjectActor{
    private float x,y,height, width;
    private float distanceBetweenBallAndRectangle;
    private float weight;
    private float radius;
    private float id;

    public CustomBalls(float x, float y, float height, float width, float weight, float radius, float id) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.distanceBetweenBallAndRectangle = 20;
        this.weight = weight;
        this.radius = radius;
        this.id = id;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x +this.distanceBetweenBallAndRectangle/2, this.y + this.distanceBetweenBallAndRectangle/2, this.height - this.distanceBetweenBallAndRectangle, this.width - this.distanceBetweenBallAndRectangle);
    }

    @Override
    public void update(GameContainer gc, int delta) {

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

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getWeight() {
        return weight;
    }

    public float getRadius() {
        return radius;
    }

    public float getId() {
        return id;
    }

    public void setId(float id) {
        this.id = id;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
