/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insertionsortswap;

import java.util.Random;

/**
 *
 * @author dwight
 */
public class InsertionSortSwap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] numbers = new int[20];
        int i, j;
        int temp;
        
        randomlyInitializeIntArray(numbers);
        outputArray(numbers);
        
        for (i = 1; i < numbers.length; i++){
            j = i;
            
            while ((j > 0) && (numbers[j-1] > numbers[j])) {
                temp = numbers[j];
                numbers[j] = numbers[j-1];
                numbers[j-1] = temp;
                j--;
            }
             
            outputArray(numbers);
        }
    }
    
    public static void randomlyInitializeIntArray(int[] array){
        Random random = new Random();
        
        for (int index = 0; index < array.length; index++) {
            array[index] = random.nextInt(100);
        }
    }
    
    public static void outputArray(int[] array) {
        for (int index = 0; index < array.length; index++){
                System.out.print(array[index] + " ");
            }
        System.out.println();
    }
    
}
