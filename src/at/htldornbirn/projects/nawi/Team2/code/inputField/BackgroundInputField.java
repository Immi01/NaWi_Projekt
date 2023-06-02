package at.htldornbirn.projects.nawi.Team2.code.inputField;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BackgroundInputField {

    private int x,y,width,height;
    private String function;

    public BackgroundInputField(int x, int y, int width, int height, String function) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.function = function;
    }


    public void render(Graphics graphics,boolean hasFocus) throws SlickException {
        if (hasFocus){
            graphics.setColor(Color.black);
        }

        graphics.drawRect(x,y,width,height);
        graphics.setColor(Color.white);
        graphics.drawString(function,x,y-20);
    }

    public void update(GameContainer gameContainer) {
    }
}
