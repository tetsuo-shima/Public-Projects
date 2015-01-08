/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonacciarithmetic;

import java.util.Scanner;

/**
 *
 * @author dwight
 */
public class FibonacciArithmetic {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int fibCount;
        long fib1 = 0L;
        long fib2 = 1L;
        long total = 1L;
        
        System.out.print("Enter the nth Fibonacci number to be found: ");
        fibCount = keyboard.nextInt();
        
        while (fibCount > 1){
            total = fib1 + fib2;
            fib1 = fib2;
            fib2 = total;
            fibCount--;
        }
        
        System.out.println("Fibonacci number: " + total);
    }
    
}
