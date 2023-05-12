package at.htldornbirn.projects.nawi.Team2.code;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class CalculateButton {

    private Calculations calculations;

    public CalculateButton() {
        this.calculations = new Calculations();
    }

    public void update(GameContainer gameContainer) throws SlickException {

        Input input = gameContainer.getInput();
        int mouseY = input.getMouseY();
        int mouseX = input.getMouseX();
        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (mouseY>700 && mouseY<730 && mouseX >100 && mouseX < 250){
                calculations.update(gameContainer);
            }
        }
    }

    public void render(GameContainer gameContainer, Graphics graphics) throws SlickException {
        graphics.fillRect(100,700,150,30);
        calculations.render(gameContainer,graphics);
    }
}
