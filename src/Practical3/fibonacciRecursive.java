package Practical3;

import Util.StdOut;
import Util.Stopwatch;

/* @Author: Patrikas Seskauskas (19369726) */

public class fibonacciRecursive {
    /**
     * Recursive Java implementation of the Fibonacci sequence. This implementation uses double recursion, by recursively
     * adding the two previous terms in the sequence.
     *
     * @param n an integer variable
     * @return the nth number in the fibonacci sequence
     */
    static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main (String[] args)
    {
        int n = 10;
        Stopwatch timer = new Stopwatch();
        System.out.println(fibonacci(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}