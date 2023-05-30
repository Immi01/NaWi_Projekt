package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class GroundSkyNew implements Actor {
    // das Minecraft bild
    private Image minecraftgroundl;
    private Image minecraftgroundr;
    private Image minecraftgroundu;
    private Image sky;
    private Image mass;
    private float x;
    private float y;
    private float width;
    private float height;


    public GroundSkyNew() throws SlickException {
        Image temp = new Image("src/at/htldornbirn/projects/nawi/Team9/images/groundl.jpg");
        this.minecraftgroundl = temp.getScaledCopy(600, 400);
        Image temp2 = new Image("src/at/htldornbirn/projects/nawi/Team9/images/groundr.jpg");
        this.minecraftgroundr = temp2.getScaledCopy(750, 400);
        Image temp3 = new Image("src/at/htldornbirn/projects/nawi/Team9/images/background.jpg");
        this.sky = temp3.getScaledCopy(1600, 800);

        //Gewicht

    }



    @Override
    public void render(Graphics graphics) {
        sky.draw(0,0);

        minecraftgroundl.draw(0, 500);
        minecraftgroundr.draw(850,500);


    }

    @Override
    public void update(int delta) {

    }
}