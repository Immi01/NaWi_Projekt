package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float x, y;
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
        if (gameContainer.getInput().isKeyDown(Input.KEY_SPACE)) {
            for (EventListener eventListener: this.eventListeners) {
                eventListener.onChange();
            }
        }
    }
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawOval(this.x, this.y, 40, 40);
    }
}
