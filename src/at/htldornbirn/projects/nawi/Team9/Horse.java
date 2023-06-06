package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Horse implements Actor {
    private float x = 900; // X-Koordinate der Position des Pferdes
    private float y; // Y-Koordinate der Position des Pferdes
    private float speed;
    private int direction;
    private float width;
    private float height;
    private boolean moving;
    private Team9Game team9Game;
    private float mspeed = 10;
    private Image realhorse;


    public Horse(Team9Game team9Game) throws SlickException {
        Image temp = new Image("src/at/htldornbirn/projects/nawi/Team9/images/copyrightisgay.png");
        this.realhorse = temp.getScaledCopy(200, 183);
        this.team9Game = team9Game;
    }

    @Override
    public void render(Graphics graphics) {
        realhorse.draw(x, 500 - 183);
    }

    @Override
    public void update(int delta) {
        // Führe Aktualisierungslogik für das Pferd aus (z.B. Bewegung, Animation, etc.)
        if (team9Game.getStartButton().isPressed()) {
            this.moving = true;

        } else if (moving && x <= 1050) {
            x += (float) delta / mspeed;
        } else if (moving) {
            moving = false;
        }

        if (team9Game.getResetButton().isPressed()) {
            x = 900;
        }

    }
}