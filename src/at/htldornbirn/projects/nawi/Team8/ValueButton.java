package at.htldornbirn.projects.nawi.Team8;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;


public class ValueButton implements Actor{
    private float speedButtonX;
    private float speedButtonY;
    private String speed;
    private String value;


    public ValueButton(float speedButtonX, float speedButtonY,String speed) {
        this.speedButtonX = speedButtonX;
        this.speedButtonY = speedButtonY;
        this.speed = speed;
    }


    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }


    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
