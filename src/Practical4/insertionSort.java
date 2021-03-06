package Practical4;

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical4/insertionSort.java
 *  Execution: java Practical4/insertionSort
 *  */

public class insertionSort {
    /**
     * Java Implementation of the insertion sort algorithm, comparing the ith element with the previous adjacent elements
     * in the array, revealing if the ith element can be inserted at a particular index prior to i, once the comparisons
     * are completed, space is created for the element to be inserted by shifting the other elements to the right by one
     * index and inserting the current element into its correct position. Process is repeated until the array is fully sorted
     *
     * @param array the array to be sorted
     * @param lo the first index of the array
     * @param hi the last index of the array
     */
    public static void sort(int[] array, int lo, int hi) {
        for (int i = 0; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
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
        sort(array,0, array.length - 1);
        StdOut.println("Sorted array: " + Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
