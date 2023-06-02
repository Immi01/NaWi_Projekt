package at.htldornbirn.projects.nawi.Team8;


import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Ball implements Actor{
    private float centerX;
    private float centerY;
    private float radius;
    private float angle;
    private Button speedButton;

    public Ball(float centerX, float centerY, float radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.angle = 0;
        float speedButtonY = 0;
        float speedButtonX = 0;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

    }
}
