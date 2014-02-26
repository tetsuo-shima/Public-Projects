/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fibonaccirecursive;

import java.util.Scanner;

/**
 *
 * @author dwight
 */
public class FibonacciRecursive {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        long fibCount;
        long total;
        
        System.out.print("Enter the nth Fibonacci number to be found: ");
        fibCount = keyboard.nextInt();
        
        total = fibonacci(fibCount);
        
        System.out.println("Fibonacci number: " + total);
    }
    
    public static long fibonacci(long n){
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibonacci(n-1) + fibonacci(n-2);
    }
}
