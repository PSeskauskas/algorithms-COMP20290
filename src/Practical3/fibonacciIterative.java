package Practical3;

import util.StdOut;
import util.Stopwatch;

/* Iterative Java implementation of the Fibonacci sequence, taking in a number N and returning the Nth term of the
* Fibonacci sequence. Iteratively adding the two previous numbers in the sequence to obtain the current number of the
* sequence.
*
* @Author: Patrikas Seskauskas */

public class fibonacciIterative {
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