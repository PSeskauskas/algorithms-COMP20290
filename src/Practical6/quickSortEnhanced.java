package Practical6;

import Practical4.insertionSort;
import util.Stopwatch;
import util.generateRandomArray;

import java.util.Arrays;

public class quickSortEnhanced {
    /* Array is the input to be sorted, start is the starting index, end is the end index */
    public static void sort(int[] array, int start, int end) {
        /* Cut off for sub arrays, calling insertion sort for sub-arrays of size 10 */
        if(end <= start + 10) {
            insertionSort.sort(array, start, end);
            return;
        }
        /* Base case for this recursive function */
        if(start < end) {
            /* Get the median index and swap the elements at the starting index with the median index */
            int median = medianOf3(array, start, start + (end - start) / 2, end);
            swap(array, start, median);

            /* j is the partitioning index */
            int j = partition(array, start, end);
            /* Swap before j */
            sort(array, start, j - 1);
            /* Swap after j */
            sort(array, j + 1, end);
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
    /* Shuffle the array to improve perofmrane and protect against the worst case performance */
    public static void shuffle(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            // choose index uniformly in [0, i]
            int r = (int) (Math.random() * (i + 1));
            swap(array, r, i);
        }
    }
    /* Helper function to swap elements at index i and j */
    public static void swap(int[] array, int i, int j) {
        int temp = array[j];
        array[j] = array[i];
        array[i] = temp;
    }
    /* Median of 3 takes in the start, mid and end indexes in the array and validates that the median value is at the
    * correct index */
    public static int medianOf3(int[] array, int start, int mid, int end) {
        if(array[end] < array[start]) {
            swap(array, start, end);
        }
        else if(array[mid] < array[start]) {
            swap(array, mid, start);
        }
        else if(array[end] < array[mid]) {
            swap(array, end, mid);
        }
        return mid;
    }
    public static void main(String[] args) {
        /* Generate random array with N elements */
        int[] array = generateRandomArray.generateArray(100000);
        Stopwatch timer = new Stopwatch();
        shuffle(array);
        sort(array, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}