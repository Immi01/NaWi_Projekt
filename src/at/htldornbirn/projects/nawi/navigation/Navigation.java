package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import net.java.games.input.Component;
import org.lwjgl.input.Mouse;
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
    float team1X;
    float team1Y;

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        Team1 team1 = new Team1(100, 100);
        actors.add(team1);
        team1X = actors.get(0).getX();
        team1Y = actors.get(0).getY();
        this.slider = new Slider(300,300,0,100);
        this.slider.addListener(this);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }
        this.slider.render(gameContainer,graphics);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(delta);
        }
        this.slider.update(gameContainer);
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if ((mouseX >= team1X && mouseX < team1X + 60) && (mouseY >= team1Y && mouseY < team1Y + 60)) {
                stateBasedGame.enterState(Constants.SINUS_FUNKTION_GAME);
            }


            if (gameContainer.getInput().isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                System.out.println("OUT");
                stateBasedGame.enterState(Constants.SINUS_FUNKTION_GAME);

            }
        }
    }

    @Override
    public void onChange(float mouseY) {
        System.out.println(mouseY);
    }
}

