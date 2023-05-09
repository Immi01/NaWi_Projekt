package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ValueButton implements Actor {
    private float x, y, width, xSubtractionButton, xAdditionButton, buttonCircleRadius;

    public ValueButton(float x, float y, float width) {
        this.x = x;
        this.y = y;
        this.buttonCircleRadius = 35;
        this.width = width;
        this.xSubtractionButton = this.x - this.width / 2;
        this.xAdditionButton = this.x + this.width / 2;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public float getWidth() {
        return width;
    }

    public float getButtonCircleRadius() {
        return buttonCircleRadius;
    }

    public float getxSubtractionButton() {
        return xSubtractionButton;
    }

    public float getxAdditionButton() {
        return xAdditionButton;
    }

    @Override
    public void render(Graphics graphics) {
        float minusWidth = graphics.getFont().getWidth("-");
        float plusWidth = graphics.getFont().getWidth("+");
        graphics.setColor(Color.red);
        graphics.drawString("-", xSubtractionButton + this.buttonCircleRadius / 2 - minusWidth / 2, this.y + buttonCircleRadius / 2 - minusWidth);
        graphics.drawOval(xSubtractionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.green);
        graphics.drawString("+", xAdditionButton + this.buttonCircleRadius / 2 - plusWidth / 2, this.y + buttonCircleRadius / 2 - plusWidth);
        graphics.drawOval(xAdditionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }
}
