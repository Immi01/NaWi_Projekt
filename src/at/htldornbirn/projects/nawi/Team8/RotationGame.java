package at.htldornbirn.projects.nawi.Team8;

import at.htldornbirn.projects.nawi.Constants;

import at.htldornbirn.projects.nawi.Team8.Actor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class RotationGame extends BasicGameState {
    private List<Actor> actors;
    private Button stateButton1;
    /*private ValueButton valueButton1;
    private Ball ball;
    private Button startStopButton;
    private ValueButton speedButton;
    private ValueButton radiusButton;
     */
    private AngelCodeFont font;

    private boolean isRunning;


    @Override
    public int getID() {
        return Constants.TEAM8;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();

        //button für die seiten zu springen


        float buttonX = gameContainer.getWidth() / 1.7f - 125;
        float buttonY = gameContainer.getHeight() * 0.9f - 50;
        stateButton1 = new Button(buttonX, buttonY, 500, 400, "Go to explanation", Color.green);
        actors.add(stateButton1);

        //buttons für das einstellen
        /*
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

         */
        font = new AngelCodeFont("C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2.fnt", "C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2_00.tga");

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15, "Sandbox", Color.yellow);
        graphics.setColor(Color.white);

        /*
        ball.render(graphics);
        startStopButton.render(graphics);
        speedButton.render(graphics);
        radiusButton.render(graphics);

        font.drawString(10, 10, "Geschwindigkeit: " + speedButton.getValue());
        font.drawString(10, 40, "Radius: " + radiusButton.getValue());
        */
        stateButton1.render(graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if (posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth() && (posY > gameContainer.getHeight() - (stateButton1.getY() + stateButton1.getHeight()) && posY < gameContainer.getHeight() - stateButton1.getY())) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(3);
            }
        }
        /*
        if (isRunning) {
            float speed = Float.parseFloat(speedButton.getValue());
            float radius = Float.parseFloat(radiusButton.getValue());
        }

         */

    }
}
