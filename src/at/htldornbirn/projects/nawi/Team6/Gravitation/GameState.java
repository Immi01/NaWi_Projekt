package at.htldornbirn.projects.nawi.Team6.Gravitation;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
    private static final int containerWidth = 1280;
    private static final int containerHeight = 960;
    private static final float floorHeight = 70;
    private static final float floorPositionY =  containerHeight - floorHeight;

    private double lossConstant, gravity, velocity;
    private int lossConstantInProcent;
    private float ballX, ballY;

    private Image ballImage;
    private AngelCodeFont font;

    private Button plusButtonGravity;
    private Button minusButtonGravity;

    private Button plusButtonLossConstant;
    private Button minusButtonLossConstant;

    private RoundedRectExample backButton;

    private boolean plusButtonClicked;
    private boolean minusButtonClicked;



    public int getID() {
        return 65;
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        ballImage = new Image("at/htldornbirn/projects/nawi/Team6/Gravitation/Assets/basketballPicture.png");

        gravity = 0.5;
        lossConstant = 0.2;
        lossConstantInProcent = (int) (lossConstant * 100);
        velocity = 0;

        ballX = gc.getWidth() / 2;
        ballY = 0;

        backButton = new RoundedRectExample(1280 - 210, 960-55, 150, 40, 10, "back to explanation");

        plusButtonGravity = new Button(230, 70 + 7.5f, 15, Color.green, "+", "circle");
        minusButtonGravity = new Button(270, 70 + 7.5f, 15, Color.red, "-", "circle");

        plusButtonLossConstant = new Button(250,110 + 7.5f, 15, Color.green, "+", "circle");
        minusButtonLossConstant = new Button(290,110 + 7.5f, 15, Color.red, "-", "circle");
        plusButtonClicked = false;
        minusButtonClicked = false;
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        g.setColor(Color.white);
        g.fillRect(0, 0, containerWidth, containerHeight);

        g.setColor(Color.black);
        g.fillRect(0, floorPositionY, containerWidth, floorHeight);

        g.setColor(Color.black);
        g.drawString("Höhe: " + String.format("%.2f", getHeight(ballY)) + " m", 10, 30);
        g.drawString("Anziehungskraft: " + (float) gravity, 10, 70);
        g.drawString("verlust konstante: " + lossConstantInProcent + " %" , 10, 110);

        ballImage.draw(ballX - 35, ballY - 35, 70,70);

        plusButtonGravity.render(g);
        minusButtonGravity.render(g);

        plusButtonLossConstant.render(g);
        minusButtonLossConstant.render(g);

        g.setColor(Color.black);
        backButton.render(g);
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException {
        Input input = gc.getInput();
        double remaining = 1 - this.lossConstant;

        velocity += gravity;
        ballY += velocity;

        if(ballY >= floorPositionY){
            velocity *= -remaining;
            ballY = floorPositionY;
        }

        if(input.isKeyDown(Input.KEY_SPACE)){
            velocity = 0;
            ballY = 0;
        }

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = input.getMouseX();
            int mouseY = input.getMouseY();

            // hier wird es überpfrüft, ob der Plus-Button geklickt wurde
            if (plusButtonGravity.isClicked(mouseX, mouseY) && !plusButtonClicked) {
                gravity += 0.05;
                plusButtonClicked = true;
            }

            // hier wird es überpfrüft, ob der Minus-Button geklickt wurde
            if (minusButtonGravity.isClicked(mouseX, mouseY) && !minusButtonClicked) {
                gravity -= 0.05;
                minusButtonClicked = true;
            }

            if (plusButtonLossConstant.isClicked(mouseX, mouseY) && !plusButtonClicked) {
                lossConstant += 0.05;
                lossConstantInProcent += 5;
                plusButtonClicked = true;
            }

            // hier wird es überpfrüft, ob der Minus-Button geklickt wurde
            if (minusButtonLossConstant.isClicked(mouseX, mouseY) && !minusButtonClicked) {
                lossConstant -= 0.05;
                lossConstantInProcent -= 5;
                minusButtonClicked = true;
            }

            if(backButton.isClicked(mouseX, mouseY)){
                sbg.enterState(64);
            }

        } else {
            plusButtonClicked = false;
            minusButtonClicked = false;
        }
    }

    public static float getHeight(float ballY){
        ballY -= 890f;

        if(ballY == 0){
            return ballY;
        } else {
            return ballY *= -1;
        }
    }
}

