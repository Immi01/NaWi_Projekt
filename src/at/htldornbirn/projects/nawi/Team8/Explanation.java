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
        font = new AngelCodeFont("C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2.fnt", "C:/Users/lenov/OneDrive/Dokumente/SWP/Projects/NaWi_Projekt/src/at/htldornbirn/projects/nawi/Team8/assets/demo2_00.tga");
        this.actors = new ArrayList<>();

        float buttonX = gameContainer.getWidth() / 1.7f - 125;
        float buttonY = gameContainer.getHeight() * 0.9f - 50;
        stateButton1 = new Button(buttonX, buttonY, 500, 400, "Go to sandbox", Color.green);
        actors.add(stateButton1);

    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        font.drawString((float) gameContainer.getWidth() / 20, (float) gameContainer.getHeight() / 20, "Die Gleichförmige Kreisbewegung\n", Color.yellow);
        graphics.setColor(Color.white);
        graphics.scale(0.7f, 0.7f);
        font.drawString(90, 150,
                "Eine Kreisbewegung ist eine Bewegung, bei der ein Objekt entlang eines geschlossenen Pfades verläuft,\n" + "der den Umriss eines Kreises beschreibt. \n" + "In einer Kreisbewegung bleibt die Entfernung des Objekts von einem festen Punkt konstant,\n" + "während sich das Objekt kontinuierlich um diesen Punkt herum bewegt. Die Geschwindigkeit des Objekts variiert während der Bewegung,\n" + "wobei die Richtung immer tangential zur Kreisbahn gerichtet ist.\n" + "Die Kreisbewegung kann sowohl im Uhrzeigersinn als auch gegen den Uhrzeigersinn stattfinden \n" + "und wird oft durch Begriffe wie Winkelgeschwindigkeit, Zentripetalbeschleunigung und Periode charakterisiert.");
        stateButton1.render(graphics);
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        Input input = gameContainer.getInput();
        int posX = Mouse.getX();
        int posY = Mouse.getY();

        if (posX > stateButton1.getX() && posX < stateButton1.getX() + stateButton1.getWidth() &&
                posY > stateButton1.getY() && posY < stateButton1.getY() + stateButton1.getHeight()) {
            if (input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
                stateBasedGame.enterState(2);
            }
        }
    }
}
