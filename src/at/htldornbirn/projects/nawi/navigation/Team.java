package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Color;
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
        image = new Image("/src/at/htldornbirn/projects/nawi/images/TEAM9.png").getScaledCopy(width-1,height-1);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    @Override
    public void render(Graphics graphics) {
        image.draw(x+1,y+1);
        graphics.drawRoundRect(this.x,this.y,this.width,this.height,20);
        graphics.setColor(Color.black);
        for (int i = 0; i < 12; i++) {
            graphics.drawRoundRect(this.x-i/2f,this.y-i/2f,this.width+i,this.height+i,20);
        }
    }

    @Override
    public void update(int delta) {

    }

    public void setImage(Image image) {
        this.image = image.getScaledCopy(width-1,height-1);
    }
}
