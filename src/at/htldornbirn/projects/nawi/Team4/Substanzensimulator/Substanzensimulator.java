package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;



import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Substanzensimulator extends BasicGameState {
    private int x, y; // Position des Quadrats
    private int radius = 100; // Radius des Kreises
    private boolean dragging; // Zustand des Quadrats
    private Circle circle; // Kreisobjekt
    private List<Actors> actors;
    private List<Substanzen> substanzen;
    private Subject subject;


    public Substanzensimulator(String  name) {
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        x = 100;
        y = 100;
        dragging = false;
        circle = new Circle(x, y, radius);
        substanzen = new ArrayList<>();
        for (int i = 0; i < 5;i++){
            String s = String.valueOf(i);
            substanzen.add(new Substanzen(70+(150*i), 500, 50, 50, false,s));
        }
        subject = new Subject(400, 300, radius);


    }


    public void update(GameContainer container, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = container.getInput();
        for (Substanzen substanzen : substanzen) {
            if (substanzen.isDragging()) {
                substanzen.setX(input.getMouseX()-30);
                substanzen.setY(input.getMouseY()-30);
            }
            if (subject.intersects(substanzen)) {
                // Aktion bei Kollision
                System.out.println("Quadrat "+substanzen.getId()+" und Kreis überlappen!" );
            }
        }


    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        subject.render(graphics);

        for (Substanzen substanzen : substanzen) {
            substanzen.render(graphics);
        }



    }


    @Override
    public int getID() {
        return Constants.TEAM4;
    }

    public void mousePressed(int button, int x, int y) {
        for (Substanzen substanzen : substanzen) {
            if (x >= substanzen.getX() && x <= substanzen.getX() + substanzen.getWidth() &&
                    y >= substanzen.getY() && y <= substanzen.getY() + substanzen.getHeight()) {
                substanzen.setDragging(true);
            }
        }
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        for (Substanzen substanzen : substanzen) {
            substanzen.setDragging(false);
        }
    }


}