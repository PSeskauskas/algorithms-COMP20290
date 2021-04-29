package Practical4;

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/* @Author: Patrikas Seskauskas (19369726) */

public class selectionSort {
    /**
     * Java implementation of the selection sort algorithm. Selection sort finds the smallest value in the array and swaps
     * it with the element at index 0. Then it finds the second smallest value and swaps it with the element at index 1
     * and so on. This process continues until the array is fully sorted.
     *
     * @param array to be sorted
     */
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
        int size = -1;
        while(size < 1) {
            StdOut.println("Please enter the size of the randomly generated array here");
            size = StdIn.readInt();
        }
        int[] array = generateRandomArray.generateArray(size);
        StdOut.println("Unsorted array: " + Arrays.toString(array));
        Stopwatch timer = new Stopwatch();
        sort(array);
        StdOut.println("Sorted array: " + Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
