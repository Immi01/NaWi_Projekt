package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class Horse implements Actor {
    private float x; // X-Koordinate der Position des Pferdes
    private float y; // Y-Koordinate der Position des Pferdes
    private float width; // Breite des Pferdes
    private float height; // Höhe des Pferdes

    public Horse(float x, float y, float width, float height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(int delta) {
        // Führe Aktualisierungslogik für das Pferd aus (z.B. Bewegung, Animation, etc.)
    }
}