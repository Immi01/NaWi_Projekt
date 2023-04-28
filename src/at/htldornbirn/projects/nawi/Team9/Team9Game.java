package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Team9Game extends BasicGameState
{

    private List<Actor> actors;
    private InputFieldRN inputFieldRN;
    private Color backgroundColor;



    @Override
    public int getID() {
        return 9;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        inputFieldRN = new InputFieldRN(100, 100, 100, 20, 10);
        actors = new ArrayList<Actor>();
        backgroundColor = Color.white;
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        inputFieldRN.draw(graphics);
        graphics.drawString("Value: " + inputFieldRN.getValue(), inputFieldRN.getX(), inputFieldRN.getY() + 40);
        graphics.setBackground(Color.white);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        inputFieldRN.update(delta);
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




}
