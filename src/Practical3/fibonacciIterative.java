package Practical3;

import Util.StdOut;
import Util.Stopwatch;

/* @Author: Patrikas Seskauskas (19369726) */

public class fibonacciIterative {
    /**
     * Iterative Java implementation of the Fibonacci sequence, the method adds the two previous numbers in the sequence
     * to obtain the current number of the sequence
     *
     * @param n an integer variable
     * @return the nth number in the fibonacci sequence
     */
    static int fibonacci(int n) {
        if (n<=1)
            return 1;

        int fib = 1;
        int prevFib =  1;

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
        }
        return fib;
    }

    public static void main (String args[])
    {
        int n = 10;
        Stopwatch timer = new Stopwatch();
        System.out.println(fibonacci(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}