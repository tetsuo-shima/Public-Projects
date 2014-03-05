/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package joe.s.automotive.gui.c07p06.gaddis;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author dwight
 */
public class JoesWorkOrder extends JFrame{
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final JCheckBox oilChangeCheckBox;
    private final JCheckBox lubeJobCheckBox;
    private final JCheckBox radiatorFlushCheckBox;
    private final JCheckBox transmissionFlushCheckBox;
    private final JCheckBox inspectionCheckBox;
    private final JCheckBox mufflerReplacementCheckBox;
    private final JCheckBox tireRotationCheckBox;
    private final JLabel messageLabel;
    private final JButton calculateButton;
    private final JPanel northPanel;
    private final JPanel centerPanel;
    private double price;
    
    public JoesWorkOrder(){
        WINDOW_WIDTH = 275;
        WINDOW_HEIGHT = 300;
        messageLabel = new JLabel("SERVICE OPTIONS");
        oilChangeCheckBox = new JCheckBox("Oil Change: $26.00");
        oilChangeCheckBox.addItemListener(new CheckBoxListener());
        lubeJobCheckBox = new JCheckBox("Lube Job: $18.00");
        lubeJobCheckBox.addItemListener(new CheckBoxListener());
        radiatorFlushCheckBox = new JCheckBox("Radiator Flush: $30.00");
        radiatorFlushCheckBox.addItemListener(new CheckBoxListener());
        transmissionFlushCheckBox = 
                new JCheckBox("Transmission Flush: $80.00");
        transmissionFlushCheckBox.addItemListener(new CheckBoxListener());
        inspectionCheckBox = new JCheckBox("Inspection: $15.00");
        inspectionCheckBox.addItemListener(new CheckBoxListener());
        mufflerReplacementCheckBox = 
                new JCheckBox("Muffler Replacement: $100.00");
        mufflerReplacementCheckBox.addItemListener(new CheckBoxListener());
        tireRotationCheckBox = new JCheckBox("Tire Rotation: $20.00");
        tireRotationCheckBox.addItemListener(new CheckBoxListener());
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        northPanel = new JPanel();
        centerPanel = new JPanel();
        
        setTitle("Joe's Automotive Shop");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        
        northPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        northPanel.add(messageLabel);
        centerPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        centerPanel.add(oilChangeCheckBox);
        centerPanel.add(lubeJobCheckBox);
        centerPanel.add(radiatorFlushCheckBox);
        centerPanel.add(transmissionFlushCheckBox);
        centerPanel.add(inspectionCheckBox);
        centerPanel.add(mufflerReplacementCheckBox);
        centerPanel.add(tireRotationCheckBox);
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel,BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private class CheckBoxListener implements ItemListener{

        @Override
        public void itemStateChanged(ItemEvent event) {
            if (event.getSource() == oilChangeCheckBox){
                if (oilChangeCheckBox.isSelected()){
                    price += Constants.OIL_CHANGE_PRICE;
                }
                else if (!oilChangeCheckBox.isSelected()){
                    price -= Constants.OIL_CHANGE_PRICE;
                }
            }
            
            if (event.getSource() == lubeJobCheckBox){
                if (lubeJobCheckBox.isSelected()){
                    price += Constants.LUBE_JOB_PRICE;
                }
                else if (!lubeJobCheckBox.isSelected()){
                    price -= Constants.LUBE_JOB_PRICE;
                }
            }
            
            if (event.getSource() == radiatorFlushCheckBox){
                if (radiatorFlushCheckBox.isSelected()){
                    price += Constants.RADIATOR_FLUSH_PRICE;
                }
                else if (!radiatorFlushCheckBox.isSelected()){
                    price -= Constants.RADIATOR_FLUSH_PRICE;
                }
            }
            
            if (event.getSource() == transmissionFlushCheckBox){
                if (transmissionFlushCheckBox.isSelected()){
                    price += Constants.TRANSMISSION_FLUSH_PRICE;
                }
                else if (!transmissionFlushCheckBox.isSelected()){
                    price -= Constants.TRANSMISSION_FLUSH_PRICE;
                }
            }
            
            if (event.getSource() == inspectionCheckBox){
                if (inspectionCheckBox.isSelected()){
                    price += Constants.INSPECTION_PRICE;
                }
                else if (!inspectionCheckBox.isSelected()){
                    price -= Constants.INSPECTION_PRICE;
                }
            }
            
            if (event.getSource() == mufflerReplacementCheckBox){
                if (mufflerReplacementCheckBox.isSelected()){
                    price += Constants.MUFFLER_REPLACEMENT;
                }
                else if (!mufflerReplacementCheckBox.isSelected()){
                    price -= Constants.MUFFLER_REPLACEMENT;
                }
            }
            
            if (event.getSource() == tireRotationCheckBox){
                if (tireRotationCheckBox.isSelected()){
                    price += Constants.TIRE_ROTATION_PRICE;
                }
                else if (!tireRotationCheckBox.isSelected()){
                    price -= Constants.TIRE_ROTATION_PRICE;
                }
            }
        }  
    }
    
    private class CalculateButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            DecimalFormat money = new DecimalFormat("#,##0.00");
            String output = "Job Price: $" + money.format(price);
           
           JOptionPane.showMessageDialog(null, output);
        }
        
    }
}
