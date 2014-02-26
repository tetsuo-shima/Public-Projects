/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package insertionsortshuffle;

import java.util.Random;

/**
 *
 * @author dwight
 */
public class InsertionSortShuffle {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    int[] numbers = new int[20];
        int i, j;
        int key;
        
        randomlyInitializeIntArray(numbers);
        outputArray(numbers);
        
        for (i = 1; i < numbers.length; i++){
            key = numbers[i];
            
            //while ((j > 0) && (numbers[j-1] > key)) {
            for (j = i; (j > 0) && (numbers[j-1] > key); j--){
                numbers[j] = numbers[j-1];
            }
            
            numbers[j] = key;
             
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
