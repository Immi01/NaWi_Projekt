package at.htldornbirn.projects.nawi.Team7;

import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.Team7.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team7.slider.Slider;
import at.htldornbirn.projects.nawi.Team7.slider.SliderListener;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Sandbox extends BasicGameState implements SliderListener {
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
    private float BallGforce;
    private float BallRadius;
    private float BallWeight;
    private DefinitionBoxes definitionBoxes;
    private List<DefinitionBoxes> definitionBoxesList;
    private List<ProjectActor> projectActors;
    private PlayButton playButton;
    private List<PlayButton> playButtons;
    private Slider slider;
    private SetAngle setAngle;
    private float sliderValue;
    private boolean isBall4Clicked = false;
    private boolean isMouseDown = false;

    private Image bgImage;

    @Override
    public int getID() {
        return 1;
    }

    public Sandbox() {
        this.rectangles = new ArrayList<>();
        this.customBalls = new ArrayList<>();
        this.locationButtons = new ArrayList<>();
        this.definitionBoxesList = new ArrayList<>();
        this.projectActors = new ArrayList<>();
        this.playButtons = new ArrayList<>();
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.bgImage = new Image("images/hiero.png");
        this.countOfBallSelection = 4;
        this.CountOfLocations = 8;
        this.bWidth = 200;
        this.bHeight = 50;
        this.distanceBetweenRechtangles = 100;
        this.distanceBetweenRandAndButton = 1440 - this.bWidth - this.distanceBetweenRechtangles;




        float[] GforcesForBallsOnLocatiosn = {3.7f, 8.87f, 9.81f, 3.71f, 24.79f, 10.44f, 8.87f, 11.15f};
        float[] RadiusForBalls = {20f, 30f, 40f, this.RadiusForCustomBall};
        float[] WeightForBalls = {0.4f, 0.3f, 0.5f, this.WeightForCustomBall};
        int[] LocationID = new int[8];


        for (int i = 0; i < this.customBalls.size(); i++) {

        }

        for (int i = 0; i < this.countOfBallSelection; i++) {
            rectangle = new Rectangle(this.distanceBetweenRechtangles, 100);
            this.rectangle.setY(150);
            rectangles.add(rectangle);
            this.distanceBetweenRechtangles += 250;
            customBall = new CustomBalls(rectangles.get(i).getX(), rectangles.get(i).getY(), rectangles.get(i).getZ(), rectangles.get(i).getZ(), WeightForBalls[i], RadiusForBalls[i], i);
            customBalls.add(customBall);
        }

        for (int i = 0; i < this.countOfBallSelection; i++) {
            definitionBoxes = new DefinitionBoxes(rectangles.get(i).getX(), 50, rectangles.get(i).getZ());
            this.definitionBoxes.setY(300);
            definitionBoxesList.add(definitionBoxes);
        }

        this.bY = this.rectangle.getY();

        String[] locationsName = {"MERCURY", "VENUS", "EARTH", "MARS", "JUPITER", "SATURN", "URANUS", "NEPTUNE"};

        for (int i = 0; i < this.CountOfLocations; i++) {
            LocationID[i] = i;
            locationButton = new LocationButton(this.distanceBetweenRandAndButton, this.bY, this.bHeight, this.bWidth, locationsName[i], GforcesForBallsOnLocatiosn[i], LocationID[i]);
            locationButtons.add(locationButton);
            this.bY += 100;
        }

        playButton = new PlayButton(this.customBalls.get(2).getX(), this.locationButton.getY(), 40, 100, Color.blue, "Game start");
        this.playButtons.add(playButton);

        table = new Table(200, 200, 150, 30);
        ball = new Ball(0, 0, 0.0f, this.BallGforce, this.BallRadius, 0.2f, this.BallWeight);

        slider = new Slider(this.customBall.getX() + 20, 400, 0, 400, 40);
        setAngle = new SetAngle();
        slider.addListener(setAngle);
        slider.addListener(this);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Rectangle rectangle : this.rectangles) {
            rectangle.render(graphics);
        }

        for (CustomBalls customBall : this.customBalls) {
            customBall.render(graphics);
        }

        for (LocationButton locationButton : this.locationButtons) {
            locationButton.render(graphics);
        }

        for (int i = 0; i < definitionBoxesList.size(); i++) {
            definitionBoxesList.get(i).render(graphics);
            graphics.drawString("weight: " + customBalls.get(i).getWeight(), this.definitionBoxesList.get(i).getX(), this.definitionBoxesList.get(i).getY());
            graphics.drawString("radius: " + customBalls.get(i).getRadius(), this.definitionBoxesList.get(i).getX(), this.definitionBoxesList.get(i).getY() + 20);
        }

        graphics.drawString("Menue", 720, 40);

        table.render(graphics);
        ball.render(graphics);
        playButton.render(graphics);

        //MercuryImage.draw(0,0);
        slider.render(gameContainer, graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        for (LocationButton locationButton : this.locationButtons) {
            Input input = gameContainer.getInput();
            int mouseY = input.getMouseY();
            int mouseX = input.getMouseX();
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                if (mouseY > locationButton.getY() && mouseY < locationButton.getY() + locationButton.getHeight() && mouseX > locationButton.getX() && mouseX < locationButton.getX() + locationButton.getWidth()) {
                    this.BallGforce = locationButton.getGforce();
                    System.out.println(this.BallGforce);
                }
            }
        }

        Input input = gameContainer.getInput();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON) && !isMouseDown) {
            this.isMouseDown = true;

            for (CustomBalls customBall : this.customBalls) {

                int mouseY = input.getMouseY();
                int mouseX = input.getMouseX();
                if (mouseY > customBall.getY() && mouseY < customBall.getY() + customBall.getHeight() && mouseX > customBall.getX() && mouseX < customBall.getX() + customBall.getWidth()) {

                    if (customBall.getId() == 3) {
                        this.isBall4Clicked = true;
                    }
                    this.BallRadius = customBall.getRadius();
                    this.BallWeight = customBall.getWeight();
                    this.bgImage.draw(0,0);
                    System.out.println(this.ball.getY());
                    ball = new Ball(0, 899 - this.table.getHigh() - this.table.getWidth() - this.BallRadius, 0.0f, this.BallGforce, this.BallRadius, 0.2f, this.BallWeight);
                }
            }
        } else if (!input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            this.isMouseDown = false;
        }

        slider.update(gameContainer);
        for (PlayButton playButton : this.playButtons) {

            int mouseY = input.getMouseY();
            int mouseX = input.getMouseX();
            if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
                if (mouseY > playButton.getY() && mouseY < playButton.getY() + playButton.getHeight() && mouseX > playButton.getX() && mouseX < playButton.getX() + playButton.getWidth()) {
                    System.out.println("hello");
                    stateBasedGame.enterState(Constants.TEAM7);
                }
            }
        }

    }


    @Override
    public void onChange(float mouseY) {
        if (isBall4Clicked) {
            System.out.println("Slider:" + mouseY);
            this.sliderValue = mouseY;
            //this.RadiusForCustomBall = mouseY/20f;
            this.ball.setRadius(mouseY / 20f);
            this.ball.setY(899 - this.table.getHigh() - this.table.getWidth() - this.ball.getRadius());
            System.out.println("radius:" + this.ball.getRadius());
        }

    }
}

