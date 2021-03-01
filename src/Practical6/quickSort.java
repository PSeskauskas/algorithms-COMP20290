package Practical6;
import util.Stopwatch;
import util.generateRandomArray;

import java.util.Arrays;

public class quickSort {
    /* Array is the input to be sorted, start is the starting index, end is the end index */
    public static void sort(int[] array, int start, int end) {
        /* Base case for this recursive function */
        if(start < end) {
            /* Piv is the partitioning index */
            int piv = partition(array, start, end);
            /* Sort before piv */
            sort(array, start, piv - 1);
            /* Sort after piv */
            sort(array, piv + 1, end);
        }
    }
    /* Array is partitioned so that every element to the left of the pivot, is smaller than the pivot and every element
    * to the right of the pivot is greater than the pivot */
    public static int partition(int[] array, int start, int end) {
        /* Pivot holds the element to be placed in the correct position */
        int pivot = array[end];
        int pi = start;
        for(int j = start; j <= end - 1; j++) {
            /* If the element at index j is less than the pivot, swap the elements at indexes pi and j and increment pi */
            if(array[j] < pivot) {
                swap(array, pi, j);
                pi++;
            }
        }
        /* Swap elements at index pi and end and return the index pi */
        swap(array, pi, end);
        return pi;
    }
    /* Helper Function: Swap elements at index i and j */
    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    public static void main(String[] args) {
        /* Generate a random array of size N */
        int[] array = generateRandomArray.generateArray(100000);
        Stopwatch timer = new Stopwatch();
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}
