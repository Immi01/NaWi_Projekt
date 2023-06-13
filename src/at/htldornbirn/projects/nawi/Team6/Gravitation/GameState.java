package at.htldornbirn.projects.nawi.Team6.Gravitation;

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

    private Button plusButtonGravity;
    private Button minusButtonGravity;

    private Button plusButtonLossConstant;
    private Button minusButtonLossConstant;

    private boolean plusButtonClicked;
    private boolean minusButtonClicked;


    public int getID() {
        return 2; // ID des Spielzustands
    }

    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        ballImage = new Image("D:\\Schule 3bWI\\SWP(1)adfa\\Slick2DTemplate\\Images\\basketballPicture.png");

        gravity = 0.5;
        lossConstant = 0.2;
        lossConstantInProcent = (int) (lossConstant * 100);
        velocity = 0;

        ballX = gc.getWidth() / 2;
        ballY = 0;

        plusButtonGravity = new Button(230, 70 + 7.5f, 15, Color.green, "+");
        minusButtonGravity = new Button(270, 70 + 7.5f, 15, Color.red, "-");

        plusButtonLossConstant = new Button(250,110 + 7.5f, 15, Color.green, "+");
        minusButtonLossConstant = new Button(290,110 + 7.5f, 15, Color.red, "-");
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
                lossConstant += 0.05;
                lossConstantInProcent += 5;
                plusButtonClicked = true;
            }

            // hier wird es überpfrüft, ob der Minus-Button geklickt wurde
            if (minusButtonGravity.isClicked(mouseX, mouseY) && !minusButtonClicked) {
                lossConstant -= 0.05;
                lossConstantInProcent -= 5;
                minusButtonClicked = true;
            }

            if(plusButtonLossConstant.isClicked(mouseX, mouseY) && !plusButtonClicked){
                sbg.enterState(1);
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

