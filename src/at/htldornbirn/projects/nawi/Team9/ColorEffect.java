package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;

public class ColorEffect {
    private Color color;
    private long duration;
    private long startTime;

    public ColorEffect(Color color, long duration) {
        this.color = color;
        this.duration = duration;
        this.startTime = System.currentTimeMillis();
    }

    public Color getColor() {
        long elapsedTime = System.currentTimeMillis() - startTime;
        float percentComplete = (float) elapsedTime / duration;

        if (percentComplete > 1f) {
            percentComplete = 1f;
        }

        return new Color(
                (int) (color.getRed() * percentComplete),
                (int) (color.getGreen() * percentComplete),
                (int) (color.getBlue() * percentComplete),
                (int) (color.getAlpha() * percentComplete));
    }
}
