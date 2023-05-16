package at.htldornbirn.projects.nawi.Team2.code;

import at.htldornbirn.projects.nawi.Team2.code.Background.Background;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BackgroundInputField {

    private int x,y,width,height;

    public BackgroundInputField(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }


    public void render(Graphics graphics) throws SlickException {
        graphics.drawRect(x,y,width,height);
    }

    public void update(GameContainer gameContainer) {
    }
}
