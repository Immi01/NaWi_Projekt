package at.htldornbirn.projects.nawi.navigation;

import org.lwjgl.opengl.Display;
import org.newdawn.slick.*;

public class Animation implements Actor{

    private float y;
    private float x;
    private float sizeX;
    private float sizeY;
    private static int yGoal;
    private static int xGoal;
    private static int aGoalX;
    private static int aGoalY;
    private float time;
    private final float xSpeed;
    private final float ySpeed;
    private final float aSpeedX;
    private final float aSpeedY;
    private boolean finished;
    Image image;
    private AngelCodeFont font;
    private String title;
    private String description;


    public Animation(int y, int x, int sizeX, int sizeY, GameContainer gameContainer,Image image,AngelCodeFont font) {
        this.y = y;
        this.x = x;
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        xGoal = 10;
        yGoal = 10;
        aGoalX = gameContainer.getWidth() - xGoal * 2;
        aGoalY = gameContainer.getHeight() - yGoal * 2;
        float speed = 0.01f;
        xSpeed = (x - xGoal) * speed;
        ySpeed = (y - yGoal) * speed;
        aSpeedX = (aGoalX - sizeX) * speed;
        aSpeedY = (aGoalY - sizeY) * speed;
        this.image = image;
        this.font = font;
        this.title = "";
        this.description = "";
    }


    @Override
    public void update(int delta) {
        time += delta/1000f;
        if (x > xGoal)
            x -= time * xSpeed;
        else
            x = xGoal;

        if (y > yGoal)
            y -= time * ySpeed;
        else
            y = yGoal;

        if (sizeX < aGoalX)
            sizeX += time * aSpeedX;
        else
            sizeX = aGoalX;

        if (sizeY < aGoalY)
            sizeY += time * aSpeedY;
        else {
            sizeY = aGoalY;
            finished = true;
        }
    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getX() {
        return x;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image.getScaledCopy((int)sizeX,(int)sizeY),x,y);
        graphics.drawRect(x,y,sizeX,sizeY);
        font.drawString(Display.getWidth()/2-font.getWidth(title)/2, 100, title, Color.gray);
        font.drawString(100, 200, description, Color.gray);
    }

    public boolean isFinished() {
        return finished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
