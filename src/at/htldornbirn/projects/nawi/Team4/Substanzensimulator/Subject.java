package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Actors;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.geom.Circle;

public class Subject implements Actors {
    private float x, y;
    private int radius;
    private Circle circle;

    public Subject(float x, float y, int radius) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.circle = new Circle(x, y, radius);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public int getRadius() {
        return radius;
    }

    @Override
    public void update(int delta) {
        // Hier können weitere Logik-Updates für den Kreis durchgeführt werden
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(x - radius, y - radius, radius * 2, radius * 2);
    }

    public boolean intersects(Substanzen substanzen) {
        float circleX = x;
        float circleY = y;
        float rectX = substanzen.getX();
        float rectY = substanzen.getY();
        int rectWidth = substanzen.getWidth();
        int rectHeight = substanzen.getHeight();

        float deltaX = circleX - Math.max(rectX, Math.min(circleX, rectX + rectWidth));
        float deltaY = circleY - Math.max(rectY, Math.min(circleY, rectY + rectHeight));
        return (deltaX * deltaX + deltaY * deltaY) < (radius * radius);
    }
    public void consume(){
        
    }
}
