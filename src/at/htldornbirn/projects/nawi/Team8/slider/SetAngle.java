package at.htldornbirn.projects.nawi.Team8.slider;

public class SetAngle implements SliderListener {

    private float sliderValue;

    @Override
    public void onChange(float mouseY) {
        //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
        sliderValue = ((mouseY-200)/40)+10;
        System.out.println(sliderValue);
    }

    //Gibt den Wert des sliders zurück
    public float getSliderValue() {
        return sliderValue;
    }
}
