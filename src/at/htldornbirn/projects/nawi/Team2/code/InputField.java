package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

import java.awt.event.KeyEvent;

public class InputField {
    private String text;
    private int x,y;

    public InputField(String text, int x, int y) {
        this.text = text;
        this.x = x;
        this.y = y;
    }


    public void render(Graphics graphics) throws SlickException{
        graphics.drawString(text,x,y);
    }

    public void update(int delta) throws SlickException {

    }


    public void append(String text){
       this.text += text;
    }

    public void back(){
        StringBuilder sb = new StringBuilder(this.text);
        if (sb.length()>=1){
            sb.deleteCharAt(sb.length() - 1);
            this.text = sb.toString();
        }

    }


    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
