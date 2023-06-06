package at.htldornbirn.projects.nawi.Team8.Backgroundcolor;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Actor {
    void init(GameContainer gameContainer) throws SlickException;
    public void render(Graphics graphics);

    public void update(GameContainer gameContainer, int delta);
}
