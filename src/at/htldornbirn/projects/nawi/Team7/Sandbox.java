package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.*;
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
    private Table table;
    private int CountOfLocations;
    private LocationButton locationButton;
    private List<LocationButton> locationButtons;
    private float distanceBetweenRandAndButton;
    private float bY, bHeight, bWidth;
    private Ball ball;
    private float WeightForCustomBall;
    private float RadiusForCustomBall;


    @Override
    public int getID() {
        return 1;
    }

    public Sandbox() {
        this.rectangles = new ArrayList<>();
        this.customBalls = new ArrayList<>();
        this.locationButtons = new ArrayList<>();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.countOfBallSelection = 4;
        this.CountOfLocations = 8;
        this.bWidth = 200;
        this.bHeight = 50;
        this.distanceBetweenRechtangles = 100;
        this.distanceBetweenRandAndButton = 1440 - this.bWidth - this.distanceBetweenRechtangles;


        float[] GforcesForBallsOnLocatiosn = {3.7f, 8.87f, 9.81f, 3.71f,  24.79f, 10.44f, 8.87f, 11.15f};
        float[] RadiusForBalls = {20f, 30f, 40f, this.RadiusForCustomBall};
        float[] WeightForBalls = {0.4f, 0.3f, 0.5f, this.WeightForCustomBall};
        int[] LocationID = new int[8];


        for (int i = 0; i < this.customBalls.size(); i++) {

        }

        for (int i = 0; i < this.countOfBallSelection; i++) {
            rectangle = new Rectangle(this.distanceBetweenRechtangles);
            this.rectangle.setY(150);
            rectangles.add(rectangle);
            this.distanceBetweenRechtangles += 250;
            customBall = new CustomBalls(rectangles.get(i).getX(), rectangles.get(i).getY(), rectangles.get(i).getZ(), rectangles.get(i).getZ(), WeightForBalls[i], RadiusForBalls[i]);
            customBalls.add(customBall);
        }

        this.bY = this.rectangle.getY();

        String[] locationsName = {"MERCURY", "VENUS", "EARTH", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE"};

        for (int i = 0; i < this.CountOfLocations; i++) {
            LocationID[i] = i;
            locationButton = new LocationButton(this.distanceBetweenRandAndButton, this.bY, this.bHeight, this.bWidth, locationsName[i], GforcesForBallsOnLocatiosn[i], LocationID[i]);
            locationButtons.add(locationButton);
            this.bY += 100;
        }

        table = new Table(150, 200, 150, 30);

        //ball = new Ball(0, this.table.getHigh(), 0.0f, GforcesForBallsOnLocatiosn[]);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Rectangle rectangle: this.rectangles) {
            rectangle.render(graphics);
        }

        for (CustomBalls customBall: this.customBalls){
            customBall.render(graphics);
        }

        for (LocationButton locationButton: this.locationButtons){
            locationButton.render(graphics);
        }

        graphics.drawString("Menue", 720, 40);

        table.render(graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

    }

}
