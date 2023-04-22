package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

import java.util.ArrayList;
import java.util.List;

public class SineFunction implements Actor {

    private int amountOfComponents;
    private double width, height;
    private List<SineComponent> sineComponents;

    public SineFunction(int amountOfComponents, double width, double height) {
        this.amountOfComponents = amountOfComponents;
        this.width = width;
        this.height = height;
        this.sineComponents = new ArrayList<>();

        for (int i = 1; i <= amountOfComponents; i++) {
            SineComponent sineComponent = new SineComponent();
            this.sineComponents.add(sineComponent);

            double positionRelative = (double) i / amountOfComponents;
            sineComponent.setPositionRelative(positionRelative);
            sineComponent.setX((float) (positionRelative * width));

            double angleOfComponent = positionRelative * 360 * Math.PI / (180) * sineComponent.getAmountOfDurations();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + height / 2));
        }
    }

    @Override
    public void render(Graphics graphics) {
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }

    public int getAmountOfComponents() {
        return amountOfComponents;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }

    public List<SineComponent> getSineComponents() {
        return sineComponents;
    }
}
