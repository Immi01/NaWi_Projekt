package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Cloud implements Actor{
    private float x;
    private float y;
    private float speed;
    private Color cloudColor;

    public Cloud(){
        this.x = x;
        this.y = y;
        this.speed = 5;
    }

    @Override
    public void init(GameContainer gameContainer)throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {
        cloudColor = new Color(255,255,255);
        graphics.setColor(cloudColor);

    }

    @Override
    public void update(int delta) {
        this.x -= (float)delta/this.speed;
        if(this.x <0){
            this.x = 1500;

        }
        cloudColor = new Color(255,255,255);



    }
}
