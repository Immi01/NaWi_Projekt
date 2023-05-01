package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class ValueButton implements Actor {
    private float x, y, width, xSubtractionButton, xAdditionButton, buttonCircleRadius;

    public ValueButton(int x, int y, int width) {
        this.x = x;
        this.y = y;
        this.buttonCircleRadius = 30;
        this.width = width;
        this.xSubtractionButton = this.x - this.width / 2;
        this.xAdditionButton = this.x + this.width / 2;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
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
        graphics.setColor(Color.red);
        graphics.drawString("-", this.x - this.width / 2 + 10, this.y + 5);
        graphics.drawOval(xSubtractionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.green);
        graphics.drawString("+", this.x + this.width / 2 + 10, this.y + 5);
        graphics.drawOval(xAdditionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }
}
