package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.*;

public class Calculations {

    private float x,y,width,height;
    private float angle;
    private String weight, distance;

    private float fg, fn, fHang, fSchneeAufRodel, a, v;

    public Calculations(float angle, String weight, String distance) {
        this.angle = angle;
        this.weight = weight;
        this.distance = distance;
    }

    public void update(GameContainer gameContainer, float angle, String weight, String distance) throws SlickException {
        this.angle = angle;
        this.weight = weight;
        this.distance = distance;
        System.out.println("Gewicht: " + weight + "kg");
        System.out.println("Winkel: " + angle + "°");
        System.out.println("Distanz: " + distance + "m");
        System.out.println();

        calculate();
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.setColor(Color.black);
        graphics.drawString("FG: " + String.valueOf(fg), 350,700);
        graphics.drawString("FN: " + String.valueOf(fn), 350,730);
        graphics.drawString("FHang: " + String.valueOf(fHang), 600,700);
        graphics.drawString("FSchneeAufRodel: " + String.valueOf(fSchneeAufRodel), 600,730);
        graphics.drawString("Beschleunigung: " + String.valueOf(a), 950,700);
        graphics.drawString("Geschwindigkeit nach: "+ this.distance + "m beträgt: " + String.valueOf(v), 950,730);
        graphics.setColor(Color.white);
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


        this.fg = inputWeight * 10;
        System.out.println("FG: " + fg + "N");

        double fNDouble = Math.cos(Math.toRadians(this.angle))*this.fg;
        this.fn = (float)fNDouble;
        System.out.println("FN: " + this.fn + "N");

        double fHangDouble = Math.sin(Math.toRadians(this.angle))*this.fg;
        this.fHang = (float)fHangDouble;
        System.out.println("FHang: " + this.fHang + "N");

        this.fSchneeAufRodel = this.fn;
        System.out.println("FSchneeAufRodel: " + this.fSchneeAufRodel + "N");

        System.out.println();

        this.a = this.fHang/inputWeight;
        System.out.println("Beschleunigung a: " + this.a + "m/s2");

        double vDouble = Math.sqrt(2*this.a*inputDistance);
        this.v = (float)vDouble;
        System.out.println("Geschwindigkeit nach " + inputDistance + "m betraegt: " + this.v + "m/s");

        System.out.println("------------------");
    }
}
