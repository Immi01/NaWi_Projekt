package at.htldornbirn.projects.nawi.Team6.Gravitation;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.RoundedRectangle;

import java.awt.*;

public class RoundedRectExample {
    private float x, y;
    private float width, height;
    private float cornerRadius;
    private String text;
    private float textWidth;
    private float textHeight;
    private String color;

    private RoundedRectangle roundedRect;
    private TrueTypeFont font;

    public RoundedRectExample(float x, float y, float width, float height, float cornerRadius, String text, String color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.cornerRadius = cornerRadius;
        this.text = text;
        this.color = color;

        font = new TrueTypeFont(new Font("Arial", Font.PLAIN, 16), true);
        roundedRect = new RoundedRectangle(x, y, width, height, cornerRadius);
        textWidth = font.getWidth(text);
        textHeight = font.getHeight(text);
    }

    public void render (Graphics g){
        g.setColor(Color.white);
        g.setFont(font);

        if(this.color == "white"){
            g.setColor(Color.white);
            g.draw(roundedRect);
            g.drawString(text, roundedRect.getX() + (width / 2 - textWidth / 2), roundedRect.getY() + (height / 2 - textHeight / 2));
        } else if(this.color == "black"){
            g.setColor(Color.black);
            g.draw(roundedRect);
            g.drawString(text, roundedRect.getX() + (width / 2 - textWidth / 2), roundedRect.getY() + (height / 2 - textHeight / 2));
        }
    }

    public boolean isClicked(float mouseX, float mouseY) {
        return roundedRect.contains(mouseX, mouseY);
    }
}
