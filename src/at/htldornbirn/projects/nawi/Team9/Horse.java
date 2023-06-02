package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Horse implements Actor {
    private float x; // X-Koordinate der Position des Pferdes
    private float y; // Y-Koordinate der Position des Pferdes
    private float speed;
    private int direction;
    private float width;
    private float height;
    private boolean moving;
    private Team9Game team9Game;
    private float mspeed = 10;

    public Horse(float x, float y, int direction, float speed, float width, float height, Team9Game team9Game) {
        this.x = x;
        this.y = y;
        this.speed = speed;
        this.direction=direction;
        this.height = height;
        this.width = width;
        this.moving = false;
        this.team9Game = team9Game;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.green);
        graphics.drawRect(this.x, this.y, width, height);
        graphics.fillRect(this.x, this.y,this.width,this.height);
    }

    @Override
    public void update(int delta) {
        // Führe Aktualisierungslogik für das Pferd aus (z.B. Bewegung, Animation, etc.)
        if (team9Game.getStartButton().isPressed()){
            this.moving = true;
        }
        else if (moving &&x <= 1195){
            x += (float)delta/mspeed;
        }
        else if (moving){
            moving = false;
        }

    }
}