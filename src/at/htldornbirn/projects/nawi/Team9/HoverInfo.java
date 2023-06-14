package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;

import java.awt.*;

public class HoverInfo {
    private float x;
    private float y;
    private float width;
    private float height;
    private Font font;
    private String creatorInfo;
    private boolean isHovered;

    public HoverInfo(float x, float y, String creator1, String creator2) {
        this.x = x;
        this.y = y;
        this.width = 300;
        this.height = 20;
        this.font = defaultFont();
        this.creatorInfo = "Creators:\n" + creator1 + ", \n" + creator2;
        this.isHovered = false;
    }

    public void render(Graphics graphics) {
        graphics.setColor(Color.cyan);
        graphics.fillRect(10, 30, 37, 20);
        graphics.setColor(Color.black);
        graphics.drawString(" info", 10, 30);
        if (isHovered) {
            graphics.setColor(Color.cyan);
            graphics.fillRect(x, y, width, height);

            graphics.setColor(Color.black);
            graphics.setFont(font);
            float textX = x + (width - font.getWidth(creatorInfo)) / 2;
            float textY = y + (height - font.getHeight(creatorInfo)) / 2;
            graphics.drawString(creatorInfo, textX, textY);
        }
    }

    public void update(Input input) {
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if (contains(mouseX, mouseY)) {
            isHovered = true;
        } else {
            isHovered = false;
        }
    }

    private boolean contains(int x, int y) {
        return x >= this.x && x <= this.x + width && y >= this.y && y <= this.y + height;
    }

    private Font defaultFont() {
        return new TrueTypeFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 12), true);
    }
}
