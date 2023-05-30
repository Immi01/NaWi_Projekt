package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;

import org.lwjgl.input.Mouse;

import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;


import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.*;

public class Navigation extends BasicGameState implements SliderListener {
    @Override
    public int getID() {
        return Constants.NAVIGATION;
    }

    private List<Actor> actors;
    private Slider slider;
    float mouseX;
    float mouseY;
    float ObjX;
    float ObjY;
    Input input;
    //private Image image;
    private Dictionary<Integer, Integer> map;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        map = new Hashtable<Integer, Integer>();
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
        map.put(0, Constants.TEAM1);
        map.put(1, Constants.TEAM2);
        map.put(2, Constants.TEAM3);
        map.put(3, Constants.TEAM4);
        map.put(4, Constants.TEAM5);
        map.put(5, Constants.TEAM6);
        map.put(6, Constants.TEAM7);
        map.put(7, Constants.TEAM8);
        map.put(8, Constants.TEAM9);


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
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            ChangeState();
        }


    }

    @Override
    public void onChange(float mouseY) {
        System.out.println(mouseY);
    }

    public void ChangeState() {
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;
        for (int i = 0; i < actors.size(); i++) {
            ObjX = actors.get(i).getX();
            ObjY = actors.get(i).getY();
            if ((mouseX >= ObjX && mouseX < ObjX + 60) && (mouseY >= ObjY && mouseY < ObjY + 60)) {
                System.out.println(map.get(i));
                return;
            }
        }
        System.out.println("no OBJ clicked");
    }
}




