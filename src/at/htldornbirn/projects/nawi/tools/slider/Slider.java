package at.htldornbirn.projects.nawi.tools.slider;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float x, y;
    private List<SliderListener> eventListeners;



    public Slider(float x, float y, int minValue, int maxValue) {
        this.x = x;
        this.y = y;
        this.eventListeners = new ArrayList<>();
    }


    public void addListener(SliderListener eventListener){
        this.eventListeners.add(eventListener);
    }


    public void update(GameContainer gameContainer) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>y && mouseY<y+300 && mouseX >x && mouseX < x+40){
                this.y = mouseY-20;
                for (SliderListener eventlistener: eventListeners) {
                    eventlistener.onChange(mouseY);
                }
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 40, 40);
    }
}
