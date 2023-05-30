package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.StateBasedGame;

public class Sled {

    private float xPosition, yPosition;
    private float angleSled;
    private Rectangle rectangle;
    private float speedSled;
    private float widthSled, heightSled;
    private boolean isOnTop, isAtBottom;

    public Sled(float angleSled,float speedSled, float xPosition, float yPosition, float widthSled, float heightSled) {
        this.xPosition = xPosition;
        this.yPosition = yPosition-heightSled;

        this.widthSled = widthSled;
        this.heightSled = heightSled;

        this.angleSled = angleSled;
        this.speedSled = speedSled;

        this.isOnTop = true;
        this.isAtBottom = false;

        this. rectangle = new Rectangle(this.xPosition, this.yPosition, 150, 50);
    }



    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.pushTransform();
        graphics.rotate(rectangle.getX(), rectangle.getY(), angleSled);
        graphics.fillRect(xPosition, yPosition-3, 150, 50);
        graphics.popTransform();
    }


    public void update(GameContainer gameContainer, float angle, float delta, float speedSled, boolean isPushed,float a) throws SlickException {
        this.angleSled = angle;
        this.speedSled = speedSled;
        if (isPushed){
            if (xPosition<=1200-this.widthSled && isOnTop == true){
                this.xPosition += delta/this.speedSled;
                if (xPosition>=1200-this.widthSled){
                    isOnTop = false;
                }
            }
            if (xPosition>=300 && isOnTop == false){
                if (a==0){
                    a = 1;
                }
                this.xPosition -= delta/this.speedSled*a;

                if (xPosition<=300){
                    isOnTop = true;
                    this.isAtBottom = true;
                }
            }
        }
    }

    public boolean isAtBottom() {
        return isAtBottom;
    }

    public void setAtBottom(boolean atBottom) {
        isAtBottom = atBottom;
    }
}