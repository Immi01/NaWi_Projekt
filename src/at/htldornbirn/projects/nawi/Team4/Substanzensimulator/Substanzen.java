package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Substanzen implements Actors{

    private float x, y;
    private int width, height;
    private boolean dragging;
    private int id;
    private Image squareImage1;
    private Image squareImage2;
    private Image squareImage3;
    private Image squareImage4;
    private Image squareImage5;



    public Substanzen(float x, float y, int width, int height, boolean dragging, int id) throws SlickException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.id = id;
        Image temp1 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/Flamme.png");
        this.squareImage1 = temp1.getScaledCopy(110,110);
        Image temp2 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/Rufezeichen.png");
        this.squareImage2 = temp2.getScaledCopy(110,110);
        Image temp3 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/corrosive.png");
        this.squareImage3 = temp3.getScaledCopy(110,110);
        Image temp4 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/explosion.png");
        this.squareImage4 = temp4.getScaledCopy(110,110);
        Image temp5 = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/strahlend.png");
        this.squareImage5 = temp5.getScaledCopy(110,110);


    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public void setPos(int x, int y){
        setY(y);
        setX(x);
    }

    @Override
    public void render(Graphics graphics) {
        switch (id){
            case 0:
                squareImage1.draw(x,y);
                break;
            case 1:
                squareImage2.draw(x,y);
                break;
            case 2:
                squareImage5.draw(x,y);
                break;
            case 3:
                squareImage4.draw(x,y);
                break;
            case 4:
                squareImage3.draw(x,y);
                break;

        }


    }

}