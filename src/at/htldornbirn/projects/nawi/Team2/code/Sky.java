package at.htldornbirn.projects.nawi.Team2.code;
import org.newdawn.slick.*;

public class Sky implements Actor {
    private float x;
    private float y;
    private float speed;
    private Color recColor;

    public Sky() {
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {
        recColor = new Color(32,178,170);
        graphics.setColor(recColor);
        graphics.drawRect(0,0,1500,200);
        graphics.fillRect(0,0,1500,200);


    }

    @Override
    public void update(int delta) {
        recColor = new Color(32,178,170);

    }
}
