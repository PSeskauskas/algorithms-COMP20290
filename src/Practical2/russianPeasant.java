package Practical2;

import util.StdOut;
import util.Stopwatch;
import util.generateRandomArray;

/* Java implementation of the Russian Peasant multiplication algorithm. The algorithm takes in two integers a and b,
* the current value of a is appended to the result variable with each iteration of the while loop, if and only if by is
* an odd value. Double the value of a and half the value of b and continue while the value of b is not equal to zero.
*
* @Author: Patrikas Seskauskas */

public class russianPeasant {
    private russianPeasant() {}
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