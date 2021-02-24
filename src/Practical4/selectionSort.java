package Practical4;

import util.Stopwatch;
import util.generateRandomArray;

import java.util.Arrays;

/* Selection sort finds the smallest value in the array and swaps it with the element at index 0
 * Then it finds the second smallest value and swaps it with the element at index 1
 * Then it finds the third smallest value and swaps it with the element at index 2 and so on
 * continuing until the array is sorted fully
 *
 * @Author: Patrikas Seskauskas */

public class selectionSort {
    public static void sort(int[] array) {
        int min;
        int temp;
        for(int i = 0; i < array.length; i++) {
            min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
    }
    public static void main(String[] args) {
        Stopwatch timer = new Stopwatch();
        int[] a = generateRandomArray.generateArray(1000);
        sort(a);
        System.out.println(Arrays.toString(a));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}
