package at.htldornbirn.projects.nawi.Team8;

import at.htldornbirn.projects.nawi.Constants;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class Explanation extends BasicGameState {

    private Button stateButton1;
    private AngelCodeFont font;
    private List<Actor> actors;

    @Override
    public int getID() {
        return Constants.TEAM8;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
        this.actors = new ArrayList<>();

        this.stateButton1 = new Button((float) gameContainer.getWidth() / 2, gameContainer.getHeight() - 150, 250, 100, "Go to sandbox", Color.yellow);
        this.stateButton1.setX((float) gameContainer.getWidth() / 2 - this.stateButton1.getWidth() / 2);
        this.stateButton1.setY((float) gameContainer.getHeight() * 9 / 10 - this.stateButton1.getHeight() / 2);
        this.actors.add(this.stateButton1);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 15, (float) gameContainer.getHeight() / 15, "Die Gleichförmige Kreisbewegung\n", Color.yellow);
        graphics.setColor(Color.white);
        float fontFactor = 0.7f;
        graphics.scale(fontFactor, fontFactor);
        font.drawString(90 / fontFactor, 125 / fontFactor,
                "Test");
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if ((posX > this.stateButton1.getX() && posX < this.stateButton1.getX() + this.stateButton1.getWidth()) && (posY > 50 && posY < 150)) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }
    }

}
