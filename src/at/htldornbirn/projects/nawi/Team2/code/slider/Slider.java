package at.htldornbirn.projects.nawi.Team2.code.slider;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;
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


    public void update(GameContainer gameContainer) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>200 && mouseY<500 && mouseX >200 && mouseX < 240){
                this.y = mouseY-20;
                for (EventListener eventlistener: eventListeners) {
                    eventlistener.onChange(mouseY);
                }
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillOval(this.x, this.y, 40, 40);
    }
}
