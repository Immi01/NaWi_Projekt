package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Team implements Actor{

    private float x;
    private float y;
    private int height;
    private int width;
    private int teamNr;
    private Image image;

    public Team(float x, float y, int width, int height, int teamNr) throws SlickException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.teamNr = teamNr;
        image = new Image("/src/at/htldornbirn/projects/nawi/images/Unbenannt.jpg").getScaledCopy(width-1,height-1);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.width,this.height);
        image.draw(x+1,y+1);
    }

    @Override
    public void update(int delta) {

    }
}
