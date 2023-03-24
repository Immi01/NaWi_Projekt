package at.rangel.games.sinefunction;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class Explanation extends BasicGameState {
    public int getID() {
        return 1;
    }

    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        graphics.drawString("The sine function\n" +
                "The sine function, denoted as sin(x), is a mathematical function that relates the angles of a right-angled triangle to the ratios of the length of its sides. \n" +
                "Specifically, it is defined as the ratio of the length of the side opposite to an angle in a right-angled triangle to the length of the hypotenuse (the longest side) of the same triangle. \n" +
                "In mathematical terms, sin(x) = opposite/hypotenuse.\n" +
                "\n" +
                "The sine function is periodic, meaning that it repeats itself after a certain interval of values. \n" +
                "In fact, sin(x) has a period of 2π radians or 360 degrees, which means that its values repeat after every 2π radians or 360 degrees.\n" +
                "\n" +
                "The sine function is widely used in mathematics, physics, engineering, and other fields that deal with wave phenomena. \n" +
                "It is a fundamental component of trigonometry, which is the study of relationships between angles and sides of triangles. \n" +
                "The sine function is used to describe many types of periodic phenomena, such as oscillations, vibrations, and waves. \n" +
                " It is also used in the study of sound waves, light waves, and electromagnetic waves. In addition, it is commonly used in signal processing, image processing, and computer graphics.", 100, 100);
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        if (gameContainer.getInput().isKeyPressed(Input.KEY_2)) {
            stateBasedGame.enterState(2);
        }
    }
}
