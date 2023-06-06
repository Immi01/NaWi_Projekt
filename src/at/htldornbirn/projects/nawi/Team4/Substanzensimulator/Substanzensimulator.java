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
    private int x, y;
    private int radius = 100;
    private boolean dragging;

    private List<Actors> actors;
    private List<Substanzen> substanzen;
    private Subject subject;
    private MouseOverArea resetButton;
    private Image buttonImg;
    private Image subjectImg;
    private Image backgr;

    public Substanzensimulator(String  name) {
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        x = 100;
        y = 100;
        dragging = false;

        substanzen = new ArrayList<>();
        for (int i = 0; i < 5;i++){
            substanzen.add(new Substanzen(70+(150*i), 450, 90, 90, false,i));
        }
        subject = new Subject(400, 250, radius);
        Image buttonImage = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/button.png");
        this.buttonImg = buttonImage.getScaledCopy(100,60);
        Image subImg = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/subject.png");
        this.subjectImg = subImg.getScaledCopy(200,200);
        Image bgimg = new Image("src/at/htldornbirn/projects/nawi/Team4/Substanzensimulator/images/bg.png");
        this.backgr = bgimg.getScaledCopy(800,600);
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
        backgr.draw(0,0);
        if (!substanzen.get(0).isActive() && !substanzen.get(1).isActive() && !substanzen.get(2).isActive() && !substanzen.get(3).isActive() && !substanzen.get(4).isActive()){
           if (!subject.intersects(substanzen.get(3))){
               subjectImg.draw(300,150);
           }

        }


        for (Substanzen substanzen : substanzen) {

            if (subject.intersects(substanzen) || substanzen.isActive()){
                subject.consume(substanzen.getId());
            }
            substanzen.render(graphics);
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
                substanzen.setActive(true);

            }

            if (button == Input.MOUSE_LEFT_BUTTON && resetButton.isMouseOver()) {


                    substanzen.setPos(70+(150*substanzen.getId()), 450);
                    dragging = false;
                    subjectImg.draw(300,150);

               substanzen.setActive(false);


        }
    }


}}