package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.*;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Main extends BasicGame {
    public Main(String title) {
        super(title);
    }


    @Override
    public void init(GameContainer gc) throws SlickException {
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {

        }



    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {

    }
    public static void main(String[] argv) {
        try {
            AppGameContainer container = new AppGameContainer(new Main("Analyzing"));
            container.setDisplayMode(1600, 800, false);
            container.start();
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}


