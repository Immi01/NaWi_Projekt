package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class LocationButton implements ProjectActor{
    private float x,y,height,width;
    private String name;
    private float Gforce;
    private int LocationID;


    public LocationButton(float x, float y, float height, float width, String name, float Gforce, int LocationID) {
        this.x = x;
        this.y = y;
        this.height = height;
        this.width = width;
        this.name = name;
        this.Gforce = Gforce;
        this.LocationID = LocationID;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
        graphics.setColor(Color.blue);
        graphics.drawString(name, this.x + this.width/3, this.y + this.height/3);
        graphics.setColor(Color.white);
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

    public int getLocationID() {
        return LocationID;
    }

    public float getGforce() {
        return Gforce;
    }

    public float getHeight() {
        return height;
    }

    public float getWidth() {
        return width;
    }
}
