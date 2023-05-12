package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Calculations {

    private float x,y,width,height;

    public Calculations() {
        this.x = 0;
        this.y = 0;
        this.width = 0;
        this.height = 0;
    }

    public void update(GameContainer gameContainer) throws SlickException {
        this.x = 1;
        this.y = 1;
        this.width = 1000;
        this.height = 700;

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(x,y,width,height);
    }
}
