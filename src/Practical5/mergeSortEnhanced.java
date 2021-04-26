package Practical5;

import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;
import Practical4.insertionSort;

import java.util.Arrays;

/* @Author: Patrikas Seskauskas (19369726) */

public class mergeSortEnhanced {
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
        for(int k = 0; k <= hi; k++) {
            aux[k] = a[k];
        }
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
     * then the two halves are merged together, leaving us with the sorted array. The method uses some improvements to the
     * algorithm given in the practical sheet. For example, calling insertion sort on smaller size arrays, and checking if
     * parts of the array is already sorted.
     *
     * @param array to be sorted
     * @param aux array to be used as a helper in the sorting
     * @param l lowest index of the array
     * @param r highest index of the array
     */
    public static void sort(int[] array, int[] aux, int l, int r) {
        if(r <= (l + 10)) {
            insertionSort.sort(array, l, r);
            return;
        }
        int mid = l + (r - l) / 2;
        sort(array, aux, l, mid);
        sort(array, aux, mid + 1, r);
        if (!(array[mid + 1] < array[mid])) {
            return;
        }
        merge(array, aux, l, mid, r);
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray.generateArray(100000);
        int[] aux = new int[array.length];
        Stopwatch timer = new Stopwatch();
        sort(array, aux,0, array.length - 1);
        StdOut.println(Arrays.toString(array));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}