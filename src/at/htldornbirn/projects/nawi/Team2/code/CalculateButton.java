package at.htldornbirn.projects.nawi.Team2.code;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;
import org.newdawn.slick.*;

public class CalculateButton {

    private Calculations calculations;
    private float angle;
    private String weight, distance;
    private boolean isPushed;

    private float positionX, positionY, width, height;


    public CalculateButton(float angle, String weightText, String distanceText, float positionX, float positionY, float width, float height) {
        this.angle = angle;
        this.weight = weightText;
        this.distance = distanceText;
        this.isPushed = false;

        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;

        this.calculations = new Calculations(this.angle, this.weight, this.distance);
    }

    public void update(GameContainer gameContainer, float angle, String weight, String distance) throws SlickException {
        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>this.positionY && mouseY<this.positionY+this.height && mouseX >this.positionX && mouseX < this.positionX+this.width){
                this.isPushed = true;
                calculations.update(gameContainer, angle, weight, distance);
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(Color.black);
        graphics.fillRect(this.positionX,this.positionY,this.width,this.height);
        graphics.setColor(Color.white);
        graphics.drawString("Calcualate",(this.positionX+width)/2,this.positionY+height/5);
        calculations.render(gameContainer,graphics);
    }

    public boolean isPushed() {
        return isPushed;
    }

    public void setPushed(boolean pushed) {
        isPushed = pushed;
    }

    public Calculations getCalculations() {
        return calculations;
    }
}