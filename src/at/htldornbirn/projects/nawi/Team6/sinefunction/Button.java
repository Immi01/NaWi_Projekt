package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.*;

public class Button implements Actor {

    private float x, y, width, height;
    private String text;
    private Color color;
    private AngelCodeFont font;

    public Button(float x, float y, float width, float height, String text, Color color) throws SlickException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.text = text;
        this.color = color;
        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
    }

    public void render(Graphics graphics) {
        graphics.setColor(this.color);
        int cornerRadius = (int) this.width / 10;
        graphics.drawRoundRect(this.x, this.y, this.width, this.height, cornerRadius);
        int textWidth = font.getWidth(this.text);
        int textHeight = font.getHeight(this.text);
        font.drawString(this.x + (this.width - textWidth) / 2, this.y + this.height / 2 - (float) textHeight / 2, this.text, this.color);
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
