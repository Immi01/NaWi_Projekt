package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class SineComponent implements Actor {
    private float x, y, componentRadius;
    private double amplitude, amplitudeFactor;
    private double displacementX, displacementY;
    private double positionRelative, amountOfDurations;
    public SineComponent() {

        this.x = x;
        this.y = y;
        this.componentRadius = 2;
        this.positionRelative = positionRelative;
        this.amplitudeFactor = 100;
        this.amplitude = 1 * amplitudeFactor;
        this.amountOfDurations = 10;
        this.displacementX = displacementX;
        this.displacementY = displacementY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawOval(this.x, this.y, this.componentRadius, this.componentRadius);
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

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public double getAmplitude() {
        return amplitude;
    }

    public double getAmplitudeFactor() {
        return amplitudeFactor;
    }

    public double getDisplacementX() {
        return displacementX;
    }

    public double getDisplacementY() {
        return displacementY;
    }

    public double getPositionRelative() {
        return positionRelative;
    }

    public double getAmountOfDurations() {
        return amountOfDurations;
    }

    public void setX(float x) {
        this.x = x;
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setAmplitude(double amplitude) {
        this.amplitude = amplitude;
    }

    public void setDisplacementX(double displacementX) {
        this.displacementX = displacementX;
    }

    public void setDisplacementY(double displacementY) {
        this.displacementY = displacementY;
    }

    public void setPositionRelative(double positionRelative) {
        this.positionRelative = positionRelative;
    }
}
