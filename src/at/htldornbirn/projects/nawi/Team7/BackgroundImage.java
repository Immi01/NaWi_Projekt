package at.htldornbirn.projects.nawi.Team7;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

public class BackgroundImage implements ProjectActor {
    private Image MercuryImage;

    public BackgroundImage() throws SlickException {
        MercuryImage = new Image("images/backgroundImage1.png");
    }

    @Override
    public void render(Graphics graphics) {
        MercuryImage.draw(100,100);
    }

    @Override
    public void update(GameContainer gc, int delta) {

    }
}
