package at.htldornbirn.projects.nawi.Team3;

import at.htldornbirn.projects.nawi.tools.slider.SliderListener;

public class SetSpeed implements SliderListener {

    private float sliderValue;

    @Override
    public void onChange(float mouseX) {
        //Berechnet Winkel für die Schiefe Ebene
        //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
        sliderValue = mouseX;
        System.out.println(sliderValue);

    }

    //Gibt den Wert des sliders zurück
    public float getSliderValue() {
        return sliderValue;
    }
}
