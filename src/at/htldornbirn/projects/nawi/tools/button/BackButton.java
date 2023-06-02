package at.htldornbirn.projects.nawi.tools.button;

import at.htldornbirn.projects.nawi.Constants;
import at.htldornbirn.projects.nawi.navigation.Actor;
import org.lwjgl.input.Mouse;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.state.StateBasedGame;

public class BackButton implements Actor {
    private float mouseX;
    private float mouseY;
    private float y,x;
    StateBasedGame stateBasedGame;


    public BackButton(int y, int x, StateBasedGame stateBasedGame) {
        this.y = y;
        this.x = x;
        this.stateBasedGame = stateBasedGame;
    }


    @Override
    public void render(Graphics graphics) {
        graphics.drawRect(this.x,this.y,200,100);
    }

    @Override
    public void update(int delta) {
        mouseX = Mouse.getX();
        mouseY = (Mouse.getY() - 600) * -1;
    }


    public void changeState()
    {
        if ((mouseX >= x && mouseX < x + 200) && (mouseY >= y && mouseY < y + 100)) {
            if(stateBasedGame.getState(Constants.NAVIGATION) == stateBasedGame.getCurrentState())
            {
                System.out.println("Already in Navigation");
                return;
            }
            stateBasedGame.enterState(Constants.NAVIGATION);

        }
    }
    @Override
    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    @Override
    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }
}

