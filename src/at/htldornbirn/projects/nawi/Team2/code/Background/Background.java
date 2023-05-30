package at.htldornbirn.projects.nawi.Team2.code.Background;

import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Image;

public class Background implements Actor {
    private float x;
    private float y;
    private float speed;
    private Color backgroundColor;
    private Image image;


    public Background() {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        image = new Image("src/at/htldornbirn/projects/nawi/Background/backgoundimage.png");

    }

    @Override
    public void render(Graphics graphics) {
        backgroundColor = new Color(124,252,0);
        graphics.setColor(backgroundColor);
        graphics.drawRect(0,200,1500,600);
        graphics.fillRect(0,200,1500,600);



    }

    @Override
    public void update(int delta) {
        backgroundColor = new Color(124, 252, 0);


    }
}
