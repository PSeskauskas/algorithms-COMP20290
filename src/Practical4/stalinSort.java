package Practical4;

import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/* @Author: Patrikas Seskauskas (19369726) */

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
    public static void main(String[] args) {
        int[] array = generateRandomArray.generateArray(100);
        Stopwatch timer = new Stopwatch();
        StdOut.println(Arrays.toString(sort(array)));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
