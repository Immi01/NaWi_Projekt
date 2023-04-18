package at.htldornbirn.projects.nawi.Team9;
import java.util.regex.Pattern;

import org.newdawn.slick.Color;
import org.newdawn.slick.gui.TextField;
import org.newdawn.slick.TrueTypeFont;

public class InputField extends TextField {
    private int maxLength;
    private Pattern pattern;

    /*

    https://chat.openai.com/c/c561fe79-47c2-4db0-81cb-cb18cec80dbe?__cf_chl_rt_tk=_jg2JXkc6Km5a978hAtCrBogdSn5.nDsmkCG.qzQQus-1681808627-0-gaNycGzNGqU

    */
    public InputField(TrueTypeFont font, int x, int y, int width, int height) {
        super(null, x, y, width, height, new Color(0,0,0,0), font);
    }

    public InputField(TrueTypeFont font, int x, int y, int width, int height, int maxLength) {
        this(font, x, y, width, height);
        this.maxLength = maxLength;
    }

    public InputField(TrueTypeFont font, int x, int y, int width, int height, Pattern pattern) {
        this(font, x, y, width, height);
        this.pattern = pattern;
    }

    public InputField(TrueTypeFont font, int x, int y, int width, int height, int maxLength, Pattern pattern) {
        this(font, x, y, width, height, maxLength);
        this.pattern = pattern;
    }

    @Override
    public void keyPressed(int key, char c) {
        if (maxLength > 0 && getText().length() >= maxLength && key != 14 && key != 211) {
            return;
        }
        if (pattern != null && !pattern.matcher(getText() + c).matches()) {
            return;
        }
        super.keyPressed(key, c);
    }

    @Override
    public void setText(String value) {
        if (maxLength > 0 && value.length() > maxLength) {
            value = value.substring(0, maxLength);
        }
        if (pattern != null && !pattern.matcher(value).matches()) {
            return;
        }
        super.setText(value);
    }

    public int getIntValue() {
        return Integer.parseInt(getText());
    }
}
