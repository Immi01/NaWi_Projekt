package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button implements Actor {

    private float x, y, width, height;

    public Button(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
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

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }

    public void render(Graphics graphics) {
        graphics.drawRoundRect(this.x, this.y, this.width, this.height, 10);
    }

    public void update(GameContainer gameContainer, int delta) {

    }

}
