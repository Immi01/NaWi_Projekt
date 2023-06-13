package at.htldornbirn.projects.nawi.Team6.Gravitation;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.geom.Shape;

import java.awt.*;

public class Button {
    private Shape shape;
    private Color color;
    private String text;
    private float textWidth, textHeight;
    private float centerX, centerY;
    private TrueTypeFont font;

    public Button(float x, float y, float radius, Color color, String text) {
        this.shape = new Circle(x, y, radius);
        this.color = color;
        this.text = text;

        this.centerX = shape.getCenterX();
        this.centerY = shape.getCenterY();

        font = new TrueTypeFont(new Font("Arial", Font.PLAIN, 16), true);
        textWidth = font.getWidth(text);
        textHeight = font.getHeight(text);
    }

    public void render(Graphics g) {
        g.setColor(color);
        g.draw(shape);
        g.setFont(font);
        g.drawString(text, shape.getCenterX() - textWidth / 2, shape.getCenterY() - textHeight / 2);
    }

    public boolean isClicked(float mouseX, float mouseY) {
        return shape.contains(mouseX, mouseY);
    }

    public float getCenterX() {
        return centerX;
    }

    public float getCenterY() {
        return centerY;
    }
}