package at.htldornbirn.projects.nawi.Team8;

import jdk.internal.icu.util.CodePointMap;
import jdk.internal.org.objectweb.asm.TypeReference;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;

public class Ball implements Actor{
    private float centerX;
    private float centerY;
    private float radius;
    private float angle;
    private float speedButton;

    public Ball(float centerX, float centerY, float radius) {
        this.centerX = centerX;
        this.centerY = centerY;
        this.radius = radius;
        this.angle = 0;
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.blue);
        graphics.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);
    }

    @Override
    public void update(GameContainer gameContainer, int delta) {

        angle += (delta / 1000.0f) * speedButton.getValue();
        float x = centerX + (float) Math.cos(angle) * radius;
        float y = centerY + (float) Math.sin(angle) * radius;
    }
}
