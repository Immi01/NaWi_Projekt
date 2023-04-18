package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.*;
import org.newdawn.slick.gui.GUIContext;
import org.newdawn.slick.util.ResourceLoader;

import java.awt.FontFormatException;
import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Pattern;



public class Main extends BasicGame {
    public Main(String title) {
        super(title);
    }
    private InputField inputField;


    @Override
    public void init(GameContainer gc) throws SlickException {
        try {
            InputStream inputStream = ResourceLoader.getResourceAsStream("src/at/htldornbirn/projects/nawi/Team9/fonts/Anuphan/Anuphan-VariableFont_wght.ttf");
            java.awt.Font awtFont = java.awt.Font.createFont(java.awt.Font.TRUETYPE_FONT, inputStream);
            awtFont = awtFont.deriveFont(24f); // set font size
            TrueTypeFont font = new TrueTypeFont(awtFont, false);
            inputField = new InputField(font, 100, 100, 200, 30, 5, Pattern.compile("\\d+"));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(GameContainer gc, int delta) throws SlickException {
    }



    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.drawString("Enter an integer (max length 5):", 100, 70);
        inputField.render((GUIContext) gameContainer.getInput(), graphics);
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


