package at.htldornbirn.projects.nawi.Team3;

import org.newdawn.slick.state.GameState;

import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Slider {

    private JSlider slider;
    private float value;

    public Slider(float min, float max) {
        slider = new JSlider(JSlider.HORIZONTAL, (int)min, (int)max, (int)min);
        slider.addChangeListener(new SliderChangeListener());
        value = min;
    }


    public JSlider getSlider() {
        return slider;
    }

    public float getValue() {
        return value;
    }

    private class SliderChangeListener implements ChangeListener {

        @Override
        public void stateChanged(ChangeEvent e) {
            JSlider source = (JSlider)e.getSource();
            if (!source.getValueIsAdjusting()) {
                value = source.getValue();
            }
        }

    }
}
