package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Sandbox extends BasicGameState {
    private List<Rectangle> rectangles;
    private Rectangle rectangle;
    private int countOfBallSelection;
    private int distanceBetweenRechtangles;
    private CustomBalls customBall;
    private List<CustomBalls> customBalls;

    @Override
    public int getID() {
        return 1;
    }

    public Sandbox() {
        this.rectangles = new ArrayList<>();
        this.customBalls = new ArrayList<>();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.countOfBallSelection = 4;
        for (int i = 0; i < this.countOfBallSelection; i++) {
            this.distanceBetweenRechtangles += 150;
            rectangle = new Rectangle(this.distanceBetweenRechtangles);
            this.rectangle.setY(200);
            rectangles.add(rectangle);
            customBall = new CustomBalls(rectangles.get(i).getX(), rectangles.get(i).getY(), rectangles.get(i).getZ(), rectangles.get(i).getZ());
            customBalls.add(customBall);
        }


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Rectangle rectangle: this.rectangles) {
            rectangle.render(graphics);
        }

        for (CustomBalls customBall: this.customBalls){
            customBall.render(graphics);
        }

        graphics.drawString("Menue", 720, 40);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

}
