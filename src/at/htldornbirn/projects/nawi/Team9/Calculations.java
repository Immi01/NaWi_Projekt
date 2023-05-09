package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Graphics;

import java.util.Objects;

public class Calculations implements Actor {
    private double watt;
    private double ps = 0.0;
    private double gravitation = 9.81;
    private double height = 1.0;
    private double kg;
    private double work;
    private double time = 1.0;
    private Team9Game team9Game;


    public Calculations(Team9Game game) {
        this.team9Game = game;

    }

    @Override
    public void render(Graphics graphics) {

    }

    @Override
    public void update(int delta) {
        if (team9Game.getInputFieldRN().getValue() == null || Objects.equals(team9Game.getInputFieldRN().getValue(), "")) {
            work = 0;
            watt = 0;
            ps = 0;
        } else {
            work = Math.round((gravitation * height * Double.parseDouble(team9Game.getInputFieldRN().getValue()))*100.0)/100.0;
            watt = work / time;
            ps = Math.round((watt/735.5)*100.0)/100.0;
        }
    }

    public double getWatt() {
        return watt;
    }

    public double getPs() {
        return ps;
    }

    public double getWork() {
        return work;
    }

    public double getTime() {
        return time;
    }

    public double getGravitation() {
        return gravitation;
    }

    public double getHeight() {
        return height;
    }
}
