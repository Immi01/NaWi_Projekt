package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;



import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Circle;
import org.newdawn.slick.gui.MouseOverArea;
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
    private MouseOverArea resetButton;
    private Image buttonImg;


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
            substanzen.add(new Substanzen(70+(150*i), 450, 90, 90, false,i));
        }
        subject = new Subject(400, 250, radius);
        Image buttonImage = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/button.png");
        this.buttonImg = buttonImage.getScaledCopy(100,60);
        resetButton = new MouseOverArea(gameContainer, buttonImg, 50, 50, buttonImg.getWidth(), buttonImg.getHeight());


    }


    public void update(GameContainer container, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = container.getInput();
        for (Substanzen substanzen : substanzen) {
            if (substanzen.isDragging()) {
                substanzen.setX(input.getMouseX()-50);
                substanzen.setY(input.getMouseY()-50);
            }

        }


    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        subject.render(graphics);

        for (Substanzen substanzen : substanzen) {
            substanzen.render(graphics);
            if (subject.intersects(substanzen)){
                subject.consume(substanzen.getId());
            }
        }

        resetButton.render(gameContainer, graphics);


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
            if (!dragging && subject.intersects(substanzen)) {
                substanzen.setX(600);
                substanzen.setY(800);
                subject.consume(substanzen.getId());
            }

            if (button == Input.MOUSE_LEFT_BUTTON && resetButton.isMouseOver()) {
                // Setzen Sie alle Quadrate zurück auf ihre Ursprungspositionen

                    substanzen.setPos(70+(150*substanzen.getId()), 450);
                    dragging = false;



        }
    }


}}