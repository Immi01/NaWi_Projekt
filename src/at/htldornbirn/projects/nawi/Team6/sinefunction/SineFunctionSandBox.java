package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class SineFunctionSandBox extends BasicGameState {
    private List<Actor> actors;
    private Button stateButton1;
    private Button stateButton2;
    private ValueButton valueButton1;
    private ValueButton valueButton2;
    private ValueButton valueButton3;
    private SineFunction sineFunction1;
    private SineFunction sineFunction2;

    public int getID() {
        return 2;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.stateButton1 = new Button((float) gameContainer.getWidth() / 2, gameContainer.getHeight(), 175, 100, "Go to explanation", Color.red);
        this.stateButton1.setX((float) gameContainer.getWidth() / 3 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) gameContainer.getHeight() * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.stateButton2 = new Button((float) gameContainer.getWidth() / 2, gameContainer.getHeight(), 175, 100, "Interference", Color.cyan);
        this.stateButton2.setX((float) gameContainer.getWidth() * 0.66f - this.stateButton2.getWidth() / 2);
        this.stateButton2.setY((float) gameContainer.getHeight() * 9 / 10 - this.stateButton2.getHeight() / 2);
        this.actors.add(this.stateButton1);
        this.actors.add(this.stateButton2);

        float heightValueButtons = (float) (gameContainer.getHeight() / 7);
        this.valueButton1 = new ValueButton((float) (gameContainer.getWidth() / 3), heightValueButtons, 50);
        this.valueButton2 = new ValueButton((float) (gameContainer.getWidth() * 6 / 10), heightValueButtons, 50);
        this.valueButton3 = new ValueButton((float) (gameContainer.getWidth() * 8 / 10), heightValueButtons, 50);
        this.actors.add(this.valueButton1);
        this.actors.add(this.valueButton2);
        this.actors.add(this.valueButton3);

        double containerHeight = gameContainer.getHeight();
        double containerWidth = gameContainer.getWidth();

        this.sineFunction1 = new SineFunction(5000, containerWidth, containerHeight / 2, Color.orange);
        this.sineFunction2 = new SineFunction(5000, containerWidth, containerHeight / 2, Color.green);

        Axes xAxes = new Axes(0, (float) containerHeight / 2, (float) containerWidth, 1, "x", (float) containerWidth * 0.97f, (float) containerHeight / 2 + 5);
        Axes yAxes = new Axes((float) 0, 0, 1, (float) containerHeight * 0.97f, "sin(x)", 5, 30);
        this.actors.add(xAxes);
        this.actors.add(yAxes);
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.yellow);
        graphics.drawString("Sandbox", (float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15);
        graphics.setColor(Color.white);

        Locale locale = new Locale("en", "UK");
        String pattern = "###.#####";
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        double currentDisplacementX = this.sineFunction1.getSineComponents().get(0).getDisplacementX() / Math.PI;
        String currentDisplacementXFormatted = decimalFormat.format(currentDisplacementX);

        String stringDisplacementX = "Displacement x Axes: ";
        float widthXLabel = graphics.getFont().getWidth(stringDisplacementX);
        String stringDisplacementY = "Displacement y Axes: ";
        float widthYLabel = graphics.getFont().getWidth(stringDisplacementX);
        String stringAmplitude = "Amplitude: ";
        float widthAmplitudeLabel = graphics.getFont().getWidth(stringDisplacementX);

        float heightValueButtonLabels = (float) (gameContainer.getHeight() / 10);

        graphics.drawString(stringDisplacementX + currentDisplacementXFormatted + " pi RAD", (float) (gameContainer.getWidth() / 3 - widthXLabel / 2), heightValueButtonLabels);
        graphics.drawString(stringDisplacementY + this.sineFunction1.getSineComponents().get(0).getDisplacementY() / 100, (float) (gameContainer.getWidth() * 6 / 10 - widthYLabel / 2), heightValueButtonLabels);
        graphics.drawString(stringAmplitude + this.sineFunction1.getSineComponents().get(0).getAmplitude() / 100, (float) (gameContainer.getWidth() * 8.25 / 10 - widthAmplitudeLabel / 2), heightValueButtonLabels);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        for (SineComponent component : this.sineFunction1.getSineComponents()) {
            component.render(graphics);
        }
        for (SineComponent component : this.sineFunction2.getSineComponents()) {
            component.render(graphics);
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
            sineComponent.update(gameContainer, i);
        }
        for (SineComponent sineComponent : this.sineFunction2.getSineComponents()) {
            sineComponent.update(gameContainer, i);
        }

        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(1);
            }
        }

        if ((posX > this.stateButton2.getX() && posX < this.stateButton2.getX() + this.stateButton2.getWidth()) && (posY > gameContainer.getHeight() - (stateButton2.getY() + stateButton2.getHeight()) && posY < gameContainer.getHeight() - stateButton2.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(3);
            }
        }

        if ((posX > this.valueButton1.getxSubtractionButton() && posX < this.valueButton1.getxSubtractionButton() + this.valueButton1.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - this.valueButton1.getButtonCircleRadius() - this.valueButton1.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementX(sineComponent.getDisplacementX() - Math.PI / 64);
                }
            }
        }

        if ((posX > this.valueButton1.getxAdditionButton() && posX < this.valueButton1.getxAdditionButton() + this.valueButton1.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - this.valueButton1.getButtonCircleRadius() - this.valueButton1.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementX(sineComponent.getDisplacementX() + Math.PI / 64);
                }
            }
        }

        if ((posX > this.valueButton2.getxSubtractionButton() && posX < this.valueButton2.getxSubtractionButton() + this.valueButton2.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - this.valueButton2.getButtonCircleRadius() - this.valueButton2.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementY(sineComponent.getDisplacementY() - 1);
                }
            }
        }

        if ((posX > this.valueButton2.getxAdditionButton() && posX < this.valueButton2.getxAdditionButton() + this.valueButton2.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - this.valueButton2.getButtonCircleRadius() - this.valueButton2.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementY(sineComponent.getDisplacementY() + 1);
                }
            }
        }

        if ((posX > this.valueButton3.getxSubtractionButton() && posX < this.valueButton3.getxSubtractionButton() + this.valueButton3.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - this.valueButton3.getButtonCircleRadius() - this.valueButton3.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    if (sineComponent.getAmplitude() > 0) {
                        sineComponent.setAmplitude(sineComponent.getAmplitude() - 1);
                    }
                }
            }
        }

        if ((posX > this.valueButton3.getxAdditionButton() && posX < this.valueButton3.getxAdditionButton() + this.valueButton3.getButtonCircleRadius()) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - this.valueButton3.getButtonCircleRadius() - this.valueButton3.getY())) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    if (sineComponent.getAmplitude() <= 2.5 * sineComponent.getAmplitudeFactor()) {
                        sineComponent.setAmplitude(sineComponent.getAmplitude() + 1);
                    }
                }
            }
        }

        for (Actor actor : this.actors) {
            actor.update(gameContainer, i);
        }

        for (SineComponent sineComponent : sineFunction1.getSineComponents()) {
            double angleOfComponent = sineComponent.getPositionRelative() * 2 * Math.PI * sineComponent.getAmountOfDurations() + sineComponent.getDisplacementX();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + gameContainer.getHeight() / 2 - sineComponent.getDisplacementY()));
        }
    }
}
