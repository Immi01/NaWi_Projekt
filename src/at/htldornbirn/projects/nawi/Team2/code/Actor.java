package at.htldornbirn.projects.nawi.Team2.code;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public interface Actor {
    void init(GameContainer gameContainer)throws SlickException;

    public void render(Graphics graphics);
    public void update(int delta);
}
