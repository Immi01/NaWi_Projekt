package at.htldornbirn.projects.nawi.Team8;

import at.htldornbirn.projects.nawi.Constants;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.List;

public class RotationGame extends BasicGameState {

    private Ball ball;
    private Button startStopButton;
    private ValueButton speedButton;
    private ValueButton radiusButton;
    private AngelCodeFont font;
    private boolean isRunning;


    @Override
    public int getID() {
        return Constants.TEAM8;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        font = new AngelCodeFont("C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2.fnt", "C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2_00.tga");

        float centerX = gameContainer.getWidth() / 2;
        float centerY = gameContainer.getHeight() / 2;
        float radius = 100;
        ball = new Ball(centerX, centerY, radius);

        float buttonX = gameContainer.getWidth() / 2 - 125;
        float buttonY = gameContainer.getHeight() * 0.9f - 50;
        startStopButton = new Button(buttonX, buttonY, 250, 100, "Start", Color.green);

        float speedButtonX = gameContainer.getWidth() - 200;
        float speedButtonY = gameContainer.getHeight() - 60;
        speedButton = new ValueButton(speedButtonX, speedButtonY, "Speed");

        float radiusButtonX = 80;
        float radiusButtonY = gameContainer.getHeight() - 60;
        radiusButton = new ValueButton(radiusButtonX, radiusButtonY,"Radius");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        ball.render(graphics);
        startStopButton.render(graphics);
        speedButton.render(graphics);
        radiusButton.render(graphics);

        font.drawString(10, 10, "Geschwindigkeit: " + speedButton.getValue());
        font.drawString(10, 40, "Radius: " + radiusButton.getValue());
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (isRunning) {
            float speed = Float.parseFloat(speedButton.getValue());
            float radius = Float.parseFloat(radiusButton.getValue());

            this.ball.update(delta, speed, radius);
        }

        Input input = gameContainer.getInput();
        int posX = input.getMouseX();
        int posY = input.getMouseY();

        if (startStopButton.isClicked(posX, posY) && input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            if (isRunning) {
                startStopButton.setText("Start");
                isRunning = false;
            } else {
                startStopButton.setText("Stop");
                isRunning = true;
            }
        }
    }
}
