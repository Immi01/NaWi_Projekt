package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class Horse implements Actor {
    private Image horseImage;
    private float x;
    private float y;
    private float speed;

    private enum DIRECTION {RIGHT, DOWN, LEFT, UP}

    ;
    DIRECTION direction = DIRECTION.LEFT;

    public Horse(float x, float y, float speed) throws SlickException {
        this.horseImage = new Image("src/at/htldornbirn/projects/nawi/Team9/pictures/horse.png");
        this.x = x;
        this.y = y;
        this.speed = speed;
    }

    @Override
    public void render(Graphics graphics) {
        horseImage.draw(this.x, this.y);
    }

    @Override
    public void update(int delta) {
        if (this.x >= -800 && direction == DIRECTION.LEFT){
            this.x -= (float) delta / this.speed;
        }
        else if (direction == DIRECTION.LEFT){
            direction = DIRECTION.RIGHT;
        }
        else if (this.x <800 && direction == DIRECTION.RIGHT){
            this.x += (float) delta / this.speed;
        }
        else if (direction == DIRECTION.RIGHT){
            direction = DIRECTION.LEFT;
        }
    }
}
