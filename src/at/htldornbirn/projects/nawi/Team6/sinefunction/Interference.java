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
    private StateButton stateButton1;
    private SineFunction sineFunction1;
    private SineFunction sineFunction2;
    private SineFunction sineFunction3;
    private AngelCodeFont font;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;

    @Override
    public int getID() {
        return 63;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");

        this.actors = new ArrayList<>();
        this.sineFunctions = new ArrayList<>();
        this.stateButton1 = new StateButton((float) WIDTH / 2, HEIGHT - 150, 250, 100, "Go to sandbox", Color.yellow);
        this.stateButton1.setX((float) WIDTH / 2 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) HEIGHT * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.actors.add(stateButton1);

        int amountOfComponents = 2000;
        this.sineFunction1 = new SineFunction(amountOfComponents, WIDTH, HEIGHT / 2, Color.blue);
        this.sineFunction2 = new SineFunction(amountOfComponents, WIDTH, HEIGHT / 2, Color.green);
        this.sineFunction3 = new SineFunction(amountOfComponents, WIDTH, HEIGHT / 2, Color.red);
        this.sineFunctions.add(sineFunction1);
        this.sineFunctions.add(sineFunction2);
        this.sineFunctions.add(sineFunction3);

        Axes xAxes = new Axes(0, (float) HEIGHT / 2, (float) WIDTH, 1, "x", (float) WIDTH * 0.97f, (float) HEIGHT / 2 + 5);
        Axes yAxes = new Axes((float) 0, 0, 1, (float) HEIGHT * 0.97f, "sin(x,t)", 5, 30);
        this.actors.add(xAxes);
        this.actors.add(yAxes);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15, "Interference", Color.cyan);
        int amountOfLabels = 3;
        float fontFactor = 0.8f;
        float labelsHeight = (float) gameContainer.getHeight() * 1 / 10 / fontFactor;
        float labelWidthDistance = (float) gameContainer.getHeight() / (amountOfLabels) / fontFactor;
        graphics.scale(fontFactor, fontFactor);
        font.drawString(labelWidthDistance, labelsHeight, "--- Incident Wave", Color.blue);
        font.drawString(labelWidthDistance * 2, labelsHeight, "--- Reflecting Wave", Color.green);
        font.drawString(labelWidthDistance * 3, labelsHeight, "--- Resulting Wave", Color.red);
        graphics.scale(1 / fontFactor, 1 / fontFactor);
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
                stateBasedGame.enterState(62);
            }
        }
    }
}
