package at.htldornbirn.projects.nawi.Team2.code.Background;

import org.newdawn.slick.*;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Color;


public class Snowflake implements Actor{
    private Image image;
    private float x, y;
    private float speed;



    public Snowflake(float x, float y, float speed) throws SlickException {
        this.x = x;
        this.y = y;
        this.speed = speed;
        image = new Image("C:\\Users\\Luca\\Documents\\3. Klasse\\SWP\\NaWi_Projekt\\src\\at\\htldornbirn\\projects\\nawi\\Team2\\code\\Background\\snowflake.png");

    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {
        Image scaledImage = image.getScaledCopy(0.1f);
        scaledImage.draw(x, y);




    }

    @Override
    public void update(int delta) {
        image.draw(x, y);

        this.y += (float)delta/this.speed;
        if(this.y >800){
            this.y = 0;
        }
        if(this.speed == 0){
            this.speed = 5;
        }
    }
}