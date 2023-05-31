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
    private ItemList itemList;
    private Horse horse;
    private Box box;


    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        inputFieldRN = new InputFieldRN(100, 100, 40, 20, 3);
        calculations = new Calculations(this);
        itemList = new ItemList(this);
        actors = new ArrayList<Actor>();
        horse = new Horse(800, 450, 1, 1,100,50);

        //Ground
        GroundSkyNew groundimagel = new GroundSkyNew();
        actors.add(groundimagel);

        //box
        Box box1 = new Box();
        this.actors.add(box1);
        //Adding all actors necessary
        this.actors.add(itemList);
        this.actors.add(horse);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        // Draw a green rectangle
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
        inputFieldRN.draw(graphics);
        horse.render(graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputFieldRN.update(delta);
        calculations.update(delta);
        itemList.update(delta);
        horse.update(delta);
        backgroundColor = Color.white;

        for (Actor actor : this.actors) {
            actor.update(delta);
        }
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