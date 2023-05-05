package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class InputFieldRN {
    private String value = "1";
    private String placeholder = "KG value";
    private int maxLength = 4;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean selected = false;
    private int cursorPos = 0;
    private int cursorBlinkTimer = 0;
    private Calculations calculations;

    public InputFieldRN(int x, int y, int width, int height, int maxLength) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.maxLength = maxLength;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(Color.black);
        graphics.drawRect(x, y, width, height);

        if (selected) {
            graphics.setColor(Color.black);
            graphics.drawString(value, x + 5, y + 5);
            if (cursorBlinkTimer < 250) {
                graphics.drawLine(x + 5 + cursorPos * 10, y + 2, x + 5 + cursorPos * 10, y + height - 2);
            }
        } else {
            if (value.isEmpty()) {
                graphics.setColor(Color.gray);
                graphics.drawString(placeholder, x + 5, y + 5);
            } else {
                graphics.setColor(Color.black);
                graphics.drawString(value, x + 5, y + 5);
            }
        }
    }

    public void update(int delta) {
        cursorBlinkTimer += delta;
        if (cursorBlinkTimer >= 1000) {
            cursorBlinkTimer -= 1000;
        }
    }


    public boolean isMouseOver(int mouseX, int mouseY) {
        return mouseX >= x && mouseX < x + width && mouseY >= y && mouseY < y + height;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
        cursorPos = value.length();
    }

    public void keyPressed(int key, char c) {
        if (selected) {
            if (key == Input.KEY_BACK && value.length() > 0 && cursorPos > 0) {
                // Backspace
                value = value.substring(0, cursorPos - 1) + value.substring(cursorPos);
                cursorPos--;
            } else if (key == Input.KEY_DELETE && cursorPos < value.length()) {
                // Delete
                value = value.substring(0, cursorPos) + value.substring(cursorPos + 1);
            } else if (key == Input.KEY_LEFT && cursorPos > 0) {
                // Move cursor left
                cursorPos--;
            } else if (key == Input.KEY_RIGHT && cursorPos < value.length()) {
                // Move cursor right
                cursorPos++;
            } else if (key == Input.KEY_END) {
                // Move cursor to end
                cursorPos = value.length();
            } else if (key == Input.KEY_HOME) {
                // Move cursor to beginning
                cursorPos = 0;
            } else if (Character.isDigit(c) && value.length() < maxLength && cursorPos < maxLength) {
                // Add digit to input field if length < maxLength
                value = value.substring(0, cursorPos) + c + value.substring(cursorPos);
                cursorPos++;

                if (cursorPos > maxLength) {
                    cursorPos = maxLength;
                }
            }
        }
    }


    public String getValue() {
        return value;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public String getText() {
        return value;
    }
}
