package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button implements Actor {

    private float x, y, width, height;
    private String text;
    private Color color;

    public Button(float x, float y, float width, float height, String text, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        graphics.drawRoundRect(this.x, this.y, this.width, this.height, 10);
        int textWidth = graphics.getFont().getWidth(this.text);
        int textHeight = graphics.getFont().getHeight(this.text);
        graphics.drawString(this.text, this.x + (this.width - textWidth) / 2, this.y + this.height / 2 - (float) textHeight / 2);
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, int delta) {

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

    public float getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

}
