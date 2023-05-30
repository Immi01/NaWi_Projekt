package at.htldornbirn.projects.nawi.Team7.slider;

public class SetAngle implements SliderListener {

    private float sliderValue;

    @Override
    public void onChange(float mouseY) {
        //Berechnet Winkel für die Schiefe Ebene
        //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
        sliderValue = ((mouseY-200)/20)+10;
        System.out.println(sliderValue);
    }

    //Gibt den Wert des sliders zurück
    public float getSliderValue() {
        return sliderValue;
    }
}
