package at.htldornbirn.projects.nawi.Team2.code.slider;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class BackgroundSlider {
    private float x,y,width,value;
    private float sliderValue;

    public BackgroundSlider(float x, float y, float width, float value, float sliderValue) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.value = value;
        this.sliderValue = sliderValue;
    }

    public void update(GameContainer gameContainer, float sliderValue) throws SlickException {
        this.sliderValue = Math.round(10.0f * sliderValue) / 10.0f;
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(this.x,this.y,this.width,this.value+this.width);
        graphics.drawString("Winkel:", this.x+this.width+20,this.y);
        graphics.drawString(String.valueOf(sliderValue),this.x+this.width+20,this.y+20);
    }

    private double round(float value, int decimalPoints) {
        double d = Math.pow(10, decimalPoints);
        return Math.round(value * d) / d;
    }
}
