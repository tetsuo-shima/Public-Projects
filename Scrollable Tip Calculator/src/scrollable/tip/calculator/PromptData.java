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
public class PromptData {
    private final JLabel label;
    private final JTextField textField;
    
    public PromptData(String label, int fieldSize) {
        this.label = new JLabel(label);
        this.textField = new JTextField(null, "0.00", fieldSize);
    }
    
    public JLabel getLabel() {
        return label;
    }
    
    public JTextField getTextField() {
        return textField;
    }
    
    public JPanel loadPanel() {
        JPanel panel = new JPanel();
        panel.add(label);
        panel.add(textField);
        
        return panel;
    }
    
}
