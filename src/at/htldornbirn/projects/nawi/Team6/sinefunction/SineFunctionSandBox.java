package at.htldornbirn.projects.nawi.Team6.sinefunction;

import at.htldornbirn.projects.nawi.Constants;
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
    private StateButton stateButton1;
    private StateButton stateButton2;
    private ValueButton valueButton1;
    private ValueButton valueButton2;
    private ValueButton valueButton3;
    private SineFunction sineFunction1;
    private SineFunction sineFunction2;
    private AngelCodeFont font;
    private static final int WIDTH = 1280;
    private static final int HEIGHT = 960;

    public int getID() {
        return 62;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.stateButton1 = new StateButton((float) WIDTH / 2, HEIGHT, 250, 100, "Go to explanation", Color.red);
        this.stateButton1.setX((float) WIDTH * 0.33f - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) HEIGHT * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.stateButton2 = new StateButton((float) WIDTH / 2, HEIGHT, 250, 100, "Interference", Color.cyan);
        this.stateButton2.setX((float) WIDTH * 2 / 3 - this.stateButton2.getWidth() / 2);
        this.stateButton2.setY((float) HEIGHT * 9 / 10 - this.stateButton2.getHeight() / 2);
        this.actors.add(this.stateButton1);
        this.actors.add(this.stateButton2);

        float heightValueButtons = (float) (HEIGHT / 7);
        this.valueButton1 = new ValueButton((float) (WIDTH / 3), heightValueButtons, 75);
        this.valueButton2 = new ValueButton((float) (WIDTH * 6 / 10), heightValueButtons, 75);
        this.valueButton3 = new ValueButton((float) (WIDTH * 8 / 10), heightValueButtons, 75);
        this.actors.add(this.valueButton1);
        this.actors.add(this.valueButton2);
        this.actors.add(this.valueButton3);

        this.sineFunction1 = new SineFunction(3000, WIDTH, HEIGHT / 2, Color.orange);
        this.sineFunction2 = new SineFunction(3000, WIDTH, HEIGHT / 2, Color.green);

        Axes xAxes = new Axes(0, (float) HEIGHT / 2, (float) WIDTH, 1, "x", (float) WIDTH * 0.97f, (float) HEIGHT / 2 + 5);
        Axes yAxes = new Axes((float) 0, 0, 1, (float) HEIGHT * 0.97f, "sin(x,t)", 5, 30);
        this.actors.add(xAxes);
        this.actors.add(yAxes);

        font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15, "Sandbox", Color.yellow);
        graphics.setColor(Color.white);

        Locale locale = new Locale("en", "UK");
        String pattern = "###.#####";
        DecimalFormat decimalFormat = (DecimalFormat)
                NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        double currentDisplacementX = this.sineFunction1.getSineComponents().get(0).getDisplacementX() / Math.PI;
        String currentDisplacementXFormatted = decimalFormat.format(currentDisplacementX);

        String stringDisplacementX = "Phase difference: ";
        float widthXLabel = graphics.getFont().getWidth(stringDisplacementX);
        String stringDisplacementY = "Displacement y Axes: ";
        float widthYLabel = graphics.getFont().getWidth(stringDisplacementX);
        String stringAmplitude = "Amplitude: ";
        float widthAmplitudeLabel = graphics.getFont().getWidth(stringDisplacementX);

        float fontFactor = 0.7f;
        float heightValueButtonLabels = (float) (gameContainer.getHeight() / 10) / fontFactor;

        graphics.scale(fontFactor, fontFactor);
        font.drawString((float) (gameContainer.getWidth() / 3 - widthXLabel / 2) / fontFactor, heightValueButtonLabels, stringDisplacementX + currentDisplacementXFormatted + " pi RAD");
        font.drawString((float) (gameContainer.getWidth() * 6 / 10 - widthYLabel / 2) / fontFactor, heightValueButtonLabels, stringDisplacementY + this.sineFunction1.getSineComponents().get(0).getDisplacementY() / 100);
        font.drawString((float) (gameContainer.getWidth() * 8.25 / 10 - widthAmplitudeLabel / 2) / fontFactor, heightValueButtonLabels, stringAmplitude + this.sineFunction1.getSineComponents().get(0).getAmplitude() / 100);
        graphics.scale(1 / fontFactor, 1 / fontFactor);
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
                stateBasedGame.enterState(Constants.TEAM6);
            }
        }

        if ((posX > this.stateButton2.getX() && posX < this.stateButton2.getX() + this.stateButton2.getWidth()) && (posY > gameContainer.getHeight() - (stateButton2.getY() + stateButton2.getHeight()) && posY < gameContainer.getHeight() - stateButton2.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(63);
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
