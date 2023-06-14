package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.*;


public class PlayButton implements Actor {

    private float x, y, width, height;
    private AngelCodeFont font;
    private Image image;


    public PlayButton(float x, float y, float width, float height, Image image) throws SlickException {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
        this.image = image;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.drawImage(image.getScaledCopy((int)width,(int)height),x,y);
        font.drawString(x+width/2-font.getWidth("PLAY")/2,y+height/2-20,"PLAY", Color.yellow);

    }

    @Override
    public void update(int delta) {

    }

    @Override
    public float getY() {
        return y;
    }

    @Override
    public float getX() {
        return x;
    }

    public float getWidth() {
        return width;
    }

    public float getHeight() {
        return height;
    }
}
