package Practical4;

import util.Stopwatch;
import util.generateRandomArray;

import java.util.Arrays;

/* Stalin sort searches an array, and if an element is not in the correct order, i.e. the current element is not
 * greater than the previous element, then that current element is removed from the array entirely
 *
 * @Author: Patrikas Seskauskas */

public class stalinSort {
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
        System.out.println(Arrays.toString(sort(array)));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}
