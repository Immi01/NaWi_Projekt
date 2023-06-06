package at.htldornbirn.projects.nawi.Team8.Backgroundcolor;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;

public class Backcolor implements Actor {

    private float x;
    private float y;
    private float speed;
    private Color backcolor;

    public Backcolor(){
        this.x= x;
        this.y= y;
        this.speed=speed;
}

@Override

  public void init(GameContainer gameContainer) throws SlickException{

}
@Override
    public void render (Graphics graphics) {
backcolor=new Color(145,145,145);
graphics.setColor(backcolor);
graphics.drawRect(0,300,1600,960);
graphics.fillRect(0,300,1600,960);

}

    @Override
    public void update(GameContainer gameContainer, int delta) {
        backcolor=new Color(145,145,145);
    }
}
