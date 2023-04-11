package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.*;
import java.awt.Font;

public class Main extends BasicGame {
    public Main(String title) {
        super(title);
    }

    private TextField kgInput;
    private TrueTypeFont font;

    @Override
    public void init(GameContainer gc) throws SlickException {
        kgInput = new TextField(gc, gc.getDefaultFont(), 100, 100, 100, 20);
        kgInput.setBorderColor(Color.white);

        java.awt.Font awtFont = new Font("Arial", Font.BOLD, 16);
        font = new TrueTypeFont(awtFont, true);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) throws SlickException {
        kgInput.setFocus(true);
        kgInput.setCursorPos(kgInput.getText().length());
        }



    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        kgInput.render(gameContainer, graphics);
        font.drawString(120, 600, kgInput.getText(), Color.white);
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


