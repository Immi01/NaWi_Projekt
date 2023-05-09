package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Team9Game extends BasicGameState {

    private List<Actor> actors;
    private InputFieldRN inputFieldRN;
    private Color backgroundColor;
    private Calculations calculations;
    private ItemList itemList;


    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        inputFieldRN = new InputFieldRN(100, 100, 100, 20, 10);
        calculations = new Calculations(this);
        itemList = new ItemList(this);

        actors = new ArrayList<Actor>();
        backgroundColor = Color.white;

        //Ground
        RectangleGround leftGround = new RectangleGround(0, 400, 750, 400);
        RectangleGround rightGround = new RectangleGround(850, 400, 750, 400);
        this.actors.add(leftGround);
        this.actors.add(rightGround);
        this.actors.add(calculations);
        this.actors.add(itemList);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        inputFieldRN.draw(graphics);


        // Draw a green rectangle

        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputFieldRN.update(delta);
        calculations.update(delta);
        itemList.update(delta);
        backgroundColor = Color.white;
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