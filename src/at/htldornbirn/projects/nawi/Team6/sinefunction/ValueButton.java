package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.*;

public class ValueButton implements Actor {
    private float x, y, width, xSubtractionButton, xAdditionButton, buttonCircleRadius;
    private AngelCodeFont font;

    public ValueButton(float x, float y, float width) throws SlickException {
        this.x = x;
        this.y = y;
        this.buttonCircleRadius = 35;
        this.width = width;
        this.xSubtractionButton = this.x - this.width / 2;
        this.xAdditionButton = this.x + this.width / 2;
        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
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

    public float getButtonCircleRadius() {
        return buttonCircleRadius;
    }

    public float getxSubtractionButton() {
        return xSubtractionButton;
    }

    public float getxAdditionButton() {
        return xAdditionButton;
    }

    @Override
    public void render(Graphics graphics) {
        float minusWidth = font.getWidth("-");
        float minusHeight = font.getHeight("-");
        float plusWidth = font.getWidth("+");
        float plusHeight = font.getHeight("+");
        graphics.setColor(Color.red);
        font.drawString(xSubtractionButton + this.buttonCircleRadius / 2 - minusWidth / 2, this.y - minusHeight + buttonCircleRadius / 2, "-", Color.red);
        graphics.drawOval(xSubtractionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.green);
        font.drawString(xAdditionButton + this.buttonCircleRadius / 2 - plusWidth / 2, this.y - plusHeight * 3 / 4 + buttonCircleRadius / 2, "+", Color.green);
        graphics.drawOval(xAdditionButton, this.y, this.buttonCircleRadius, this.buttonCircleRadius);
        graphics.setColor(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
    }
}
