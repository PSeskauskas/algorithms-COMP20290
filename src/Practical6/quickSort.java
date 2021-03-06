package Practical6;
import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical6/quickSort.java
 *  Execution: java Practical6/quickSort
 *  */

public class quickSort {
    /**
     * Sort works recursively. First finding the pivot element, and then recursively sorting the subarrays before and
     * after the pivot, once the two subarrays are fully sorted, the array is fully sorted.
     *
     * @param array to be sorted
     * @param start the first index of the array
     * @param end the final index of the array
     */
    public static void sort(int[] array, int start, int end) {
        if(start < end) {
            int piv = partition(array, start, end);
            sort(array, start, piv - 1);
            sort(array, piv + 1, end);
        }
    }

    /**
     * Partition the array to be sorted so that every element to the left of the pivot is smaller than the pivot and every
     * element to the right of the pivot is greater than the pivot. Swaps are done using the swap helper method.
     *
     * @param array to be partitioned
     * @param start the starting index
     * @param end the ending index
     * @return the index of the pivot
     */
    public static int partition(int[] array, int start, int end) {
        int pivot = array[end];
        int pi = start;
        for(int j = start; j <= end - 1; j++) {
            if(array[j] < pivot) {
                swap(array, pi, j);
                pi++;
            }
        }
        swap(array, pi, end);
        return pi;
    }

    /**
     * Swap helper method to swap the elements at two indexes of the array
     *
     * @param array containing the elements to be sorted
     * @param i the index of the variable to be swapped
     * @param j the index of the variable to be swapped
     */
    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
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
        sort(array, 0, array.length - 1);
        StdOut.println("Sorted array: " + Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
