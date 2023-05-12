package at.htldornbirn.projects.nawi.Team4.Substanzensimulator;

import org.newdawn.slick.Graphics;

public class Substanzen implements Actors{

        private float x,y;
        private float speed;
        private int diameter;
        private boolean dragging;

        public Substanzen(float x, float y, float speed, int diameter,boolean dragging) {
            this.x = x;
            this.y = y;
            this.speed = speed;
            this.diameter = diameter;
            this.dragging = dragging;
        }

    public boolean isDragging() {
        return dragging;
    }

    public void setDragging(boolean dragging) {
        this.dragging = dragging;
    }

    @Override
        public void update(int delta) {
            this.y+= (float)delta/this.speed;
            if (this.y > 600){
                this.y = 0;
            }
        }

        @Override
        public void render(Graphics graphics) {
            graphics.drawOval(this.x,this.y, diameter,diameter );
        }
    }
