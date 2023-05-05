package at.htldornbirn.projects.nawi.Team2.code.slider;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;

public class SetAngle implements EventListener {

    private float sliderValue;

    //Berechnet Winkel für die Schiefe Ebene
    //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
    @Override
    public void onChange(float mouseY) {
        sliderValue = ((mouseY-200)/20)+10;
        System.out.println(sliderValue);
    }

    public float getSliderValue() {
        return sliderValue;
    }
}
