package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

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

    public Animation(int y, int x, int sizeX, int sizeY, GameContainer gameContainer) {
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
        else
            sizeY = aGoalY;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(x,y,sizeX,sizeY);
    }

    @Override
    public float getY() {
        return 0;
    }

    @Override
    public float getX() {
        return 0;
    }
}
