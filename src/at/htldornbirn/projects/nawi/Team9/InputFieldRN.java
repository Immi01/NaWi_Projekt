package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;

public class InputFieldRN {
    private String value = "";
    private String placeholder = "Enter kg value";
    private int maxLength;
    private int x;
    private int y;
    private int width;
    private int height;
    private boolean selected = false;
    private int cursorPos = 0;
    private int cursorBlinkTimer = 0;

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
            graphics.drawLine(x + cursorPos, y + 2, x + cursorPos, y + height - 2);
        }
        if (value.isEmpty()) {
            graphics.setColor(Color.gray);
            graphics.drawString(placeholder, x + 5, y + 5);
        } else {
            graphics.setColor(Color.black);
            graphics.drawString(value, x + 5, y + 5);
        }
    }

    public void update(int delta) {
        cursorBlinkTimer += delta;
        if (cursorBlinkTimer >= 500) {
            cursorBlinkTimer = 0;
        }
        System.out.println(value);
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
            if (key == Input.KEY_BACK && value.length() > 0) {
// Backspace
                value = value.substring(0, value.length() - 1);
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
            } else if (Character.isLetterOrDigit(c) || Character.isWhitespace(c) || Character.getType(c) == Character.CONNECTOR_PUNCTUATION) {
// Add character to input field
                if (value.length() < maxLength) {
                    value = value.substring(0, cursorPos) + c + value.substring(cursorPos);
                    cursorPos++;
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
}
