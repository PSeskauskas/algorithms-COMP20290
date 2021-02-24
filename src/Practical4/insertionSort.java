package Practical4;

import util.Stopwatch;
import util.generateRandomArray;

import java.util.Arrays;

/* Insertion sort compares the current element i with the previous adjacent
 * elements in the array, these comparisons reveal that the element can be inserted
 * at a particular position prior to index i, once the comparisons are complete,
 * space is created for the element to be inserted in its new position by shifting
 * the other elements to the right by one index and then inserting the element in
 * its correct position. This is repeated until the array is fully sorted
 *
 * @Author: Patrikas Seskauskas */

public class insertionSort {
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
    public static void main(String[] args) {
        int[] array = generateRandomArray.generateArray(100000);
        Stopwatch timer = new Stopwatch();
        sort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}
