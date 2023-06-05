package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Actors;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

public class Subject implements Actors {
    private float x, y;
    private int radius;
    private Circle circle;
    private int size = 200;
    Image react1;
    Image react2;
    Image react3;
    Image react4;
    Image react5;

    public Subject(float x, float y, int radius) throws SlickException {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.circle = new Circle(x, y, radius);

        Image temp1 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/Flamme.png");
        this.react1 = temp1.getScaledCopy(size,size);
        Image temp2 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/Rufezeichen.png");
        this.react2 = temp2.getScaledCopy(size,size);
        Image temp3 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/corrosive.png");
        this.react3 = temp3.getScaledCopy(size,size);
        Image temp4 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/explosion.png");
        this.react4 = temp4.getScaledCopy(size,size);
        Image temp5 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/strahlend.png");
        this.react5 = temp5.getScaledCopy(size,size);
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
    public void consume(int id){
        switch (id){

            case 0: react1.draw(400-100,250-100);
                break;
            case 1: react2.draw(400-100,250-100);
                break;
            case 2: react5.draw(400-100,250-100);
                break;
            case 3: react4.draw(400-100,250-100);
                break;
            case 4: react3.draw(400-100,250-100);
                break;

        }
    }
}
