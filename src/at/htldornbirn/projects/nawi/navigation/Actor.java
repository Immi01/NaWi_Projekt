package at.htldornbirn.projects.nawi.navigation;

import org.newdawn.slick.Graphics;

public interface Actor {

    public void render(Graphics graphics);
    public void update(int delta);
    public float getY();
    public float getX();


}
