package at.htldornbirn.projects.nawi.Team8.slider;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float x, y;
    private float minValue, maxValue;
    private List<SliderListener> eventListeners;
    private Color color;


    public Slider(float x, float y, int minValue, int maxValue) {
        this.x = x;
        this.y = y;
        this.minValue = minValue + x;
        this.maxValue = maxValue + x;
        this.eventListeners = new ArrayList<>();
        this.color = Color.orange;

    }


    public void addListener(SliderListener eventListener) {
        this.eventListeners.add(eventListener);
    }


    public void update(GameContainer gameContainer) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseX > this.x && mouseX < this.x + 300 && mouseY > this.y && mouseY < this.y + 40) {
                if (this.x >= this.minValue && this.x <= this.maxValue) {
                    this.x = mouseX-10;
                    for (SliderListener eventListener : eventListeners) {
                        eventListener.onChange(mouseX);
                    }
                }
                if (this.x > this.maxValue) {
                    this.x = this.maxValue;
                }
                if (this.x < this.minValue) {
                    this.x = this.minValue;
                }

            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(color);
        graphics.fillOval(this.x, this.y, 50, 50);
    }

    public void setColor(Color orange) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
