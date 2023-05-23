package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;

import org.lwjgl.input.Mouse;

import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;


import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Navigation extends BasicGameState implements SliderListener {
    @Override
    public int getID() {
        return Constants.NAVIGATION;
    }

    private List<Actor> actors;
    private Slider slider;
    float mouseX;
    float mouseY;
    Input input;



    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        Team1 team1 = new Team1(100, 100, 60);
        actors.add(team1);

        this.slider = new Slider(300, 300, 0, 100);
        this.slider.addListener(this);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }

        this.slider.render(gameContainer, graphics);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(delta);
        }
        this.slider.update(gameContainer);

    }

    @Override
    public void onChange(float mouseY) {
        System.out.println(mouseY);
    }

    public boolean MousePressed(int id) {
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if ((mouseX >= actors.get(id).getX() && mouseX < actors.get(id).getX() + 60) && (mouseY >= actors.get(id).getY() && mouseY < actors.get(id).getY() + 60)) {
                return true;
            }
        }
        return false;
    }

}

