package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import at.htldornbirn.projects.nawi.Team4.Substanzensimulator.Actors;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Circle;

import java.util.ArrayList;
import java.util.List;

public class Subject implements Actors {
    private float x, y;
    private int radius;
    private Circle circle;
    private int size = 200;
    private Image react1;
    private Image react2;
    private Image react3;
    private Image react4;
    private Image react5;
    private Image base;
    private List<Substanzen> substanzen;

    public Subject(float x, float y, int radius) throws SlickException {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.circle = new Circle(x, y, radius);
        substanzen = new ArrayList<>();

        Image temp1 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/fire.png");
        this.react1 = temp1.getScaledCopy(size+80,size+80);
        Image temp2 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/sick.png");
        this.react2 = temp2.getScaledCopy(size+27,size+28);
        Image temp3 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/melt.png");
        this.react3 = temp3.getScaledCopy(size+60,size+60);
        Image temp4 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/blow.png");
        this.react4 = temp4.getScaledCopy(size+20,size+20);
        Image temp5 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/glowy.png");
        this.react5 = temp5.getScaledCopy(size+100,size+100);
        Image baseimg = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/subject.png");
        this.base = baseimg.getScaledCopy(200,200);
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

            case 0: react1.draw(400-140,250-170);
                    base.draw(400-100,250-100);

                break;
            case 1: react2.draw(400-112,250-114);

                break;
            case 2: react5.draw(400-150,250-150);
                    base.draw(400-100,250-100);

                break;
            case 3: react4.draw(400-110,250-110);

                break;
            case 4: react3.draw(400-125,250-125);

                break;


                /*for (int i =0;i<5;i++){
                    if (i != 2){
                        substanzen.get(i).setActive(false);
                    }

                }*/
        }
    }
}
