package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

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
        this.stateButton1 = new Button(675, gameContainer.getHeight() - 150, 175, 100, "Go to explanation");
        this.actors.add(this.stateButton1);
        this.stateButton2 = new Button(975, gameContainer.getHeight() - 150, 175, 100, "Interference");
        this.actors.add(this.stateButton2);

        this.valueButton1 = new ValueButton(500, 130, 50);
        this.actors.add(this.valueButton1);
        this.valueButton2 = new ValueButton(800, 130, 50);
        this.actors.add(this.valueButton2);
        this.valueButton3 = new ValueButton(1100, 130, 50);
        this.actors.add(this.valueButton3);

        double containerHeight = gameContainer.getHeight();
        double containerWidth = gameContainer.getWidth();

        this.sineFunction1 = new SineFunction(5000, containerWidth, containerHeight);
        this.sineFunction2 = new SineFunction(2500, containerWidth, containerHeight);

        Axes xAxes = new Axes(0, (float) containerHeight / 2, (float) containerWidth, 1);
        this.actors.add(xAxes);
        Axes yAxes = new Axes((float) 0, 0, 1, (float) containerHeight);
        this.actors.add(yAxes);
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.yellow);
        graphics.drawString("Sine Function", 100, 100);
        graphics.setColor(Color.white);
        graphics.drawString("Displacement x Axes: " + this.sineFunction1.getSineComponents().get(0).getDisplacementX(), 400, 100);
        graphics.drawString("Displacement y Axes: " + this.sineFunction1.getSineComponents().get(0).getDisplacementY(), 700, 100);
        graphics.drawString("Displacement amplitude: " + this.sineFunction1.getSineComponents().get(0).getAmplitude() / 100, 1000, 100);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        graphics.setColor(Color.red);
        for (SineComponent component : this.sineFunction1.getSineComponents()) {
            component.render(graphics);
        }
        graphics.setColor(Color.green);
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

        if ((posX > this.valueButton1.getxSubtractionButton() && posX < this.valueButton1.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - (this.valueButton1.getY() + this.valueButton1.getxAdditionButton()))) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementX(sineComponent.getDisplacementX() - 1);
                    sineComponent.setX(sineComponent.getX() - 1);
                }
            }
        }

        if ((posX > this.valueButton1.getxAdditionButton() && posX < this.valueButton1.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - (this.valueButton1.getY() + this.valueButton1.getxAdditionButton()))) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementX(sineComponent.getDisplacementX() + 1);
                    sineComponent.setX(sineComponent.getX() + 1);
                }
            }
        }

        if ((posX > this.valueButton2.getxSubtractionButton() && posX < this.valueButton2.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - (this.valueButton2.getY() + this.valueButton2.getxAdditionButton()))) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementY(sineComponent.getDisplacementY() - 1);
                }
            }
        }

        if ((posX > this.valueButton2.getxAdditionButton() && posX < this.valueButton2.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - (this.valueButton2.getY() + this.valueButton2.getxAdditionButton()))) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    sineComponent.setDisplacementY(sineComponent.getDisplacementY() + 1);
                }
            }
        }

        if ((posX > this.valueButton3.getxSubtractionButton() && posX < this.valueButton3.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - (this.valueButton3.getY() + this.valueButton3.getxAdditionButton()))) {
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : this.sineFunction1.getSineComponents()) {
                    if (sineComponent.getAmplitude() > 0) {
                        sineComponent.setAmplitude(sineComponent.getAmplitude() - 1);
                    }
                }
            }
        }

        if ((posX > this.valueButton3.getxAdditionButton() && posX < this.valueButton3.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - (this.valueButton3.getY() + this.valueButton3.getxAdditionButton()))) {
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
            double angleOfComponent = sineComponent.getPositionRelative() * 360 * Math.PI / (180) * sineComponent.getAmountOfDurations();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + gameContainer.getHeight() / 2 - sineComponent.getDisplacementY()));
        }
    }
}
