package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Box implements Actor {

    private Image box;
    private float x = 700;
    private float y = 695;
    private float speed = 10;
    private float width;
    private float height;
    private boolean moving;
    private Team9Game team9Game;



    public Box(Team9Game game) throws SlickException {
        Image boxy = new Image("src/at/htldornbirn/projects/nawi/Team9/images/box.jpg");
        this.box = boxy.getScaledCopy(100, 100);
        this.team9Game = game;
    }

    @Override
    public void render(Graphics graphics) throws SlickException {
        box.draw(x, y);
    }

    @Override
    public void update(int delta) {
        if (team9Game.getStartButton().isPressed()){
            this.moving = true;
        }
        else if (moving &&y >= 545){
            y -= (float)delta/speed;
        }
        else if (moving){
            moving = false;
        }
    }
}
