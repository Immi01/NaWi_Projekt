package at.rangel.games.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Axes implements Actor {
    public float x, y;
    public float width, height;

    public Axes(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x, this.y, this.width, this.height);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {
        if (this.x > gameContainer.getWidth()) {
            this.x = 0;
        }
        if (this.x < 0) {
            this.x = gameContainer.getWidth();
        }
    }
}
