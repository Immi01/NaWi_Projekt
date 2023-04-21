package at.htldornbirn.projects.nawi.Team2.code;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.lwjgl.util.vector.Vector2f;
import org.newdawn.slick.*;

import org.newdawn.slick.state.*;

public class InclinedPlane2 extends BasicGame{
    private Color backgroundColor = Color.white;
    private Triangle triangle;
    private Slider slider;


    private SetAngle setAngle = new SetAngle();


    public InclinedPlane2(String title) {
        super(title);
    }

    @Override
    public void init(GameContainer gameContainer) throws SlickException {
        this.triangle = new Triangle(20);
        this.slider = new Slider(200, 200);


        slider.addListener(setAngle);
    }

    @Override
    public void update(GameContainer gameContainer, int i) throws SlickException {
        slider.update(gameContainer);
    }

    @Override
    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.clear();
        triangle.render(gameContainer,graphics);
        slider.render(gameContainer,graphics);
        graphics.setBackground(backgroundColor);
        graphics.setColor(backgroundColor);
        graphics.fillRect(0, 0, gameContainer.getWidth(), gameContainer.getHeight());


    }

    public static void main(String[] args) {
        try {
            AppGameContainer container = new AppGameContainer(new InclinedPlane("InclinedPlane"));
            container.setDisplayMode(1500,800,false);
            container.start();
            container.setShowFPS(false);
        } catch (SlickException e) {
            e.printStackTrace();
        }
    }
}

