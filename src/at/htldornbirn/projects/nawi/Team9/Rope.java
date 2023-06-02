package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Rope implements Actor{
    private float x1;
    private float y1 = 700;
    private float x2;
    private float y2;
    private float speed = 10;
    private Team9Game team9Game;
    private boolean moving;

    public Rope(Team9Game game) {
        this.team9Game = game;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        graphics.setColor(Color.black);
        graphics.drawLine(x1,y1,x2,y2);
    }

    @Override
    public void update(int delta) {
        x1 = 750;
        x2 = 750;
        y2 = 400;
        if (team9Game.getStartButton().isPressed()){
            this.moving = true;
        }
            else if (moving &&y1 >= 550){
            y1 -= (float)delta/speed;
        }
            else if (moving){
                moving = false;
        }
    }
}
