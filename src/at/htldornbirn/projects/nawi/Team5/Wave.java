package at.htldornbirn.projects.nawi.Team5;

public class Wave {

        private float x;
        private float y;
        private float size;
        private float growthRate;

        public Wave(float x, float y) {
            this.x = x;
            this.y = y;
            this.size = 0;
            this.growthRate = 10f;  //Wie schnell die WElle ist, wie weit sie sich in alle Richtungen Ausbreitet
        }

        public void update() {
            size += growthRate;
        }

        public float getX() {
            return x;
        }

        public float getY() {
            return y;
        }

        public float getSize() {
            return size;
        }
    }


