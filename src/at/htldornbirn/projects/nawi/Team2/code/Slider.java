package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Slider {
    private float x, y;

    public Slider(float x, float y) {
        this.x = x;
        this.y = y;
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

        graphics.drawOval(this.x, this.y, 20, 20);

    }
}
