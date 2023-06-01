package at.htldornbirn.projects.nawi.Team2.code;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
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
    private Image scaledImage;
    private float xPictureStartPosition, yPictureStartPosition;
    boolean mirroing;

    public Sled(float angleSled,float speedSled, float xPosition, float yPosition, float widthSled, float heightSled) throws SlickException {
        this.xPosition = xPosition;
        this.yPosition = yPosition-heightSled;

        this.widthSled = widthSled;
        this.heightSled = heightSled;

        this.angleSled = angleSled;
        this.speedSled = speedSled;

        this.isOnTop = true;
        this.isAtBottom = false;
        this.mirroing = true;

        this.xPictureStartPosition=this.xPosition;
        this.yPictureStartPosition=this.yPosition;


        Image originalImage = new Image("src/at/htldornbirn/projects/nawi/Team2/pictures/SledPictureInclinedPlane.png");
        this.scaledImage = originalImage.getScaledCopy((int)this.widthSled, (int)this.heightSled);
    }



    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        System.out.println(mirroing);
        if (this.xPosition>=1200-(this.widthSled+5) && mirroing){
            this.mirroing = false;
            this.scaledImage = scaledImage.getFlippedCopy(true, false);
        }else if (xPosition <= 300-5){
            this.scaledImage = scaledImage.getFlippedCopy(true, false);
        }else{
            this.mirroing = true;
        }

        graphics.pushTransform();
        graphics.rotate(this.xPictureStartPosition, this.yPictureStartPosition, angleSled);
        graphics.drawImage(scaledImage,xPosition, yPosition-5);
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
