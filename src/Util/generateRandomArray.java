package Util;

import java.util.*;

/* @Author: Patrikas Seskauskas (19369726) */

public class generateRandomArray {
    /**
     * Generate Array is used to generate an array of size n containing random integers to be used in the testing of the
     * algorithms implemented in the module.
     *
     * @param n the size of the array to be generated
     * @return the newly created array
     */
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n) + 1;
        }
        return array;
    }
}