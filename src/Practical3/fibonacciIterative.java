package Practical3;

import Util.StdIn;
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
    public static int fibonacci(int n) {
        if (n<=1)
            return 1;
        StringBuilder sequence = new StringBuilder();
        int fib = 1;
        int prevFib =  1;
        sequence.append(fib).append(", ").append(prevFib);

        for (int i = 2; i < n; i++) {
            int temp = fib;
            fib = fib + prevFib;
            prevFib = temp;
            sequence.append(", ").append(fib);
        }
        StdOut.println(sequence.toString());
        return fib;
    }

    public static void main (String args[])
    {
        StdOut.println("Please enter the nth term of the fibonacci sequence here");
        int n = StdIn.readInt();
        Stopwatch timer = new Stopwatch();
        StdOut.println("Element at position " + n + ": " + fibonacci(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}