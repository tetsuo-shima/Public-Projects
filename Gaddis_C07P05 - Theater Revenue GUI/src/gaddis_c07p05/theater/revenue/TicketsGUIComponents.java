/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaddis_c07p05.theater.revenue;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author dwight
 */
public class TicketsGUIComponents {
    private final JLabel label;
    private final JTextField textField;
    private final JPanel panel;
    
    public TicketsGUIComponents(String label, int textFieldColumns){
        this.label = new JLabel(label);
        this.textField = new JTextField(null, "0", textFieldColumns);
        
        panel = new JPanel();
        
        panel.add(this.label);
        panel.add(this.textField);
    }
    
    public JLabel getLabel(){
        return label;
    }
    
    public JTextField getTextField(){
        return textField;
    }
    
    public JPanel getPanel(){
        return panel;
    }
    
}
