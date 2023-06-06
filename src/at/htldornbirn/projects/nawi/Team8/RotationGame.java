package at.htldornbirn.projects.nawi.Team8;

import at.htldornbirn.projects.nawi.Constants;

import at.htldornbirn.projects.nawi.Team8.slider.SetAngle;
import at.htldornbirn.projects.nawi.Team8.slider.Slider;
import at.htldornbirn.projects.nawi.Team8.Actor;
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
    private Ball ball;
    private Button startStopButton;
    private ValueButton speedButton;
    private ValueButton radiusButton;
    private boolean isRunning;
    private Slider slider;
    private SetAngle setAngle = new SetAngle();


    private AngelCodeFont font;

    @Override
    public int getID() {
        return 82;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();


        // Button für den Seitenwechsel
        float buttonX = gameContainer.getWidth() / 2.5f;
        float buttonY = gameContainer.getHeight() * 0.8f;
        this.stateButton1 = new Button(buttonX, buttonY, 400, 100, "Go to explanation", Color.green);
        actors.add(stateButton1);


        //buttons für das einstellen der Kreisbewegung

        // Button für Start/Stop
        float startStopButtonX = gameContainer.getWidth() / 40f;
        float startStopButtonY = gameContainer.getHeight() * 0.5f;
        startStopButton = new Button(startStopButtonX, startStopButtonY, 200, 100, "Start/Stopp", Color.orange);
        actors.add(startStopButton);

        // Slider für Geschwindigkeit
        float speedButtonX = gameContainer.getWidth() / 4f;
        float speedButtonY = gameContainer.getHeight() * 4f;
        speedButton = new ValueButton(speedButtonX, speedButtonY, "Speed");
        actors.add(speedButton);

        // Slider für die Geschwindigkeit

        this.slider = new Slider(10, 260, 0, 300);
        slider.addListener(setAngle);
        slider.setColor(Color.orange);


        // Slider für Radius
        float radiusButtonX = 80;
        float radiusButtonY = gameContainer.getHeight() / 10f;
        radiusButton = new ValueButton(radiusButtonX, radiusButtonY, "Radius");
        actors.add(radiusButton);

        // Slider für den Radius



        // Ball initialisieren

        float centerX = gameContainer.getWidth() / 2;
        float centerY = gameContainer.getHeight() / 2;
        float radius = 100;
        ball = new Ball(centerX, centerY, radius);


        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team8/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team8/assets/demo2_00.tga");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {

        font.drawString((float) gameContainer.getWidth() / 20, (float) gameContainer.getHeight() / 20, "Sandbox", Color.yellow);

        for (Actor actor : actors) {
            actor.render(graphics);
        }

        slider.render(gameContainer, graphics);


        // Geschwindigkeit und Radius anzeigen
        font.drawString(10, 200, "Geschwindigkeit: " + speedButton.getValue());
        font.drawString(10, 350, "Radius: " + radiusButton.getValue());


        stateButton1.render(graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {

        slider.update(gameContainer);

        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();


        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(Constants.TEAM8);
            }
        }

        // Start/Stop-Button prüfen
        if ((posX > this.startStopButton.getX() && posX < this.startStopButton.getX() + this.startStopButton.getWidth()) &&
                (posY > gameContainer.getHeight() - (startStopButton.getY() + startStopButton.getHeight()) && posY < gameContainer.getHeight() - startStopButton.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                if (isRunning) {
                    isRunning = false;
                    startStopButton.setText("Start");
                } else {
                    isRunning = true;
                    startStopButton.setText("Stop");
                }
            }
        }
/*
        // Ball aktualisieren, wenn es läuft
        if (isRunning) {
            float speed = Float.parseFloat(speedButton.getValue());
            float radius = Float.parseFloat(radiusButton.getValue());
            this.ball.update(delta, speed, radius, gameContainer.getWidth() / 2, gameContainer.getHeight() / 2);
        }

 */
    }
}
