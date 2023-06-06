package at.htldornbirn.projects.nawi.Team3;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.Font;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class StopingDistance extends BasicGameState {

    private Input input;
    private float speed;
    private float brakingDistance;
    private Font font;
    private Image carImage;
    private Image streetImage;
    private float xCarImage;
    private Font headerfont;



    public StopingDistance() throws SlickException {

    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {

        this.input = gameContainer.getInput();
        this.speed = 0;
        this.font = new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 11), true);
        this.carImage = new Image("assets/Car.png");
        this.streetImage = new Image("assets/Street.png");
        this.xCarImage = -100;
        this.headerfont = new TrueTypeFont(new java.awt.Font("Verdana", java.awt.Font.BOLD, 20), true);


    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {

// Geschwindigkeit und Bremsweg ausgeben
        g.setFont(font);
        g.drawString("Geschwindigkeit: " + (int) this.speed + " km/h", 50, 50);
        g.drawString("Bremsweg: " + (int) this.brakingDistance + " m", 50, 100);

// Anleitung ausgeben
        g.drawString("Drücke die Pfeiltasten nach oben und unten, um die Geschwindigkeit um 1 Km/h zu ändern.", 50, 65);
        g.drawString("Drücke die Pfeiltasten nach rechts und links, um die Geschwindigkeit zu ändern.", 50, 75);
        g.drawString("Drücke die R-Taste, um die Geschwindigkeit auf 0 zu setzen.", 50, 85);

// Bilder ausgegeben
        streetImage.draw(0, 0);
        carImage.draw(this.xCarImage, 320);

// Beschreibung
        g.drawString("Der Anhalteweg ist der Weg, den ein Fahrzeug benötigt, um vollständig zum Stillstand zu kommen,", 50, 120);
        g.drawString("nachdem der Fahrer eine Bremsung eingeleitet hat.", 50, 135);

// Titel
        g.setFont(headerfont);
        g.drawString("Anhalteweg", 300, 30);


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

// Benutzereingabe abfragen
        if (input.isKeyDown(Input.KEY_UP)) {
            this.speed += 5 * delta / 1000.0f;
        }
        if (input.isKeyDown(Input.KEY_DOWN)) {
            this.speed -= 5 * delta / 1000.0f;
        }
        if (input.isKeyDown(Input.KEY_R)) {
            this.speed = 0;
        }
        if (input.isKeyDown(Input.KEY_RIGHT)) {
            this.speed += 50 * delta / 1000.0f;

        }
        if (input.isKeyDown(Input.KEY_LEFT)) {
            this.speed -= 50 * delta / 1000.0f;
        }
        if (input.isKeyDown(Input.KEY_SPACE)) {
            this.xCarImage += this.speed / 90 / (float) delta;
            this.speed -= 1;
            if (this.speed < 0) {
                this.speed = 0;
            }
        }

        this.xCarImage += this.speed / 100 / (float) delta;
        if (this.xCarImage > 800) {
            this.xCarImage = -400;
        }


//Benutzereingabe überprüfen
        if (this.speed < 0) {
            this.speed = 0;
        }
        if (this.speed > 250) {
            this.speed = 250;
        }

// Berechnung des Anhaltewegs

        this.brakingDistance = (this.speed / 10) * (this.speed / 10);



    }

    @Override

    public int getID() {
        return Constants.TEAM3;
    }


}