package at.htldornbirn.projects.nawi.Team2.code.slider;

import at.htldornbirn.projects.nawi.Team2.code.slider.EventListener;

public class SetAngle implements EventListener {

    private float sliderValue;

    public SetAngle() {
        this.sliderValue = 10;
    }

    @Override
    public void onChange(float mouseY, float startPositionY) {
        //Berechnet Winkel für die Schiefe Ebene
        //Hier kann individueller Code geschrieben werden der beim bewegen des Sliders ausgeführt wird
        //(mouseY-startPositionY) mit diesem Ausdruck wird nur der Wert des Sliders ausgegeben
        //.../20)+10 hiermit wird ein Winkel zwischen 10 und 25 berechnet
        sliderValue = ((mouseY-startPositionY)/20)+10;
        System.out.println(sliderValue);
    }

    //Gibt den Wert des sliders zurück
    public float getSliderValue() {
        return sliderValue;
    }
}
