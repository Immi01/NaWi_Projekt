package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import org.newdawn.slick.Graphics;

public class Substanzen implements Actors{

    private float x,y;

        private int diameter;
        private boolean dragging;

        public Substanzen(float x, float y,  int diameter,boolean dragging) {
            this.x = x;
            this.y = y;
            this.diameter = diameter;
            this.dragging = dragging;
        }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    @Override
        public void update(int delta) {

        }

        @Override
        public void render(Graphics graphics) {
            graphics.drawRect(this.x,this.y, diameter,diameter );
        }
    }
