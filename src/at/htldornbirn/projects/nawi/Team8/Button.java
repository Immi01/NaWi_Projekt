package at.htldornbirn.projects.nawi.Team8;

import org.newdawn.slick.AngelCodeFont;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Button implements Actor {

    private float x, y, width, height;
    private String text;
    private Color color;
    private AngelCodeFont font;

    public Button(float x, float y, float width, float height, String text, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
        this.font = font;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        int cornerRadius = (int) this.width / 10;
        graphics.drawRoundRect(this.x, this.y, this.width, this.height, cornerRadius);
        int textWidth = font.getWidth(this.text);
        int textHeight = font.getHeight(this.text);
        font.drawString(this.x + (this.width - textWidth) / 2, this.y + this.height / 2 - (float) textHeight / 2, this.text, this.color);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
