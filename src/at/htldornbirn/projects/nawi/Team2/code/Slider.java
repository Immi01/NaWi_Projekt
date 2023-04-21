package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float x, y;
    float sliderPosition;
    private List<EventListener> eventListeners;



    public Slider(float x, float y) {
        this.x = x;
        this.y = y;
        this.eventListeners = new ArrayList<>();
    }


    public void addListener(EventListener eventListener){
        this.eventListeners.add(eventListener);
    }


    public float update(GameContainer gameContainer) throws SlickException {
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
            for (EventListener eventListener: this.eventListeners) {
                eventListener.onChange();
            }
        }

        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>200 && mouseY<500){
                y = mouseY;
                sliderPosition = y - 200;
            }
        }
        return sliderPosition;
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(this.x, this.y, 40, 40);
    }
}
