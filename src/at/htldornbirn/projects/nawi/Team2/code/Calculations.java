package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Calculations {

    private float x,y,width,height;
    private float angle;
    private String weight;

    public Calculations(float angle, String weight) {
        this.angle = angle;
        this.weight = weight;
        x = 10;
        y = 10;
        width = 10;
        height = 10;
    }

    public void update(GameContainer gameContainer, float angle, String weight) throws SlickException {
        this.angle = angle;
        this.weight = weight;
        System.out.println("Gewicht: " + weight);
        System.out.println("Winkel: " + angle);

        width = 1000;
        height = 1000;

        calculate();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(x,y,width,height);
    }


    public void calculate(){

        float inputWeight = 0;
        if (this.weight == ""){
            inputWeight = 0;
        }else{
            inputWeight = Float.valueOf(this.weight);
        }


        float FG = inputWeight * 10;
        System.out.println("FG: " + FG);

        double FNDouble = Math.cos(Math.toRadians(this.angle))*FG;
        float FN = (float)FNDouble;
        System.out.println("FN: " + FN);

        double FHangDouble = Math.sin(Math.toRadians(this.angle))*FG;
        float FHang = (float)FHangDouble;
        System.out.println("FHang: " + FHang);

        float FSchneeAufRodel = FN;
        System.out.println("FSchneeAufRodel: " + FSchneeAufRodel);

        float a = FHang/inputWeight;
        System.out.println("Beschleunigung a: " + a);


    }
}
