package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;



import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Substanzensimulator extends BasicGameState {
    private int x, y; // Position des Quadrats
    private int radius = 25; // Radius des Kreises
    private boolean dragging; // Zustand des Quadrats
    private Circle circle; // Kreisobjekt

    public Substanzensimulator(String  name) {
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        x = 100;
        y = 100;
        dragging = false;
        circle = new Circle(x, y, radius);
    }


    public void update(GameContainer container, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (dragging) {
            Input input = container.getInput();
            x = input.getMouseX();
            y = input.getMouseY();

        }



    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        graphics.drawRect(x, y, 50, 50);

        graphics.drawOval(circle.getCenterX() - radius, circle.getCenterY() - radius, radius * 2, radius * 2);
    }


    @Override
    public int getID() {
        return 0;
    }

    public void mousePressed(int button, int x, int y) {
        if (x >= this.x && x <= this.x + 50 && y >= this.y && y <= this.y + 50) {
            dragging = true;
        }
    }

    @Override
    public void mouseReleased(int button, int x, int y) {
        dragging = false;
    }


}