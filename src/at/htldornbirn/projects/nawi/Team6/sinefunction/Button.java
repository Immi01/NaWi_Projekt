package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button implements Actor {

    private float x, y, width, height;
    private String text;

    public Button(int x, int y, int width, int height, String text) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
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

    public float getHeight() {
        return height;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.yellow);
        graphics.drawRoundRect(this.x, this.y, this.width, this.height, 10);
        int textWidth = graphics.getFont().getWidth(this.text);
        int textHeight = graphics.getFont().getHeight(this.text);
        graphics.drawString(this.text, this.x + (this.width - textWidth) / 2, this.y + this.height / 2 - (float) textHeight / 2);
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, int delta) {

    }

}
