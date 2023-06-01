package at.htldornbirn.projects.nawi.Team2.code.Background;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class ExplinationButton implements Actor{
    private boolean isPushed;
    private float positionX, positionY, width, height;

    public ExplinationButton(float positionX, float positionY, float width, float height){
        this.isPushed = false;
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
    }


    @Override
    public void init(GameContainer gameContainer) throws SlickException {

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(int delta) {

    }
}
