package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;



import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Substanzensimulator extends BasicGameState {
    private int x, y; // Position des Quadrats
    private int radius = 25; // Radius des Kreises
    private boolean dragging; // Zustand des Quadrats
    private Circle circle; // Kreisobjekt
    private List<Actors> actors;
    private Substanzen Sub;

    public Substanzensimulator(String  name) {
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        x = 100;
        y = 100;
        dragging = false;
        circle = new Circle(x, y, radius);
        actors.add(new Substanzen(20,20,30,false));
        Substanzen Sub = new Substanzen(20,20,30,false);

    }


    public void update(GameContainer container, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = container.getInput();
        if (Sub.isDragging()){
            Sub.setX(input.getMouseX());
            Sub.setY(input.getMouseY());
        }

    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

       Sub.render(graphics);

        graphics.drawOval(circle.getCenterX() - radius, circle.getCenterY() - radius, radius * 2, radius * 2);
    }


    @Override
    public int getID() {
        return 0;
    }

    public void mousePressed(int button, int x, int y) {
        for (int i = 0;i<actors.size();i++){
            if (x >= Sub.getX() && x <= Sub.getX() + 50 && y >= Sub.getY() && y <= Sub.getY() + 50) {
                dragging = true;
            }
        }
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        dragging = false;
    }


}