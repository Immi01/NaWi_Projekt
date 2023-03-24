package at.htldornbirn.projects.nawi.Team3;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.font.effects.ColorEffect;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;


public class StopingDistance extends BasicGameState {

    private TextField speedField;
    private TextField reactionTimeField;
    private TextField decelerationField;
    private float speed = 0;
    private float reactionTime = 0;
    private float deceleration = 0;
    private float brakingDistance = 0;
    private UnicodeFont font;


    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        // Erstellen der Textfelder für die Benutzereingabe
        font = new UnicodeFont("arial.ttf", 10, false, false);
        font.addAsciiGlyphs();
        font.getEffects().add(new ColorEffect(java.awt.Color.WHITE));
        speedField = new TextField(gameContainer, font, 200, 100, 200, 25);
        reactionTimeField = new TextField(gameContainer, font, 200, 150, 200, 25);
        decelerationField = new TextField(gameContainer, font, 200, 200, 200, 25);
        speedField.setAcceptingInput(true);
        reactionTimeField.setAcceptingInput(true);
        decelerationField.setAcceptingInput(true);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
// Berechnung des Anhaltewegs
        float dt = delta / 1000.0f; // Zeit in Sekunden
        float reactionDistance = speed / 3.6f * reactionTime; // Reaktionsweg in Metern
        float brakingSpeed = speed / 3.6f - deceleration * reactionTime; // Geschwindigkeit beim Bremsen in m/s
        brakingSpeed = Math.max(brakingSpeed, 0); // Geschwindigkeit kann nicht kleiner als 0 sein
        brakingDistance = brakingSpeed * brakingSpeed / (2 * deceleration); // Bremsweg in Metern
        brakingDistance += reactionDistance; // Anhalteweg in Metern
    }

    @Override
    public int getID() {
        return 0;
    }
}
