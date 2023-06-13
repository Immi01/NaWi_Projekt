package at.htldornbirn.projects.nawi.Team6.Gravitation;

import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GravityExplanation extends BasicGameState{
    private Image marsImage;
    private Image jupiterImage;
    private Image earthImage;
    private RoundedRectExample marsButton;
    private RoundedRectExample jupiterButton;
    private RoundedRectExample earthButton;

    public int getID() {
        return 64;
    }

    public void init (GameContainer gc, StateBasedGame sbg) throws SlickException {
        marsImage = new Image("D:\\Schule 3bWI\\SWP(1)adfa\\Slick2DTemplate\\Images\\mars.png");
        jupiterImage = new Image("D:\\Schule 3bWI\\SWP(1)adfa\\Slick2DTemplate\\Images\\jupiter1.png");
        earthImage = new Image("D:\\Schule 3bWI\\SWP(1)adfa\\Slick2DTemplate\\Images\\earth.png");

        marsButton = new RoundedRectExample(250 - 45,330, 90, 30, 10, "mars");
        jupiterButton = new RoundedRectExample(595, 330, 90, 30, 10, "jupiter");
        earthButton = new RoundedRectExample(985, 330, 90, 30, 10, "earth");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();

        if(input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = input.getMouseX();
            int mouseY = input.getMouseY();

            if (marsButton.isClicked(mouseX, mouseY)) {
                sbg.enterState(65);
            }

            if (jupiterButton.isClicked(mouseX, mouseY)) {
                sbg.enterState(65);
            }

            if (earthButton.isClicked(mouseX, mouseY)) {
                sbg.enterState(65);
            }
        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        marsImage.draw(150, 100, 200, 200);
        jupiterImage.draw(540, 100, 200, 200);
        earthImage.draw(930, 100, 200, 200);

        marsButton.render(g);
        jupiterButton.render(g);
        earthButton.render(g);

        g.setColor(Color.white);
        g.drawRoundRect(150, 400, 1280 - 150 * 2, 960 - 400 - 100, 10); //abstand zwischen bilder ist 190 pixel
    }
}
