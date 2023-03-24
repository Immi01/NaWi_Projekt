package at.rangel.games.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class SineComponent implements Actor {
    public float x, y;
    public double amplitude;
    public double displacementX, displacementY;
    public double positionRelative, amountOfDurations;

    public SineComponent() {
        this.x = x;
        this.y = y;
        this.positionRelative = positionRelative;
        this.amplitude = 100;
        this.amountOfDurations = 10;
        this.displacementX = displacementX;
        this.displacementY = displacementY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, 2, 2);
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
