package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Box implements Actor{

    private Image box;
    private float x;
    private float y;
    private float width;
    private float height;

    public Box(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public Box() throws SlickException{
        Image boxy = new Image("src/at/htldornbirn/projects/nawi/Team9/images/box.jpg");
        this.box = boxy.getScaledCopy(100,100);
    }
    @Override
    public void render(Graphics graphics) throws SlickException {
        box.draw(0,0);
    }

    @Override
    public void update(int delta) {

    }
}
