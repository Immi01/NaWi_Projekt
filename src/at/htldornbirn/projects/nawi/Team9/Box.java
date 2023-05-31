package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Box implements Actor{

    private Image box;
    private float x = 700;
    private float y = 700;
    private float speed = 1;
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
        box.draw(x,y);
    }

    @Override
    public void update(int delta) {
        this.y -= (float) delta/this.speed;

    }
}
