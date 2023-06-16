package at.htldornbirn.projects.nawi.Team8;

import at.htldornbirn.projects.nawi.Constants;

import at.htldornbirn.projects.nawi.Team8.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team8.slider.Slider;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.GameContainer;

import java.util.ArrayList;
import java.util.List;

public class RotationGame extends BasicGameState {
    private List<Actor> actors;
    private Button stateButton1;
    private Button startStopButton;
    private ValueButton speedButton;
    private ValueButton radiusButton;
    private Slider slider;
    private SetAngle setAngle = new SetAngle();
    private AngelCodeFont font;

    private double bigRadius = 200;
    private Ball ball;
    private boolean isMoving = true;

    @Override
    public int getID() {
        return 82;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.ball = new Ball(0, 0, 20);
        this.ball.setAngleVelocity(Math.PI / 100);

        // Button für den Seitenwechsel
        float buttonX = gameContainer.getWidth() / 2.5f;
        float buttonY = gameContainer.getHeight() * 0.8f;
        this.stateButton1 = new Button(buttonX, buttonY, 400, 100, "Go to explanation", Color.green);
        actors.add(stateButton1);


        //buttons für das einstellen der Kreisbewegung

        // Button für Start/Stop
        float startStopButtonX = gameContainer.getWidth() / 180f;
        float startStopButtonY = gameContainer.getHeight() * 0.5f;
        startStopButton = new Button(startStopButtonX, startStopButtonY, 200, 100, "Start/Stopp", Color.orange);
        actors.add(startStopButton);

        // Slider für die Geschwindigkeit
        this.slider = new Slider(20, 300, 0, 300);
        slider.addListener(setAngle);
        slider.setColor(Color.orange);


        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team8/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team8/assets/demo2_00.tga");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        ball.render(g);
        stateButton1.render(g);

        font.drawString((float) gameContainer.getWidth() / 30, (float) gameContainer.getHeight() / 10, "Kreisbewegung", Color.yellow);

        for (Actor actor : actors) {
            actor.render(g);
        }

        slider.render(gameContainer, g);

        // Geschwindigkeit
        font.drawString(10, 250, "Geschwindigkeit: ");

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        slider.update(gameContainer);


        Input input = null;


        input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();


        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(Constants.TEAM8);
            }
        }
        if (isMoving) {
            double angleVelocityMultiplier = setAngle.getAngleVelocityMultiplier(); // Wert des angleVelocityMultiplier abrufen
            ball.setAngleVelocity(Math.PI / 100 * angleVelocityMultiplier);

            this.ball.setX((float) (bigRadius * Math.cos(Math.toRadians(this.ball.getAngle())) + 900));
            this.ball.setY((float) (bigRadius * Math.sin(Math.toRadians(this.ball.getAngle())) + 400));
            this.ball.setAngle((float) (this.ball.getAngle() + this.ball.getAngleVelocity()));
        }




        // System.out.println((float) (bigRadius * Math.sin(this.ball.getAngle())));

        if ((posX > this.startStopButton.getX() && posX < this.startStopButton.getX() + this.startStopButton.getWidth() && (posY > gameContainer.getHeight() - (startStopButton.getY() + startStopButton.getHeight()) && posY < gameContainer.getHeight() - startStopButton.getY()))) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                isMoving = !isMoving;
            }
        }

    }
}
