package at.htldornbirn.projects.nawi.Team6.Gravitation;

import at.htldornbirn.projects.nawi.Constants;
import org.newdawn.slick.*;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GravityExplanation extends BasicGameState{
    private Image marsImage;
    private Image jupiterImage;
    private Image earthImage;
    private RoundedRectExample marsButton;
    private RoundedRectExample jupiterButton;
    private RoundedRectExample earthButton;
    private AngelCodeFont font;
    private RoundedRectExample backButton;

    public int getID() {
        return 64;
    }

    public void init (GameContainer gc, StateBasedGame sbg) throws SlickException {
        font = new AngelCodeFont("src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2.fnt", "src/at/htldornbirn/projects/nawi/Team6/sinefunction/assets/demo2_00.tga");
        marsImage = new Image("at/htldornbirn/projects/nawi/Team6/Gravitation/Assets/mars.png");
        jupiterImage = new Image("at/htldornbirn/projects/nawi/Team6/Gravitation/Assets/jupiter1.png");
        earthImage = new Image("at/htldornbirn/projects/nawi/Team6/Gravitation/Assets/earth.png");

        marsButton = new RoundedRectExample(250 - 45,330, 90, 30, 10, "mars", "white");
        jupiterButton = new RoundedRectExample(595, 330, 90, 30, 10, "jupiter", "white");
        earthButton = new RoundedRectExample(985, 330, 90, 30, 10, "earth", "white");
        backButton = new RoundedRectExample(1280- 180, 960-100, 150, 30, 10, "back to sinus", "white");
    }

    public void update(GameContainer gc, StateBasedGame sbg, int delta) throws SlickException{
        Input input = gc.getInput();

        if(input.isMousePressed(Input.MOUSE_LEFT_BUTTON)) {
            int mouseX = input.getMouseX();
            int mouseY = input.getMouseY();

            GameState gameState = (GameState) sbg.getState(65);

            if (marsButton.isClicked(mouseX, mouseY)) {
                gameState.setPlanet("mars");
                sbg.enterState(65);
            }

            if (jupiterButton.isClicked(mouseX, mouseY)) {
                gameState.setPlanet("jupiter");
                sbg.enterState(65);
            }

            if (earthButton.isClicked(mouseX, mouseY)) {
                gameState.setPlanet("earth");
                sbg.enterState(65);
            }

            if(backButton.isClicked(mouseX, mouseY)){
                sbg.enterState(Constants.TEAM6);
            }

        }
    }

    public void render(GameContainer gc, StateBasedGame sbg, Graphics g) throws SlickException {
        marsImage.draw(150, 100, 200, 200);
        jupiterImage.draw(540, 100, 200, 200);
        earthImage.draw(930, 100, 200, 200);

        g.setColor(Color.white);
        marsButton.render(g);
        jupiterButton.render(g);
        earthButton.render(g);
        backButton.render(g);

        g.setColor(Color.white);
        float fontFactor = 0.7f;
        g.scale(fontFactor, fontFactor);
        font.drawString(150 / fontFactor, 400 / fontFactor,
                "Gravitation ist die Kraft, die zwischen zwei Objekten aufgrund ihrer Massen besteht. Sie ist eine der fundamentalen \n" +
                        "Kräfte in der Physik und erklärt Phänomene wie das Fallen eines Apfels oder die Umlaufbahn von Planeten um die \n" +
                        "Sonne. \n" + "\n" +

                        "Die Anziehungskraft zwischen zwei Objekten aufgrund der Gravitation hängt von ihren Massen und dem Abstand  \n" +
                        "zwischen ihnen ab. Je größer die Massen der Objekte sind, desto stärker ist die Anziehungskraft.   \n" +
                        "Umgekehrt nimmt die Anziehungskraft mit zunehmendem Abstand ab.\n" + "\n" +

                        "Die allgemeine Formel zur Berechnung der Gravitationskraft zwischen zwei Objekten lautet:\n" + "\n" +
                        "F = G * (m1 * m2) / r^2 \n" + "\n" +

                        "Hierbei steht F für die Gravitationskraft, m1 und m2 repräsentieren die Massen der Objekte, r ist der Abstand \n" +
                        "zwischen ihnen und G ist die Gravitationskonstante. Die Gravitationskonstante G hat den Wert \n" +
                        "6,674 * 10^-11 m^3/(kg * s^2) und ist ein konstanter Faktor in der Formel. \n" + "\n" +

                        "Diese Formel, bekannt als das Newtonsche Gravitationsgesetz, beschreibt die Anziehungskraft zwischen zwei\n" +
                        "Körpern aufgrund ihrer Massen und ist eine wichtige Grundlage für das Verständnis der Gravitation.");
    }


}
