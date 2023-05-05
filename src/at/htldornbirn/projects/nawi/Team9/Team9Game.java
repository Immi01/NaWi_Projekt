package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Team9Game extends BasicGameState {

    private List<Actor> actors;
    private InputFieldRN inputFieldRN;
    private Color backgroundColor;
    private Calculations calculations;


    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        inputFieldRN = new InputFieldRN(100, 100, 100, 20, 10);
        calculations = new Calculations(this);
        actors = new ArrayList<Actor>();
        backgroundColor = Color.white;

        //Ground
        RectangleGround leftGround = new RectangleGround(0, 400, 750, 400);
        RectangleGround rightGround = new RectangleGround(850, 400, 750, 400);
        this.actors.add(leftGround);
        this.actors.add(rightGround);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        inputFieldRN.draw(graphics);
        graphics.drawString("KG: " + inputFieldRN.getText(), inputFieldRN.getX(), inputFieldRN.getY() + 40);
        graphics.setBackground(Color.white);

        // Draw a green rectangle

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputFieldRN.update(delta);
        backgroundColor = Color.white;
        calculations.setKgValueString(inputFieldRN.getValue());
        System.out.println(calculations.getPs());
    }

    @Override
    public void keyPressed(int key, char c) {
        inputFieldRN.keyPressed(key, c);
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        boolean clickedOnInputField = inputFieldRN.isMouseOver(x, y);
        if (clickedOnInputField) {
            inputFieldRN.setSelected(true);
        } else {
            inputFieldRN.setSelected(false);
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        boolean clickedOnInputField = inputFieldRN.isMouseOver(x, y);
        if (clickedOnInputField) {
            inputFieldRN.setSelected(true);
        } else {
            inputFieldRN.setSelected(false);
        }
    }

    public InputFieldRN getInputFieldRN() {
        return inputFieldRN;
    }
}