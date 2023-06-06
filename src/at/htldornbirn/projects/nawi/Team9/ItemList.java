package at.htldornbirn.projects.nawi.Team9;

import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

import java.util.Objects;

public class ItemList implements Actor {
    private Team9Game team9Game;
    private Calculations calculations;
    private int InfoFieldX = 1320;
    private int InfoFieldY = 0;

    public ItemList(Team9Game game) {
        this.team9Game = game;
        this.calculations = new Calculations(team9Game);
    }

    @Override
    public void render(Graphics graphics) {
        graphics.setColor(Color.black); // setting color of list
        if (team9Game.getInputFieldRN().getText() == null || Objects.equals(team9Game.getInputFieldRN().getText(), "")) {
            graphics.drawString("Weight: " + "0" + " kg", InfoFieldX, InfoFieldY + 40);
        } else {
            graphics.drawString("Weight: " + calculations.getInputValue() + " kg", InfoFieldX, InfoFieldY + 40);
        }
        graphics.drawString("Work: " + calculations.getWork() + " joules", InfoFieldX, InfoFieldY + 60);
        graphics.drawString("Height: " + calculations.getHeight() + " m", InfoFieldX, InfoFieldY + 80);
        graphics.drawString("Gravitation: " + calculations.getGravitation() + " m/s²", InfoFieldX, InfoFieldY + 100);
        graphics.drawString("Time: " + calculations.getTime() + " seconds", InfoFieldX, InfoFieldY + 120);
        graphics.drawString("Power: " + calculations.getWatt() + " watt", InfoFieldX, InfoFieldY + 140);
        graphics.drawString("Power: " + calculations.getPs() + " ps", InfoFieldX, InfoFieldY + 160);
        graphics.setBackground(Color.white);
    }

    @Override
    public void update(int delta) {
        calculations.update(delta);
    }
}
