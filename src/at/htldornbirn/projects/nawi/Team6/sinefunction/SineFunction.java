package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class SineFunction extends BasicGameState {
    private List<Actor> actors;
    private List<SineComponent> sineComponents;
    private Button button;
    private ValueButton valueButton1;
    private ValueButton valueButton2;
    private ValueButton valueButton3;

    public int getID() {
        return 2;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.sineComponents = new ArrayList<>();
        this.button = new Button(675, gameContainer.getHeight() - 150, 175, 100);
        this.actors.add(this.button);

        this.valueButton1 = new ValueButton(500, 130, 50);
        this.actors.add(this.valueButton1);
        this.valueButton2 = new ValueButton(800, 130, 50);
        this.actors.add(this.valueButton2);
        this.valueButton3 = new ValueButton(1100, 130, 50);
        this.actors.add(this.valueButton3);

        double containerHeight = gameContainer.getHeight();
        double containerWidth = gameContainer.getWidth();

        Axes xAxes = new Axes(0, (float) containerHeight / 2, (float) containerWidth, 2);
        this.actors.add(xAxes);
        Axes yAxes = new Axes((float) 0, 0, 2, (float) containerHeight);
        this.actors.add(yAxes);

        int amountOfComponents = 3000;
        for (int i = 1; i <= amountOfComponents; i++) {
            SineComponent sineComponent = new SineComponent();
            this.actors.add(sineComponent);
            this.sineComponents.add(sineComponent);

            double positionRelative = (double) i / amountOfComponents;
            sineComponent.positionRelative = positionRelative;
            sineComponent.x = (float) (positionRelative * containerWidth);

            double angleOfComponent = positionRelative * 360 * Math.PI / (180) * sineComponent.amountOfDurations;
            sineComponent.y = (float) (-sineComponent.amplitude * Math.sin(angleOfComponent) + containerHeight / 2);
        }
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.yellow);
        graphics.drawString("Sine Function", 100, 100);
        graphics.setColor(Color.white);
        graphics.drawString("Displacement x Axes: " + this.sineComponents.get(0).displacementX, 400, 100);
        graphics.drawString("Displacement y Axes: " + this.sineComponents.get(0).displacementY, 700, 100);
        graphics.drawString("Displacement amplitude: " + this.sineComponents.get(0).amplitude / 100, 1000, 100);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        graphics.setColor(Color.red);
        for (SineComponent component : this.sineComponents) {
            component.render(graphics);
        }
        graphics.setColor(Color.yellow);
        graphics.drawString("Go to explanation", 587 + 100, 587 + 200);
        graphics.setColor(Color.white);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > this.button.getX() && posX < this.button.getX() + this.button.getWidth()) && (posY > 50 && posY < 150)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(1);
            }
        }

        if ((posX > this.valueButton1.getxSubtractionButton() && posX < this.valueButton1.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - (this.valueButton1.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.x -= 1;
                    sineComponent.displacementX -= 1;
                }
            }
        }

        if ((posX > this.valueButton1.getxAdditionButton() && posX < this.valueButton1.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton1.getY() && posY > gameContainer.getHeight() - (this.valueButton1.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.x += 1;
                    sineComponent.displacementX += 1;
                }
            }
        }

        if ((posX > this.valueButton2.getxSubtractionButton() && posX < this.valueButton2.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - (this.valueButton2.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.displacementY -= 1;
                }
            }
        }

        if ((posX > this.valueButton2.getxAdditionButton() && posX < this.valueButton2.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton2.getY() && posY > gameContainer.getHeight() - (this.valueButton2.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.displacementY += 1;
                }
            }
        }

        if ((posX > this.valueButton3.getxSubtractionButton() && posX < this.valueButton3.getxSubtractionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - (this.valueButton3.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.amplitude -= 1;
                }
            }
        }

        if ((posX > this.valueButton3.getxAdditionButton() && posX < this.valueButton3.getxAdditionButton() + 30) && (posY < gameContainer.getHeight() - this.valueButton3.getY() && posY > gameContainer.getHeight() - (this.valueButton3.getY() + 30))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                for (SineComponent sineComponent : sineComponents) {
                    sineComponent.amplitude += 1;
                }
            }
        }

        for (SineComponent sineComponent : sineComponents) {
            double angleOfComponent = sineComponent.positionRelative * 360 * Math.PI / (180) * sineComponent.amountOfDurations;
            sineComponent.y = (float) (-sineComponent.amplitude * Math.sin(angleOfComponent) + gameContainer.getHeight() / 2 - sineComponent.displacementY);
        }

        for (Actor actor : this.actors) {
            actor.update(gameContainer, i);
        }
    }
}
