package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Interference extends BasicGameState {
    private List<Actor> actors;
    private List<SineFunction> sineFunctions;
    private Button stateButton1;
    private SineFunction sineFunction1;
    private SineFunction sineFunction2;
    private SineFunction sineFunction3;

    @Override
    public int getID() {
        return 3;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        double containerHeight = gameContainer.getHeight();
        double containerWidth = gameContainer.getWidth();

        this.actors = new ArrayList<>();
        this.sineFunctions = new ArrayList<>();
        this.stateButton1 = new Button((float) gameContainer.getWidth() / 2, gameContainer.getHeight() - 150, 175, 100, "Go to sandbox", Color.yellow);
        this.stateButton1.setX((float) gameContainer.getWidth() / 2 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) gameContainer.getHeight() * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.actors.add(stateButton1);

        int amountOfComponents = 2000;
        this.sineFunction1 = new SineFunction(amountOfComponents, containerWidth, containerHeight / 2, Color.blue);
        this.sineFunction2 = new SineFunction(amountOfComponents, containerWidth, containerHeight / 2, Color.green);
        this.sineFunction3 = new SineFunction(amountOfComponents, containerWidth, containerHeight / 2, Color.red);
        this.sineFunctions.add(sineFunction1);
        this.sineFunctions.add(sineFunction2);
        this.sineFunctions.add(sineFunction3);

        Axes xAxes = new Axes(0, (float) containerHeight / 2, (float) containerWidth, 1, "x", (float) containerWidth * 0.97f, (float) containerHeight / 2 + 5);
        Axes yAxes = new Axes((float) 0, 0, 1, (float) containerHeight * 0.97f, "sin(x)", 5, 30);
        this.actors.add(xAxes);
        this.actors.add(yAxes);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.cyan);
        graphics.drawString("Interference", (float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15);
        float labelsHeight = (float) gameContainer.getHeight() * 1 / 10;
        int amountOfLabels = 3;
        float labelWidthDistance = (float) gameContainer.getHeight() / (amountOfLabels);
        graphics.setColor(Color.blue);
        graphics.drawString("--- Incident Wave", labelWidthDistance, labelsHeight);
        graphics.setColor(Color.green);
        graphics.drawString("--- Reflecting Wave", labelWidthDistance * 2, labelsHeight);
        graphics.setColor(Color.red);
        graphics.drawString("--- Resulting Wave", labelWidthDistance * 3, labelsHeight);

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        for (SineFunction sineFunction : this.sineFunctions) {
            for (SineComponent sineComponent : sineFunction.getSineComponents()) {
                sineComponent.render(graphics);
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();

        for (SineComponent sineComponent : sineFunction1.getSineComponents()) {
            sineComponent.setDisplacementX(sineComponent.getDisplacementX() - Math.PI / 64);
            double angleOfComponent = sineComponent.getPositionRelative() * 2 * Math.PI * sineComponent.getAmountOfDurations() + sineComponent.getDisplacementX();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + gameContainer.getHeight() / 2 - sineComponent.getDisplacementY()));
        }

        for (SineComponent sineComponent : sineFunction2.getSineComponents()) {
            sineComponent.setDisplacementX(sineComponent.getDisplacementX() + Math.PI / 64);
            double angleOfComponent = sineComponent.getPositionRelative() * 2 * Math.PI * sineComponent.getAmountOfDurations() + sineComponent.getDisplacementX();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + gameContainer.getHeight() / 2 - sineComponent.getDisplacementY()));
        }

        for (int j = 1; j < sineFunction3.getSineComponents().size(); j++) {
            sineFunction3.getSineComponents().get(j).setY((float) (sineFunction1.getSineComponents().get(j).getY() + sineFunction2.getSineComponents().get(j).getY() - sineFunction3.getHeight()));
        }

        int posX = Mouse.getX();
        int posY = Mouse.getY();
        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }
    }
}
