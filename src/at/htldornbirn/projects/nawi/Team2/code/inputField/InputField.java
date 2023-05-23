package at.htldornbirn.projects.nawi.Team2.code.inputField;

import org.newdawn.slick.*;

public class InputField {
    private String text;
    private BackgroundInputField backgroundInputField;

    private int x,y;
    private int rectHeight,rectWidth;
    private boolean hasFocus;


    public InputField(String text, int x, int y, boolean hasFocus) {
        this.hasFocus = hasFocus;

        this.text = text;
        this.x = x;
        this.y = y;
        this.rectHeight = 20;
        this.rectWidth = 100;
        this.backgroundInputField = new BackgroundInputField(this.x,this.y,this.rectWidth,this.rectHeight);
    }


    public void render(Graphics graphics) throws SlickException{
        this.backgroundInputField.render(graphics,hasFocus);
        graphics.drawString(text,x,y);
    }



    public void update(GameContainer gameContainer) {
    }


    public void append(String text){
        StringBuilder sb = new StringBuilder(this.text);
        if (sb.length()<=2 && hasFocus == true) {
            this.text += text;
        }
    }

    public void back(){
        StringBuilder sb = new StringBuilder(this.text);
        if (sb.length()>=1 && hasFocus == true){
            sb.deleteCharAt(sb.length() - 1);
            this.text = sb.toString();
        }
    }


    public String getText() {
        return this.text;
    }



    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getRectHeight() {
        return rectHeight;
    }

    public int getRectWidth() {
        return rectWidth;
    }


    public void setHasFocus(boolean hasFocus) {
        this.hasFocus = hasFocus;
    }
}
