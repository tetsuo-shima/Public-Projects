/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package scrollable.tip.calculator;

import java.awt.BorderLayout;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.text.DecimalFormat;

/**
 *
 * @author dwight
 */
public class CalculatorWindow extends JFrame{
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final TipSlider tipSlider;
    private final JPanel sliderPanel;
    private final PromptData billInput;
    private final JPanel billPanel;
    private final PromptData tipOutput;
    private final JPanel tipPanel;
    double tipPercentage;
    double bill;
    double tip;
    
    public CalculatorWindow() {
        WINDOW_WIDTH = 350;
        WINDOW_HEIGHT = 150;
        
        billInput = new PromptData("Enter bill and press enter ($):", 10);
        billPanel = billInput.loadPanel();
        billInput.getTextField().
                addActionListener(new InputTextFieldListener());
        
        tipSlider = new TipSlider();
        tipSlider.getSlider().addChangeListener(new TipSliderListener());
        sliderPanel = new JPanel();
        sliderPanel.add(tipSlider.getSlider());
        
        tipOutput = new PromptData("Tip ($):", 10);
        tipOutput.getTextField().setEditable(false);
        tipPanel = tipOutput.loadPanel();
        
        setTitle("Tip Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(billPanel, BorderLayout.NORTH);
        add(sliderPanel, BorderLayout.CENTER);
        add(tipPanel, BorderLayout.SOUTH);
        
        billPanel.setBorder(BorderFactory.createEtchedBorder());
        sliderPanel.setBorder(BorderFactory.createEtchedBorder());
        tipPanel.setBorder(BorderFactory.createEtchedBorder());
        
        setVisible(true);
    }
    
    public void outputTip() {
        tipPercentage = tipSlider.getSlider().getValue()/100.0;
        bill = Double.parseDouble(billInput.getTextField().getText());
        tip = tipPercentage * bill;
        tipOutput.getTextField().setText(formatTip(tip));
    }
    
    public String formatTip(double cash){
        return new DecimalFormat("#,##0.00").format(cash);
    }
    
    private class InputTextFieldListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            outputTip();
        }
    }
    
    private class TipSliderListener implements ChangeListener {
        @Override
        public void stateChanged(ChangeEvent event) {
            outputTip();
        }   
    }   
}