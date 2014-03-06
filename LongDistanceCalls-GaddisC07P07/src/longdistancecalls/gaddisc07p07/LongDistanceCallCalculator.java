/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package longdistancecalls.gaddisc07p07;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author dwight
 */
public class LongDistanceCallCalculator extends JFrame{
    private final double DAYTIME_PHONE_RATE = 0.07;
    private final double EVENING_PHONE_RATE = 0.12;
    private final double OFFPEAK_PHONE_RATE = 0.05;
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final JRadioButton daytime;
    private final JRadioButton evening;
    private final JRadioButton offPeak;
    private final ButtonGroup buttonGroup;
    private final JLabel minutesLabel;
    private final JTextField minutesTextField;
    private final JPanel buttonPanel;
    private final JPanel minutesPanel;
    private final JButton calculateButton;
    private double rate;
    
    public LongDistanceCallCalculator() {
        WINDOW_WIDTH = 300;
        WINDOW_HEIGHT = 175;
        
        daytime = new JRadioButton("Daytime: 6AM-5PM");
        daytime.addItemListener(new RadioButtonListener());
        daytime.setToolTipText("$" + DAYTIME_PHONE_RATE + " per minute");
        evening = new JRadioButton("Evening: 5PM-12AM");
        evening.addItemListener(new RadioButtonListener());
        evening.setToolTipText("$" + EVENING_PHONE_RATE + " per minute");
        offPeak = new JRadioButton("Off-Peak: 12AM-6AM");
        offPeak.addItemListener(new RadioButtonListener());
        offPeak.setToolTipText("$" + OFFPEAK_PHONE_RATE +  " per minute");
        
        buttonGroup = new ButtonGroup();
        buttonGroup.add(daytime);
        buttonGroup.add(evening);
        buttonGroup.add(offPeak);
        
        minutesLabel = new JLabel("Number of minutes:");
        minutesTextField = new JTextField(null, "0", 5);
        
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        
        buttonPanel = new JPanel();
        buttonPanel.add(daytime);
        buttonPanel.add(evening);
        buttonPanel.add(offPeak);
        
        minutesPanel = new JPanel();
        minutesPanel.add(minutesLabel);
        minutesPanel.add(minutesTextField);
        
        setTitle("Long Distance Call Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        add(buttonPanel, BorderLayout.CENTER);
        add(minutesPanel, BorderLayout.NORTH);
        add(calculateButton, BorderLayout.SOUTH);
        
        minutesPanel.setBorder(BorderFactory.createEtchedBorder());
        buttonPanel.setBorder(BorderFactory.createEtchedBorder());
        
        setVisible(true);
    }
    
    private class RadioButtonListener implements ItemListener {

        @Override
        public void itemStateChanged(ItemEvent event) {  
            if (event.getSource() == daytime) {
                rate = DAYTIME_PHONE_RATE;
            }
            else if (event.getSource() == evening) {
                rate = EVENING_PHONE_RATE;
            }
            else if (event.getSource() == offPeak) {
                rate = OFFPEAK_PHONE_RATE;
            }
            else
                throw new IllegalArgumentException();
        }
    }
    
    private class CalculateButtonListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            DecimalFormat money = new DecimalFormat("#,##0.00");
            double callMinutes = Double.parseDouble(minutesTextField.getText());
            
            String output = "Call Charge: $" + money.format(rate * callMinutes);
            
            JOptionPane.showMessageDialog(null, output);
        }
    }
    
}
