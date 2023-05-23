package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Triangle {

    private double angle;
    private double hu;
    private float lineY2;

    public Triangle() {
    }

    public void update(GameContainer gameContainer, int i) throws SlickException {
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawLine(300,600,1200,600);
        graphics.drawLine(300F,600,1200,this.lineY2);

    }

    public void angle(double angle){
        if (angle==0){
            angle = 10;
        }

        this.angle = Math.tan(Math.toRadians(angle));
        this.hu = this.angle * 900;
        double yValue = 600-this.hu;
        this.lineY2 = (float) yValue;
    }


    public void setAngle(double angle) {
        this.angle = angle;
        angle(angle);
    }


}
