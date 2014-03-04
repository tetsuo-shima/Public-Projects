/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gaddis_c07p05.theater.revenue;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author dwight
 */
public class TheaterRevenueCalculator extends JFrame{
    private final int WINDOW_WIDTH;
    private final int WINDOW_HEIGHT;
    private final TicketsGUIComponents adultTickets;
    private final TicketsGUIComponents childTickets;
    private final JButton calculateButton;
    
    public TheaterRevenueCalculator(){
        this.WINDOW_WIDTH = 300;
        this.WINDOW_HEIGHT = 125;
        adultTickets = new TicketsGUIComponents("Adult tickets sold:", 10);
        childTickets = new TicketsGUIComponents("Child tickets sold:", 10);
        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(new CalculateButtonListener());
        
        setTitle("Theater Revenue Calculator");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        setLayout(new BorderLayout());
        add(adultTickets.getPanel(), BorderLayout.NORTH);
        add(childTickets.getPanel(), BorderLayout.CENTER);
        add(calculateButton, BorderLayout.SOUTH);
        
        setVisible(true);
    }
    
    private class CalculateButtonListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent event) {
            DecimalFormat money = new DecimalFormat("#,##0.00");
            int adultTicketsSold = 
                    Integer.parseInt(adultTickets.getTextField().getText());
            int childTicketsSold = 
                    Integer.parseInt(childTickets.getTextField().getText());
            double adultGross = adultTicketGross(adultTicketsSold);
            double adultNet = netAdultRevenue(adultTicketsSold);
            double childGross = childTicketGross(childTicketsSold);
            double childNet = netChildRevenue(childTicketsSold);
            
            String output = "Adult Ticket Gross Revenue: $" +
                    money.format(adultGross) +
                    "\nAdult Ticket Net Revenue: $" +
                    money.format(adultNet) +
                    "\nChild Ticket Gross Revenue: $" +
                    money.format(childGross) +
                    "\nChild Ticket Net Revenue: $" +
                    money.format(childNet) +
                    "\n\nTotal Gross Revenue: $" + 
                    money.format(adultGross + childGross) +
                    "\nTotal Net Revenue: $" + 
                    money.format(adultNet + childNet);
            
            JOptionPane.showMessageDialog(null, output);
        }
        
        private double adultTicketGross(int ticketsSold){
            return ticketsSold * Constants.ADULT_TICKET_PRICE;
        }
        
        private double childTicketGross(int ticketsSold){
            return ticketsSold * Constants.CHILD_TICKET_PRICE;
        }
        
        private double netAdultRevenue(int ticketsSold){
            return adultTicketGross(ticketsSold) * Constants.THEATER_TAKE;
        }
        
        private double netChildRevenue(int ticketsSold){
            return childTicketGross(ticketsSold) * Constants.THEATER_TAKE;
        }
        
    }
    
}
