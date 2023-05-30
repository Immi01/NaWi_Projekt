package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import org.newdawn.slick.Graphics;

public class Substanzen implements Actors{

    private float x, y;
    private int width, height;
    private boolean dragging;
    private String id;

    public Substanzen(float x, float y, int width, int height, boolean dragging, String id) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;


    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    @Override
    public void update(int delta) {

    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(x, y, width, height);
    }
}