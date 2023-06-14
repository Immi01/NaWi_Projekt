package at.htldornbirn.projects.nawi.Team1.ElementInferno;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.*;
import org.newdawn.slick.geom.Ellipse;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Vector2f;

public class ElementInferno extends BasicGameState {
    private Rectangle[] rectangles;
    private Rectangle selectedRectangle;
    private Vector2f mouseOffset;
    private Ellipse targetCircle;
    private Image backgroundImage;
    private Image torchImage;
    private Image[] elementImages;
    private Image[] flameImages;
    private Vector2f[] initialPositions;
    private boolean[] isRectangleInCircle;
    private boolean standardFlame = true;

    public ElementInferno() {
    }

    @Override
    public void init(GameContainer container, StateBasedGame stateBasedGame) throws SlickException {
        rectangles = new Rectangle[5];
        elementImages = new Image[5];
        flameImages = new Image[5];
        isRectangleInCircle = new boolean[5];

        int elementSize = 80;
        int spacing = (container.getWidth() - (elementSize * rectangles.length)) / (rectangles.length + 1);
        int startY = container.getHeight() - elementSize - 50;

        int torchSize = 300;
        int torchX = (container.getWidth() - torchSize) / 2;
        int torchY = (container.getHeight() - torchSize) / 2 + 100;

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle((i + 1) * spacing + i * elementSize, startY, elementSize, elementSize);
        }

        initialPositions = new Vector2f[rectangles.length];
        for (int i = 0; i < rectangles.length; i++) {
            initialPositions[i] = new Vector2f(rectangles[i].getX(), rectangles[i].getY());
        }

        targetCircle = new Ellipse(torchX + 130, torchY + 30, 100, 100);

        backgroundImage = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/background.png")
                .getScaledCopy(container.getWidth(), container.getHeight());

        torchImage = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/gastorch.png")
                .getScaledCopy(torchSize, torchSize);

        elementImages[0] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/lithium.jpg")
                .getScaledCopy(elementSize, elementSize);
        elementImages[1] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/natrium.png")
                .getScaledCopy(elementSize, elementSize);
        elementImages[2] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/kalium.jpg")
                .getScaledCopy(elementSize, elementSize);
        elementImages[3] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/rubidium.jpg")
                .getScaledCopy(elementSize, elementSize);
        elementImages[4] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/thc.png")
                .getScaledCopy(elementSize, elementSize);

        flameImages[0] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/redflame.png");
        flameImages[1] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/yellowflame.png");
        flameImages[2] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/blueflame.png");
        flameImages[3] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/redflame.png");
        flameImages[4] = new Image("src/at/htldornbirn/projects/nawi/Team1/ElementInferno/img/greenflame.png");
    }

    @Override
    public void update(GameContainer container, StateBasedGame stateBasedGame, int delta) throws SlickException {
        Input input = container.getInput();
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        standardFlame = true;

        if (input.isMouseButtonDown(Input.MOUSE_LEFT_BUTTON)) {
            if (selectedRectangle == null) {
                for (int i = 0; i < rectangles.length; i++) {
                    if (rectangles[i].contains(mouseX, mouseY)) {
                        selectedRectangle = rectangles[i];
                        mouseOffset = new Vector2f(mouseX - selectedRectangle.getX(), mouseY - selectedRectangle.getY());
                        break;
                    }
                }
            } else {
                selectedRectangle.setX(mouseX - mouseOffset.x);
                selectedRectangle.setY(mouseY - mouseOffset.y);
            }
        } else {
            if (selectedRectangle != null) {
                if (targetCircle.contains(selectedRectangle.getCenterX(), selectedRectangle.getCenterY())) {
                    int index = rectanglesToIndex(selectedRectangle);
                    isRectangleInCircle[index] = true;
                    standardFlame = false;
                    float circleX = targetCircle.getCenterX();
                    float circleY = targetCircle.getCenterY();
                    float elementX = circleX - selectedRectangle.getWidth() / 2;
                    float elementY = circleY - selectedRectangle.getHeight() / 2;
                    selectedRectangle.setX(elementX);
                    selectedRectangle.setY(elementY);
                } else {
                    int index = rectanglesToIndex(selectedRectangle);
                    isRectangleInCircle[index] = false;
                    selectedRectangle.setX(initialPositions[index].getX());
                    selectedRectangle.setY(initialPositions[index].getY());
                }
                selectedRectangle = null;
            }
        }
    }


    @Override
    public void render(GameContainer container, StateBasedGame stateBasedGame, Graphics g) throws SlickException {
        g.drawImage(backgroundImage, 0, 0);
        g.drawImage(torchImage, 250, 320);

        if (standardFlame) {
            flameImages[2].draw(362, 58);
        }

        for (int i = 0; i < rectangles.length; i++) {
            Rectangle rectangle = rectangles[i];
            Image elementImage = elementImages[i];
            Image flameImage = flameImages[i];

            if (rectangle == selectedRectangle) {
                if (!targetCircle.contains(rectangle.getCenterX(), rectangle.getCenterY())) {
                    elementImage.draw(rectangle.getX(), rectangle.getY());
                }
            } else {
                if (targetCircle.contains(rectangle.getCenterX(), rectangle.getCenterY())) {
                    elementImage.draw(rectangle.getX(), rectangle.getY());
                    flameImage.draw(362, 58);
                } else {
                    elementImage.draw(rectangle.getX(), rectangle.getY());
                }
            }
        }

        if (selectedRectangle != null) {
            int selectedIndex = rectanglesToIndex(selectedRectangle);
            g.drawImage(elementImages[selectedIndex], (int) selectedRectangle.getX(), (int) selectedRectangle.getY());
        }
    }


    private int rectanglesToIndex(Rectangle rect) {
        for (int i = 0; i < rectangles.length; i++) {
            if (rectangles[i] == rect) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int getID() {
        return Constants.TEAM1;
    }
}
