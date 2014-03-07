/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scrollable.tip.calculator;

import javax.swing.*;

/**
 *
 * @author dwight
 */
public class TipSlider {
    private final int ORIENTATION = JSlider.HORIZONTAL;
    private final int SLIDER_MIN = 0;
    private final int SLIDER_MAX = 30;
    private final int SLIDER_START = 10;
    private final JSlider slider;
    
    public TipSlider() {
        slider = new JSlider(ORIENTATION, SLIDER_MIN, SLIDER_MAX, 
                SLIDER_START);
        slider.setMajorTickSpacing(5);
        slider.setMinorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
    }
    
    public JSlider getSlider() {
        return slider;
    }
}
