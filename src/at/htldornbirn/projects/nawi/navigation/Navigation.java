package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;

import org.lwjgl.input.Mouse;

import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;


import org.newdawn.slick.*;
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
    //private Image image;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        Team team1 = new Team(75, 100, 60);
        Team team2 = new Team(225, 100, 60);
        Team team3 = new Team(375, 100, 60);
        Team team4 = new Team(525, 100, 60);
        Team team5 = new Team(675, 100, 60);
        Team team6 = new Team(150, 300, 60);
        Team team7 = new Team(300, 300, 60);
        Team team8 = new Team(450, 300, 60);
        Team team9 = new Team(600, 300, 60);
        actors.add(team1);
        actors.add(team2);
        actors.add(team3);
        actors.add(team4);
        actors.add(team5);
        actors.add(team6);
        actors.add(team7);
        actors.add(team8);
        actors.add(team9);



        //image = new Image("/src/at/htldornbirn/projects/nawi/images/Unbenannt.jpg");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }



        //image.draw(0,0);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(delta);
        }


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

