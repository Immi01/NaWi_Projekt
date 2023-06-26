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

    private Image buttonimg;
    private List<Actor> actors;
    private boolean menu;
    private Slider slider;
    float mouseX;
    float mouseY;
    float ObjX;
    float ObjY;
    Input input;
    private Image background;
    private Dictionary<Integer, Integer> map;
    Animation anim;
    private int cteam;
    private PlayButton playButton;
    private ReturnButton returnButton;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        anim = null;
        playButton = null;
        returnButton = null;
        cteam = -1;
        buttonimg = new Image("/src/at/htldornbirn/projects/nawi/images/Button.png");
        menu = false;
        input = gameContainer.getInput();
        this.actors = new ArrayList<>();
        map = new Hashtable<Integer, Integer>();
        createTeams(gameContainer);
        background = new Image("/src/at/htldornbirn/projects/nawi/images/Background.jpg");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        for (Actor actor : actors) {
            actor.render(graphics);
        }

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        if (menu && cteam != -1 && anim.isFinished()) {
            switch (cteam + 1) {
                case 1 -> {
                    anim.setTitle("ElementInferno");
                    anim.setDescription("Die flüsternden Flammen malen mit den Elementen\n" + "ein leuchtendes Gemälde am Horizont der Nacht.");
                }
                case 2 -> {
                    anim.setTitle("Schiefe Ebene");
                    anim.setDescription("Beschreibt eine ebene, zur Horizontalen geneigte\n" + "Fläche, auf der sich eine Masse unter dem Einfluss\n" + "ihrer Gewichtskraft (und der Reibung) bewegt.");
                }
                case 3 -> {
                    anim.setTitle("Anhalteweg");
                    anim.setDescription("by Daniel T. and Timothe G.");
                }
                case 4 -> {
                    anim.setTitle("Warnsymbole");
                    anim.setDescription("Lernen mit dem Gefahrensimulator von Jonas und\n" + "Maetoe.");
                }
                case 5 -> {
                    anim.setTitle("Dopplereffect");
                    anim.setDescription("by Diego & Tamir.");
                }
                case 6 -> {
                    anim.setTitle("Allgemeine Sinusfunktion und Gravitation ");
                    anim.setDescription("Simulierung des allgemeines Sinusfunktion und\n" + "des Schwerkraftes.");
                }
                case 7 -> {
                    anim.setTitle("Lotrechter Wurf");
                    anim.setDescription("Sehen sie die faszination der Flugbahn eines Balles.");
                }
                case 8 -> {
                    anim.setTitle("Kreisbewegung");
                    anim.setDescription("Eine Simulation des Kreisbewegungs.");
                }
                case 9 -> {
                    anim.setTitle("Darstellung der Pferdestärke");
                    anim.setDescription("Beobachte ein Pferd, wie es ein Gewicht aus einem\n" + "Loch zieht, während du das Gewicht eingibst und\n" + "die entsprechenden Pferdestärken berechnet werden.");
                }
            }
        }

        if (anim != null && anim.isFinished() && playButton == null && menu) {
            playButton = new PlayButton(100, 500, 275, 100, buttonimg);
            actors.add(10, playButton);
            returnButton = new ReturnButton(400, 500, 275, 100, buttonimg);
            actors.add(11, returnButton);
        }

        if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            ChangeState(stateBasedGame, gameContainer);
        }
        for (Actor actor : actors) {
            actor.update(delta);
        }


    }

    @Override
    public void onChange(float mouseY) {
        System.out.println(mouseY);
    }

    public void ChangeState(StateBasedGame stateBasedGame, GameContainer gameContainer) throws SlickException {
        AppGameContainer gc = (AppGameContainer) gameContainer;
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;


        for (int i = 0; i < actors.size(); i++) {
            ObjX = actors.get(i).getX();
            ObjY = actors.get(i).getY();

            if ((mouseX >= ObjX && mouseX < ObjX + 160) && (mouseY >= ObjY && mouseY < ObjY + 120) && !menu) {
                anim = new Animation((int) actors.get(i).getY(), (int) actors.get(i).getX(), 160, 120, gameContainer, background, new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga"));
                actors.add(9, anim);
                menu = true;
                cteam = i;
                return;
            }
        }
        if (menu) {
            if (mouseX >= playButton.getX() && mouseX < playButton.getX() + playButton.getWidth() && mouseY >= playButton.getY() && mouseY < playButton.getY() + playButton.getHeight()) {
                switch (cteam + 1) {
                    case 2 -> {
                        gc.setDisplayMode(1500, 800, false);
                        actors.remove(11);
                        actors.remove(10);
                        actors.remove(9);
                        menu = false;
                        stateBasedGame.enterState(map.get(cteam));
                        anim = null;
                        playButton = null;
                        returnButton = null;
                    }
                    case 6 -> {
                        gc.setDisplayMode(1280, 960, false);
                        actors.remove(11);
                        actors.remove(10);
                        actors.remove(9);
                        menu = false;
                        stateBasedGame.enterState(map.get(cteam));
                        anim = null;
                        playButton = null;
                        returnButton = null;
                    }
                    default -> {
                        actors.remove(11);
                        actors.remove(10);
                        actors.remove(9);
                        menu = false;
                        stateBasedGame.enterState(map.get(cteam));
                        anim = null;
                        playButton = null;
                        returnButton = null;
                    }
                }
            }
            if (returnButton != null && mouseX >= returnButton.getX() && mouseX < returnButton.getX() + returnButton.getWidth() && mouseY >= returnButton.getY() && mouseY < returnButton.getY() + returnButton.getHeight()) {
                actors.remove(11);
                actors.remove(10);
                actors.remove(9);
                menu = false;
                anim = null;
                playButton = null;
                returnButton = null;
            }
        }

    }


    public void createTeams(GameContainer gc) throws SlickException {
        int columns = 3;
        int column = 1;

        int width = 160;
        int height = 120;
        int x = gc.getWidth() / (columns + 1) - width / 2;
        //int x = (gc.getWidth()*100/90) / columns - width;
        System.out.println(gc.getWidth());
        int y = gc.getHeight() / (columns + 1) - height / 2;

        int xGrowth = gc.getWidth() / (columns + 1);
        int yGrowth = gc.getHeight() / (columns + 1);

        for (int i = 0; i < 9; i++) {
            Team team = new Team(x, y, width, height, i);
            actors.add(team);
            int t = i+1;
            team.setImage(new Image("/src/at/htldornbirn/projects/nawi/images/TEAM"+t+".png"));
            map.put(i, TEAMS[i]);

            if (column == 3) {
                x = -width / 2;
                y += yGrowth;
                column = 0;
            }
            column++;
            x += xGrowth;
        }

    }

}




