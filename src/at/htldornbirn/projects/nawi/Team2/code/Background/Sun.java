package at.htldornbirn.projects.nawi.Team2.code.Background;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Sun implements Actor {
    private float x;
    private float y;
    private float speed;
    private Color cirColor;


    public Sun(){
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {
        cirColor = new Color(255,255,0);
        graphics.setColor(cirColor);
        graphics.drawOval(1350,-150,300,300);
        graphics.fillOval(1350,-150,300,300);

    }

    @Override
    public void update(int delta) {
        cirColor = new Color(255,255,0);
    }
}
