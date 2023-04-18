package at.htldornbirn.projects.nawi.Team6.sinefunction;

import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Explanation extends BasicGameState {
    private List<Actor> actors;
    private Button button;

    public int getID() {
        return 1;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();
        this.button = new Button(675, gameContainer.getHeight() - 150, 175, 100);
        this.actors.add(this.button);
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.setColor(Color.red);
        graphics.drawString("The sine function\n", 50, 50);
        graphics.setColor(Color.white);
        graphics.drawString(
                "The sine function, denoted as sin(x), is a mathematical function that relates the angles of a right-angled triangle to the ratios of the length of its sides.\n" +
                        "Specifically, it is defined as the ratio of the length of the side opposite to an angle in a right-angled triangle to the length of the hypotenuse (the longest side) of the same triangle.\n" +
                        "In mathematical terms, sin(x) = opposite/hypotenuse.\n" + "\n" +
                        "The sine function is periodic, meaning that it repeats itself after a certain interval of values.\n" +
                        "In fact, sin(x) has a period of 2π radians or 360 degrees, which means that its values repeat after every 2π radians or 360 degrees.\n" + "\n" +
                        "The sine function is widely used in mathematics, physics, engineering, and other fields that deal with wave phenomena.\n" +
                        "It is a fundamental component of trigonometry, which is the study of relationships between angles and sides of triangles.\n" +
                        "The sine function is used to describe many types of periodic phenomena, such as oscillations, vibrations, and waves.\n" +
                        "It is also used in the study of sound waves, light waves, and electromagnetic waves. In addition, it is commonly used in signal processing, image processing, and computer graphics.", 90, 125);
        graphics.setColor(Color.yellow);
        graphics.drawString("Go to sandbox", 687, 787);
        graphics.setColor(Color.white);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > this.button.getX() && posX < this.button.getX() + this.button.getWidth()) && (posY > 50 && posY < 150)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }
    }
}
