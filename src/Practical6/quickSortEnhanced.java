package Practical6;

import Practical4.insertionSort;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/* @Author: Patrikas Seskauskas (19369726) */

public class quickSortEnhanced {
    /**
     * Sort works recursively. First finding the pivot element, and then recursively sorting the subarrays before and
     * after the pivot, once the two subarrays are fully sorted, the array is fully sorted. This sort contains some
     * improvements, i.e., calling insertion sort for smaller subarrays, and getting the median of the array and validating
     * that it is at the correct index.
     *
     * @param array to be sorted
     * @param start the first index of the array
     * @param end the final index of the array
     */
    public static void sort(int[] array, int start, int end) {
        if(end <= start + 10) {
            insertionSort.sort(array, start, end);
            return;
        }
        if(start < end) {
            int median = medianOf3(array, start, start + (end - start) / 2, end);
            swap(array, start, median);
            int j = partition(array, start, end);
            sort(array, start, j - 1);
            sort(array, j + 1, end);
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
     * The array is shuffled to avoid worst case performance for quick sort
     *
     * @param array to be shuffled
     */
    public static void shuffle(int[] array) {
        int n = array.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (i + 1));
            swap(array, r, i);
        }
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
     * Median of 3 is used to validate that the median value of the array is in its correct position by comparing the
     * elements and swapping them accordingly.
     *
     * @param array containing elements
     * @param start the starting index
     * @param mid the midpoint index
     * @param end the final index
     * @return the midpoint of the array
     */
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
        int[] array = generateRandomArray.generateArray(100000);
        Stopwatch timer = new Stopwatch();
        shuffle(array);
        sort(array, 0, array.length - 1);
        StdOut.println(Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}