package at.htldornbirn.projects.nawi.Team5;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Dopplereffect extends BasicGameState {

    private int x;
    private int y;
    private int speed;
    private int savedSpeed;
    private int timerToZero = 1000;
    private Image ambulance;
    private Image person;
    private Image background;
    private Image menu;
    private float waveSize;
    private long lastWaveTime;
    private List<Wave> waves;
    private boolean paused;
    private float nextWaveDelay = 1; // Standardwert von 1 Sekunde, sonst Wellenabstand broken
    private int xPerson;
    private int yPerson;
    private long enterZoneTime;
    Music music;
    private float xMenu;
    private float xString;
    private int showspeed;
    private float elapsedTime = 0;
    private float pitch;



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
        this.xPerson = 800;
        this.yPerson = 550;
        this.xMenu = 0;
        this.xString = 50;
        this.pitch = 1;



        music = new Music("/src/at/htldornbirn/projects/nawi/Team5/res/alarm.ogg");
        this.ambulance = new Image("at/htldornbirn/projects/nawi/Team5/res/Rettung.png");
        this.background = new Image("at/htldornbirn/projects/nawi/Team5/res/City2.png");
        this.person = new Image("/src/at/htldornbirn/projects/nawi/Team5/res/Person.png");
        this.menu = new Image("/src/at/htldornbirn/projects/nawi/Team5/res/Menu.png");


    }

    private void playSirene() {

        music.play(this.pitch, 100f);
    }

    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawImage(background, 0, 0, gameContainer.getWidth(), gameContainer.getHeight(), 0, 0, background.getWidth(), background.getHeight());
        g.drawImage(ambulance, this.x, this.y);
        g.drawImage(person, xPerson, yPerson);
        g.drawImage(menu, xMenu, 0);
        g.drawString("Press SPACE to STOPP / START the car", xString, 70);
        g.drawString("Press 1 to set speed to very slow", xString, 150);
        g.drawString("Press 2 to set speed to slow", xString, 180);
        g.drawString("Press 3 to set speed to normal", xString, 210);
        g.drawString("Press 4 to set speed to fast", xString, 240);
        g.drawString("Press 5 to set speed to very fast", xString, 270);
        g.drawString("Press enter to start game",xString,350);
        g.drawString(speed + " Gang",900, 40);
        g.drawString(showspeed + " km/h",900, 60);
        g.drawString(  elapsedTime/1000  + " Timer",900, 80);




        for (Wave wave : waves) {
            if (wave.getSize() > 0) {
                g.setColor(new Color(0, 255, 255, 255));
                g.drawOval(wave.getX() - wave.getSize() / 2, wave.getY() - wave.getSize() / 2, wave.getSize(), wave.getSize());
            }
        }


    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {

        this.timerToZero -= delta;
        if (this.timerToZero <0 && this.xMenu != 0) {
            playSirene();
            this.timerToZero = 1000;
        }
        if(this.x == 100){
            this.pitch =1.2f;
        }if(this.x == 300){
            this.pitch =1.4f;
        }if(this.x == 500){
            this.pitch =1.6f;
        }if(this.x == 700){
            this.pitch =1.8f;
        }if(this.x == 750){
            this.pitch =1.6f;
        }if(this.x == 800){
            this.pitch =1.4f;
        }


        this.x += this.speed;
        //respawner vom Auto
        if (this.x > 1500) {
            this.x = -400;
        }
        if (this.x >= 700 && this.x <= 900) {
            if (enterZoneTime == 0) {
                enterZoneTime = System.currentTimeMillis(); // Setze den Zeitpunkt, wenn der Rettungswagen in den Bereich eintritt
            }

            long currentTime = System.currentTimeMillis();
            elapsedTime = currentTime - enterZoneTime;

            if (elapsedTime >= 4000) {
                this.xPerson = gameContainer.getWidth() + 300;
            }
        } else if (this.x == -400) {
            this.xPerson = 800;
            enterZoneTime = 0; // Zurücksetzen des Zeitpunkts, wenn der Rettungswagen den Bereich verlässt
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

            if (this.x == -400) {
                waveIterator.remove();
            } else if (wave.getX() > gameContainer.getWidth() + 100) {
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
        } else if (key == Input.KEY_1 && this.xMenu != 0) {
            setSpeed(1);
            showspeed = 50;// am Langsamsten
        } else if (key == Input.KEY_2 && this.xMenu != 0) {
            setSpeed(2);
            showspeed = 100; // Langsamer
        } else if (key == Input.KEY_3 && this.xMenu != 0) {
            setSpeed(3); // Normal
            showspeed = 200;
        } else if (key == Input.KEY_4 && this.xMenu != 0) {
            setSpeed(4); // schnell
            showspeed = 300;
        } else if (key == Input.KEY_5 && this.xMenu != 0) {
            setSpeed(5); // Schallgeschwindigkeit
            showspeed = 1234;

        } else if (key == Input.KEY_ENTER) {
            this.xMenu = 3000;
            this.xString = 3000;
            if (this.x == -400) {
                setSpeed(2); // Beim Fahren nach dem Enter speed
            }
        }
    }

    public void setSpeed(int newSpeed) {
        this.speed = newSpeed;
    }
}