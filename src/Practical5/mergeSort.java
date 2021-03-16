package Practical5;

import java.util.Arrays;
import util.*;

/* Merge Sort takes in an array containing elements and an auxiliary array, the array is split in half and each half
* is sorted recursively, once both halves are sorted, the array and the auxiliary array are sent to the merge method.
* The merge method copies the contents of the sorted array halves into the auxiliary array. Then, the two sorted halves
* of the auxiliary array are merged together into the original array, the output being the original array in sorted order
*
* @Author: Patrikas Seskauskas */

public class mergeSort {
    /* Merge takes in the input array, and an aux array that will be used to copy over the elements of array, it also
     * takes in the first index, middle index and last index of the array */
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

    /* Sort takes in an input array, an aux array, and the first and last index of the array */
    public static void sort(int[] array, int[] aux, int l, int r) {
        /* If the lowest index is less than the highest index, run the code */
        if (l < r) {
            /* Setting the midpoint of the array */
            int mid = l + (r - l) / 2;
            /* Sort the first and second halves of the array */
            sort(array, aux, l, mid);
            sort(array, aux, mid + 1, r);
            /* Merge the sorted halves */
            merge(array, aux, l, mid, r);
        }
    }

    public static void main(String[] args) {
        int[] array = generateRandomArray.generateArray(100000);
        int[] aux = new int[array.length];
        Stopwatch timer = new Stopwatch();
        sort(array, aux, 0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}