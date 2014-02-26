/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package selectionsort;

import java.util.Random;

/**
 *
 * @author dwight
 */
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        int[] numbers = new int[20];
        int lowestNumber;
        int lowestLocation = 0;
        int temp;
        boolean complete;
        
        for (int index = 0; index < numbers.length; index++) {
            numbers[index] = random.nextInt(100);
        }
        
        outputArray(numbers);
        
        for (int i = 0; i < numbers.length - 1; i++){
            lowestNumber = numbers[i];
            lowestLocation = i;
            
            for (int j = 1; j < numbers.length; j++){        
                if (numbers[j] < lowestNumber){
                    lowestNumber = numbers[j];
                    lowestLocation = j;
                }
            }
            
            temp = numbers[i];
            numbers[i] = numbers[lowestLocation];
            numbers[lowestLocation] = temp;
            
            outputArray(numbers);
        }
            
    }
    
    public static void outputArray(int[] array) {
        for (int index = 0; index < array.length; index++){
                System.out.print(array[index] + " ");
            }
        System.out.println();
    }
    
}
