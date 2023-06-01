package at.htldornbirn.projects.nawi.Team6.sinefunction;

import at.htldornbirn.projects.nawi.Constants;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Explanation extends BasicGameState {
    private List<Actor> actors;
    private Button stateButton1;
    private SineFunction sineFunction1;
    private AngelCodeFont font;

    public int getID() {
        return Constants.TEAM6;
    }


    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
        this.actors = new ArrayList<>();

        this.stateButton1 = new Button((float) gameContainer.getWidth() / 2, gameContainer.getHeight() - 150, 250, 100, "Go to sandbox", Color.yellow);
        this.stateButton1.setX((float) gameContainer.getWidth() / 2 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) gameContainer.getHeight() * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.actors.add(this.stateButton1);

        this.sineFunction1 = new SineFunction(2500, gameContainer.getWidth(), gameContainer.getHeight() - 150, Color.magenta);
        for (SineComponent sineComponent : sineFunction1.getSineComponents()) {
            sineComponent.setAmplitude(50);
            sineComponent.setAmountOfDurations(20);
        }
    }

    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15, "The sine function\n", Color.red);
        graphics.setColor(Color.white);
        float fontFactor = 0.7f;
        graphics.scale(fontFactor, fontFactor);
        font.drawString(90 / fontFactor, 125 / fontFactor,
                "The sine function, denoted as sin(x), is a mathematical function that relates the angles of a right-angled triangle to the ratios\n" +
                        "of the length of its sides. Specifically, it is defined as the ratio of the length of the side opposite to an angle in a\n" +
                        "right-angled triangle to the length of the hypotenuse (the longest side) of the same triangle.\n" + "\n" +
                        "In mathematical terms, sin(x) = opposite/hypotenuse.\n" + "\n" +
                        "The sine function is periodic, meaning that it repeats itself after a certain interval of values.\n" +
                        "In fact, sin(x) has a period of 2 pi radians or 360 degrees, which means that its values repeat after every 2 pi radians or 360 degrees.\n" + "\n" +
                        "The sine function is widely used in mathematics, physics, engineering, and other fields that deal with wave phenomena.\n" +
                        "It is a fundamental component of trigonometry, which is the study of relationships between angles and sides of triangles.\n" + "\n" +
                        "The sine function is used to describe many types of periodic phenomena, such as oscillations, vibrations, and waves.\n" +
                        "It is also used in the study of sound waves, light waves, and electromagnetic waves. In addition, it is commonly used in\n" +
                        "signal processing, image processing, and computer graphics.");
        graphics.scale(1 / fontFactor, 1 / fontFactor);
        graphics.setColor(Color.yellow);
        graphics.setColor(Color.white);
        for (Actor actor : this.actors) {
            actor.render(graphics);
        }

        for (SineComponent component : this.sineFunction1.getSineComponents()) {
            component.render(graphics);
        }
    }

    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > 50 && posY < 150)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }

        for (SineComponent sineComponent : sineFunction1.getSineComponents()) {
            sineComponent.setDisplacementX(sineComponent.getDisplacementX() - Math.PI / 64);
            double angleOfComponent = sineComponent.getPositionRelative() * 2 * Math.PI * sineComponent.getAmountOfDurations() + sineComponent.getDisplacementX();
            sineComponent.setY((float) (-sineComponent.getAmplitude() * Math.sin(angleOfComponent) + gameContainer.getHeight() * 2 / 3 - sineComponent.getDisplacementY()));
        }
    }
}
