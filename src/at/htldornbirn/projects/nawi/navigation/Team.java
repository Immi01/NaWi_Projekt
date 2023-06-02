package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Team implements Actor{

    private float x;
    private float y;
    private int a;
    private int teamNr;
    private Image image;

    public Team(float x, float y, int a, int teamNr) throws SlickException {
        this.x = x;
        this.y = y;
        this.a = a;
        this.teamNr = teamNr;
        image = new Image("/src/at/htldornbirn/projects/nawi/images/Unbenannt.jpg").getScaledCopy(a-1,a-1);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,this.a,this.a);
        image.draw(x+1,y+1);
    }

    @Override
    public void update(int delta) {

    }
}
