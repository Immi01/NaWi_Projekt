package at.htldornbirn.projects.nawi.Team5;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Dopplereffect extends BasicGameState {

    private int x;
    private int y;
    private int speed;
    private int savedSpeed;
    private Image ambulance;
    private Image person;
    private Image background;
    private float waveSize;
    private long lastWaveTime;
    private List<Wave> waves;
    private boolean paused;
    private float nextWaveDelay = 1; // Standardwert von 1 Sekunde, sonst Wellenabstand broken


    @Override
    public int getID() {
        return Constants.TEAM5;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.x = -400;
        this.y = 550;
        this.speed = 0; // 5 ist Maximum weil gleich schnell wie Schall Geschwindigkeit
        this.savedSpeed = this.speed;
        this.waveSize = 0;
        this.lastWaveTime = 0;
        this.waves = new ArrayList<>();
        this.paused = false;

        this.ambulance = new Image("at/htldornbirn/projects/nawi/Team5/res/Rettung.png");
        this.background = new Image("at/htldornbirn/projects/nawi/Team5/res/City2.png");
        this.person = new Image("/src/at/htldornbirn/projects/nawi/Team5/res/Person.png");
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0, gameContainer.getWidth(), gameContainer.getHeight(), 0, 0, background.getWidth(), background.getHeight());
        g.drawImage(ambulance, this.x, this.y);
        g.drawImage(person, 800,550);


        for (Wave wave : waves) {
            if (wave.getSize() > 0) {
                g.setColor(new Color(0, 255, 255, 255));
                g.drawOval(wave.getX() - wave.getSize() / 2, wave.getY() - wave.getSize() / 2, wave.getSize(), wave.getSize());
            }
        }
    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int i) throws SlickException {
        this.x += this.speed;
        //respawner vom Auto
        if (this.x > 1500) {
            this.x = -400;
        }

        // Frequenz
        long currentTime = System.currentTimeMillis();
        if (currentTime - lastWaveTime > nextWaveDelay * 500) { // Umrechnung in Millisekunden, 1000 = 1sec
            Wave wave = new Wave(this.x + 180, this.y);
            waves.add(wave);
            lastWaveTime = currentTime;
        }

        // welle bleibt auf krankenwagen
        Iterator<Wave> waveIterator = waves.iterator();
        while (waveIterator.hasNext()) {
            Wave wave = waveIterator.next();
            wave.update();
            // despawn von wellen

            if(this.x == -400)
            {waveIterator.remove();}

            else if (wave.getX() > gameContainer.getWidth() + 100) {
                waveIterator.remove();
            }
        }
    }


    @Override
    public void keyPressed(int key, char c) {
        if (key == Input.KEY_SPACE) {
            if (this.speed == 0) {
                this.speed = this.savedSpeed;
            } else {
                this.savedSpeed = this.speed;
                this.speed = 0;
            }
        } else if (key == Input.KEY_1) {
            setSpeed(1); // am Langsamsten
        } else if (key == Input.KEY_2) {
            setSpeed(2); // Langsamer
        } else if (key == Input.KEY_3) {
            setSpeed(3); // Normal
        } else if (key == Input.KEY_4) {
            setSpeed(4); // schnell
        } else if (key == Input.KEY_5) {
        setSpeed(5); // Schallgeschwindigkeit
    }
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}
