package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.TrueTypeFont;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

import java.awt.*;

public class Button {
    private float x;
    private float y;
    private float width;
    private float height;
    private String label;
    private Font font;
    private Color textColor;
    private Color backgroundColor;
    private Color pressedColor;
    private Rectangle bounds;
    private boolean isPressed;

    public Button(float x, float y, float width, float height, String label) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.label = label;
        this.font = defaultFont();
        this.textColor = Color.black;
        this.backgroundColor = Color.cyan;
        this.pressedColor = Color.blue;
        this.bounds = new Rectangle(x, y, width, height);
        this.isPressed = false;
    }

    public void render(Graphics graphics) {
        Color currentColor = isPressed ? pressedColor : backgroundColor;
        graphics.setColor(currentColor);
        graphics.fillRoundRect(x, y, width, height, 10);

        graphics.setColor(textColor);
        graphics.setFont(font);
        float labelX = x + (width - font.getWidth(label)) / 2;
        float labelY = y + (height - font.getHeight(label)) / 2;
        graphics.drawString(label, labelX, labelY);
    }

    public void update(Input input, StateBasedGame game, int delta) {
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();

        if (bounds.contains(mouseX, mouseY)) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                isPressed = true;
            } else {
                if (isPressed) {
                    // Button is clicked, perform actions here
                    System.out.println("Button clicked!");
                }
                isPressed = false;
            }
        } else {
            isPressed = false;
        }
    }

    private Font defaultFont() {
        // You can modify this method to change the default font of the button
        // Example:
        return new TrueTypeFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 16), true);
    }
}
