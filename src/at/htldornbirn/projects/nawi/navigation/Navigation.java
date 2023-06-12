package at.htldornbirn.projects.nawi.navigation;

import at.htldornbirn.projects.nawi.Constants;

import at.htldornbirn.projects.nawi.tools.button.BackButton;
import org.lwjgl.input.Mouse;

import at.htldornbirn.projects.nawi.tools.slider.Slider;
import at.htldornbirn.projects.nawi.tools.slider.SliderListener;


import org.lwjgl.opengl.Display;
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
    private Animation anim;
    private BackButton back;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        map = new Hashtable<Integer, Integer>();
        createTeams(gameContainer);
        image = new Image("/src/at/htldornbirn/projects/nawi/images/Unbenannt.jpg");
        scaled = image.getScaledCopy(59,59);
        //back = new BackButton(100,100,stateBasedGame);
        //actors.add(back);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            ChangeState(stateBasedGame,gameContainer);
            //back.changeState();
        }
        for (Actor actor : actors) {
            actor.update(delta);
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

            if ((mouseX >= ObjX && mouseX < ObjX + 160) && (mouseY >= ObjY && mouseY < ObjY + 120)) {
                //System.out.println(map.get(i));
                /*switch (i+1){
                    case 2:
                        gc.setDisplayMode(1500, 800, false);
                        stateBasedGame.enterState(map.get(i));
                    break;
                    case 6:
                        gc.setDisplayMode(1280, 960, false);
                        stateBasedGame.enterState(map.get(i));
                        System.out.println(i+1);
                        break;
                }*/
                anim = new Animation((int)actors.get(i).getY(),(int)actors.get(i).getX(),160,120, gameContainer);
                actors.add(anim);


                return;
            }
        }
        System.out.println("no OBJ clicked");
    }

    public void createTeams(GameContainer gc) throws SlickException {
        int columns = 3;
        int column = 1;

        int width = 160;
        int height = 120;
        int x = gc.getWidth()/(columns+1) - width/2;
        //int x = (gc.getWidth()*100/90) / columns - width;
        System.out.println(gc.getWidth());
        int y = gc.getHeight()/(columns+1) - height/2;

        int xGrowth = gc.getWidth() / (columns+1);
        int yGrowth = gc.getHeight() / (columns+1);

        for (int i = 0; i < 9; i++) {
            Team team = new Team(x, y, width,height,i);
            actors.add(team);
            map.put(i,TEAMS[i]);

            if (column == 3) {
                x = -width/2;
                y += yGrowth;
                column = 0;
            }
            column++;
            x += xGrowth;
        }

    }

}




