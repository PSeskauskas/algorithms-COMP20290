package Practical2;

import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

/* @Author: Patrikas Seskauskas (19369726) */

public class russianPeasant {

    private russianPeasant() {}

    /**
     * Java implementation of the Russian Peasant algorithm. Current value of a is appended to the result variable with
     * each iteration of the while loop, iff it is an odd value. Double the value of a and half the value of b and continue
     * whilst the value of b does not equal 0.
     *
     * @param a an integer variable
     * @param b an integer variable
     * @return the product of a and b
     */
    public static int calculation(int a, int b) {
        int result = 0;
        while(b != 0) {
            if(b % 2 == 1) {
                result += a;
            }
            a *= 2;
            b /= 2;
        }
        return result;
    }

    public static void main(String[] args)  {
        int[] a = generateRandomArray.generateArray(8);
        Stopwatch timer = new Stopwatch();
        for(int i = 0; i < a.length - 1; i++) {
            StdOut.println(a[i] + " x " + a[i + 1]);
            StdOut.println(calculation(a[i], a[i + 1]));
        }
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}