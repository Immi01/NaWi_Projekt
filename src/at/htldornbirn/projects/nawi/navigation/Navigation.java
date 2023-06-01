package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;

import org.lwjgl.input.Mouse;

import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;


import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.*;

import static at.htldornbirn.projects.nawi.Constants.TEAMS;

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
    private Image image;
    private Image scaled;
    private Dictionary<Integer, Integer> map;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        map = new Hashtable<Integer, Integer>();
        createTeams();

        image = new Image("/src/at/htldornbirn/projects/nawi/images/Unbenannt.jpg");
        scaled = image.getScaledCopy(59,59);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }

        scaled.draw(76,101);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        for (Actor actor : actors) {
            actor.update(delta);
        }
        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            ChangeState(stateBasedGame,gameContainer);
        }


    }

    @Override
    public void onChange(float mouseY) {
        System.out.println(mouseY);
    }

    public void ChangeState(StateBasedGame stateBasedGame,GameContainer gameContainer) throws SlickException {
        AppGameContainer gc = (AppGameContainer) gameContainer;
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;
        for (int i = 0; i < actors.size(); i++) {
            ObjX = actors.get(i).getX();
            ObjY = actors.get(i).getY();
            if ((mouseX >= ObjX && mouseX < ObjX + 60) && (mouseY >= ObjY && mouseY < ObjY + 60)) {
                //System.out.println(map.get(i));


                switch (i+1){
                    case 2:
                        gc.setDisplayMode(1500,800, false);
                    case 6:
                        gc.setDisplayMode(1280, 960, false);
                }
                stateBasedGame.enterState(map.get(i));


                return;
            }
        }
        System.out.println("no OBJ clicked");
    }

    public void createTeams() {
        int y = 100;
        int x = 75;
        for (int i = 0; i < 9; i++) {
            Team team = new Team(x, y, 60);
            actors.add(team);
            map.put(i,TEAMS[i]);

            if (x == 675) {
                x = 0;
                y = 300;
            }
            x += 150;
        }
    }

}




