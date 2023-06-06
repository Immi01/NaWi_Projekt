package at.htldornbirn.projects.nawi.Team7.slider;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float x, y;
    private float minValue, maxValue, width;
    private List<SliderListener> eventListeners;



    public Slider(float x, float y, int minValue, int maxValue, float width) {
        this.x = x;
        this.y = y;
        this.minValue =minValue+y;
        this.maxValue =maxValue+y;
        this.eventListeners = new ArrayList<>();
        this.width = width;
    }


    public void addListener(SliderListener eventListener){
        this.eventListeners.add(eventListener);
    }


    public void update(GameContainer gameContainer) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>this.y && mouseY<this.y+300 && mouseX >this.x && mouseX < this.x+40){
                if(this.y >= this.minValue && this.y <= this.maxValue) {
                    this.y = mouseY - 20;
                    for (SliderListener eventlistener : eventListeners) {
                        eventlistener.onChange(mouseY);
                    }
                }
                if(this.y > this.maxValue)
                {
                    this.y = this.maxValue;
                }
                if(this.y < this.minValue)
                {
                    this.y = this.minValue;
                }

            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, width, width);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public float getMaxValue() {
        return maxValue;
    }

    public float getWidth() {
        return width;
    }
}
