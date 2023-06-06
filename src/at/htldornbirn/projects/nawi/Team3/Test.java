package at.htldornbirn.projects.nawi.Team3;


import org.newdawn.slick.*;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

import javax.swing.*;
import java.awt.*;

public class Test extends StateBasedGame {


    public Test(String name) {
        super(name);
    }
    @Override
    public void initStatesList(GameContainer gameContainer) throws SlickException {
        addState(new StopingDistance2());

    }



    public static void main(String[] args) throws SlickException {
        AppGameContainer container = new AppGameContainer(new Test("Nawi Portal"));
        container.setDisplayMode(800, 600, false);
        container.start();
        //Car car = new Car();
        //this.actors.add(car);
    }

}


