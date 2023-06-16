package at.htldornbirn.projects.nawi.Team8.slider;

public class SetAngle implements SliderListener {

    private float sliderValue;
    private double angleVelocityMultiplier;


    @Override
    public void onChange(float mouseY) {
        //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
        angleVelocityMultiplier = ((mouseY - 200) / 40) + 0;
        System.out.println(angleVelocityMultiplier);
    }

    //Gibt den Wert des sliders zurück
    public float getSliderValue() {
        return sliderValue;
    }



    public double getAngleVelocityMultiplier() {
        return angleVelocityMultiplier;
    }
}
