package at.htldornbirn.projects.nawi.Team2.code;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;
import org.newdawn.slick.*;

public class CalculateButton {

    private Calculations calculations;
    private float angle;
    private String weight, distance;
    private boolean isPushed;

    private float positionX, positionY, width, height;

    private String buttonName;
    private String errorMassage;

    private int buttonStringWidth,buttonStringHeight;


    public CalculateButton(float angle, String weightText, String distanceText, float positionX, float positionY, float width, float height, String buttonName, int buttonStringWidth, int buttonStringHeight) {
        this.angle = angle;
        this.weight = weightText;
        this.distance = distanceText;
        this.isPushed = false;
        this.errorMassage = "";

        this.buttonName = buttonName;

        this.buttonStringHeight = buttonStringHeight;
        this.buttonStringWidth = buttonStringWidth;

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
            if (mouseY>this.positionY && mouseY<this.positionY+this.height && mouseX >this.positionX && mouseX < this.positionX+this.width && weight.length()>0){
                this.isPushed = true;
                this.errorMassage = "";
                calculations.update(gameContainer, angle, weight, distance);
            } else if(mouseY>this.positionY && mouseY<this.positionY+this.height && mouseX >this.positionX && mouseX < this.positionX+this.width && weight.length()<=0){
                this.errorMassage = "Kein Gewicht im Eingabefeld angegeben!";
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics, TrueTypeFont errorMessageFont, TrueTypeFont writing) throws SlickException {
        graphics.setColor(Color.black);
        graphics.fillRoundRect(this.positionX,this.positionY,this.width,this.height,4);
        graphics.setColor(Color.white);
        graphics.drawString(this.buttonName,this.positionX + (this.width-this.buttonStringWidth)/2,this.positionY+(this.height-this.buttonStringHeight)/2);
        graphics.setColor(Color.red);
        graphics.setFont(errorMessageFont);
        int errorMassageWidth = errorMessageFont.getWidth(this.errorMassage);
        graphics.drawString(this.errorMassage,(gameContainer.getWidth()-errorMassageWidth)/2,300);
        graphics.setFont(writing);
        graphics.setColor(Color.white);
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
