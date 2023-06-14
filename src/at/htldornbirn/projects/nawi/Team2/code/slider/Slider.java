package at.htldornbirn.projects.nawi.Team2.code.slider;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Slider {
    private float startPositionX, startPositionY;
    private float actualPositionY;
    private float width;
    private float value;
    private BackgroundSlider backgroundSlider;
    private List<EventListener> eventListeners;
    private float sliderValue;



    public Slider(float startPositionX, float startPositionY, float width, float value, float sliderValue) {
        this.startPositionX = startPositionX;
        this.actualPositionY = startPositionY-width/2;
        this.startPositionY = startPositionY;
        this.width = width;
        this.value = value;
        this.sliderValue = sliderValue;

        this.eventListeners = new ArrayList<>();
        this.backgroundSlider = new BackgroundSlider(this.startPositionX,this.actualPositionY,this.width,this.value, this.sliderValue);
    }


    public void addListener(EventListener eventListener){
        this.eventListeners.add(eventListener);
    }


    public void update(GameContainer gameContainer, float sliderValue, boolean calculateButtonPushed) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();
        backgroundSlider.update(gameContainer, sliderValue);


        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && calculateButtonPushed != true) {
            if (mouseY>=this.startPositionY && mouseY<=this.value+this.startPositionY && mouseX >=this.startPositionX && mouseX <= startPositionX+width){
                this.actualPositionY = mouseY-width/2;
                for (EventListener eventlistener: eventListeners) {
                    eventlistener.onChange(mouseY, startPositionY);
                }
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(Color.black);
        backgroundSlider.render(gameContainer,graphics);
        graphics.setColor(Color.white);
        graphics.fillOval(this.startPositionX, this.actualPositionY, width, width);
    }

    public BackgroundSlider getBackgroundSlider() {
        return backgroundSlider;
    }


}
