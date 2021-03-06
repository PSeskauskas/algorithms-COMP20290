package Practical5;

import java.util.Arrays;
import Util.*;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical5/mergeSort.java
 *  Execution: java Practical5/mergeSort
 *  */

public class mergeSort {
    /**
     * The merge method copies the contents of the sorted array halves into the aux array, then, the two sorted halves of
     * the aux array are merged together into the original array in sorted order.
     *
     * @param a the array to be sorted
     * @param aux the array to be used as the helper
     * @param lo the lowest index of the array
     * @param mid the midpoint index of the array
     * @param hi the highest index of the array
     */
    public static void merge(int[] a, int[] aux, int lo, int mid, int hi) {
        int i = lo;
        int j = mid + 1;
        /* Copy array a into array aux */
        for (int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
        /* For loop to merge back the elements from the aux array into the array a */
        for (int k = lo; k <= hi; k++) {
            if (i > mid) {
                a[k] = aux[j++];
            } else if (j > hi) {
                a[k] = aux[i++];
            } else if (aux[j] < aux[i]) {
                a[k] = aux[j++];
            } else {
                a[k] = aux[i++];
            }
        }
    }

    /**
     * Sort works recursively. Sorting the array before and after the midpoint. The arrays are sorted recursively and
     * then the two halves are merged together, leaving us with the sorted array
     *
     * @param array to be sorted
     * @param aux array to be used as a helper in the sorting
     * @param l lowest index of the array
     * @param r highest index of the array
     */
    public static void sort(int[] array, int[] aux, int l, int r) {
        if (l < r) {
            int mid = l + (r - l) / 2;
            sort(array, aux, l, mid);
            sort(array, aux, mid + 1, r);
            merge(array, aux, l, mid, r);
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
        int[] aux = new int[array.length];
        StdOut.println("Unsorted array: " + Arrays.toString(array));
        Stopwatch timer = new Stopwatch();
        sort(array, aux, 0, array.length - 1);
        StdOut.println("Sorted array: " + Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}