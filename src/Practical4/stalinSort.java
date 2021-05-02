package Practical4;

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical4/stalinSort.java
 *  Execution: java Practical4/stalinSort
 *  */

public class stalinSort {
    /**
     * Java implementation of the Stalin sort algorithm. Stalin sort searches an array, if the current element is not
     * greater than the previous element, then that current element is removed from the array entirely.
     *
     * @param array to be sorted
     * @return a new integer array
     */
    public static int[] sort(int[] array) {
        int temp = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(temp < array[i]) {
                temp = array[i];
                count++;
            }
            else {
                array[i] = 0;
            }
        }
        int[] copy = new int[count];
        int x = 0;
        int y = 0;
        while(x < copy.length) {
            if(array[y] == 0) {
                y++;
            }
            else {
                copy[x] = array[y];
                y++;
                x++;
            }
        }
        return copy;
    }

    /**
     * The user is prompted to enter a valid size of an integer array that will be randomly generated using the
     * generateRandomArray class in the Util package. The before and after of the array will be printed.
     * @param args
     */
    public static void main(String[] args) {
        int size = -1;
        while(size < 1) {
            StdOut.println("Please enter the size of the randomly generated array here");
            size = StdIn.readInt();
        }
        int[] array = generateRandomArray.generateArray(size);
        StdOut.println("Unsorted array: " + Arrays.toString(array));
        Stopwatch timer = new Stopwatch();
        int[] sorted = sort(array);
        StdOut.println("Sorted array: " + Arrays.toString(sorted));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
