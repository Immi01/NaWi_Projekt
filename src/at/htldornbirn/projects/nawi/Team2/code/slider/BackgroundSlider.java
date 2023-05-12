package at.htldornbirn.projects.nawi.Team2.code.slider;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BackgroundSlider {
    private float x,y,width,value;

    public BackgroundSlider(float x, float y, float width, float value) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.value = value;
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {

    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(this.x,this.y,this.width,this.value+this.width);
    }
}
