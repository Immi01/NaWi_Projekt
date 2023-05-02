package at.htldornbirn.projects.nawi.Team2.code;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

import java.util.ArrayList;
import java.util.List;

public class InclinedPlane2 extends  BasicGameState{
    private List<Actor> actors;
    private Triangle triangle;
    private Slider slider;
    private SetAngle setAngle = new SetAngle();



    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gameContainer, StateBasedGame stateBasedGame) throws SlickException {
        this.actors = new ArrayList<>();

        for (int i = 0; i <1; i++) {
            Sky sky = new Sky();
            this.actors.add(sky);
        }
        for (int i = 0; i <1; i++) {
            Background background = new Background();
            this.actors.add(background);
        }
        for (int i = 0; i <1; i++) {
            Sun sun = new Sun();
            this.actors.add(sun);
        }

        for (int i = 0; i <1; i++) {
            Cloud cloud = new Cloud(5,5,5);
            this.actors.add(cloud);
        }

        this.triangle = new Triangle(20);
        this.slider = new Slider(200, 200);
        slider.addListener(setAngle);
    }



    @Override
    public void render(GameContainer gameContainer, StateBasedGame stateBasedGame, Graphics graphics) throws SlickException {
        for (Actor actors:this.actors){
            actors.render(graphics);
        }
        triangle.render(gameContainer,graphics);
        slider.render(gameContainer,graphics);

    }

    @Override
    public void update(GameContainer gameContainer, StateBasedGame stateBasedGame, int delta) throws SlickException {
        for (Actor actors:this.actors){
            actors.update(delta);
        }

        slider.update(gameContainer);

    }


}


