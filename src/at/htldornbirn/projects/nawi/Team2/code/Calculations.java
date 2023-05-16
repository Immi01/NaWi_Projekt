package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class Calculations {

    private float x,y,width,height;
    private float angle;
    private String weight, distance;

    public Calculations(float angle, String weight, String distance) {
        this.angle = angle;
        this.weight = weight;
        this.distance = distance;
        x = 10;
        y = 10;
        width = 10;
        height = 10;
    }

    public void update(GameContainer gameContainer, float angle, String weight, String distance) throws SlickException {
        this.angle = angle;
        this.weight = weight;
        this.distance = distance;
        System.out.println("Gewicht: " + weight + "kg");
        System.out.println("Winkel: " + angle + "°");
        System.out.println("Distanz: " + distance + "m");
        System.out.println();

        width = 1000;
        height = 1000;

        calculate();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(x,y,width,height);
    }


    public void calculate(){

        float inputWeight = 0;
        float inputDistance = 0;

        if (this.weight == ""){
            inputWeight = 0;
        }else{
            inputWeight = Float.valueOf(this.weight);
        }

        if (this.distance == ""){
            inputDistance = 0;
        }else{
            inputDistance = Float.valueOf(this.distance);
        }


        float FG = inputWeight * 10;
        System.out.println("FG: " + FG + "N");

        double FNDouble = Math.cos(Math.toRadians(this.angle))*FG;
        float FN = (float)FNDouble;
        System.out.println("FN: " + FN + "N");

        double FHangDouble = Math.sin(Math.toRadians(this.angle))*FG;
        float FHang = (float)FHangDouble;
        System.out.println("FHang: " + FHang + "N");

        float FSchneeAufRodel = FN;
        System.out.println("FSchneeAufRodel: " + FSchneeAufRodel + "N");

        System.out.println();

        float a = FHang/inputWeight;
        System.out.println("Beschleunigung a: " + a + "m/s2");

        double vDouble = Math.sqrt(2*a*inputDistance);
        float v = (float)vDouble;
        System.out.println("Geschwindigkeit nach " + inputDistance + "m betraegt: " + v + "m/s");

        System.out.println("------------------");
    }
}
