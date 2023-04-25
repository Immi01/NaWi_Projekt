package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;

import java.util.ArrayList;
import java.util.List;

public class Main extends BasicGame {

    private List<Actor> actors;
    private InputFieldRN inputFieldRN;

    public Main(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gc) throws SlickException {
        inputFieldRN = new InputFieldRN(100, 100, 100, 20, 10);
        actors = new ArrayList<Actor>();
    }

    @Override
    public void keyPressed(int key, char c) {
        inputFieldRN.keyPressed(key, c);
    }

    @Override
    public void mousePressed(int button, int x, int y) {
        boolean clickedOnInputField = inputFieldRN.isMouseOver(x, y);
        if (clickedOnInputField) {
            inputFieldRN.setSelected(true);
        } else {
            inputFieldRN.setSelected(false);
        }
    }

    @Override
    public void mouseClicked(int button, int x, int y, int clickCount) {
        boolean clickedOnInputField = inputFieldRN.isMouseOver(x, y);
        if (clickedOnInputField) {
            inputFieldRN.setSelected(true);
        } else {
            inputFieldRN.setSelected(false);
        }
    }

    @Override
    public void render(GameContainer container, Graphics graphics) throws SlickException {
        inputFieldRN.draw(graphics);
        graphics.drawString("Value: " + inputFieldRN.getValue(), inputFieldRN.getX(), inputFieldRN.getY() + 40);
    }

    @Override
    public void update(GameContainer container, int delta) throws SlickException {
        inputFieldRN.update(delta);
    }

    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Analyzing"));
            container.setDisplayMode(1600, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}
