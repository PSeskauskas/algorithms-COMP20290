package Practical3;

import Util.StdIn;
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
    public static int fibonacci(int n) {
        if(n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    public static void main (String[] args)
    {
        StdOut.println("Please enter the nth term of the fibonacci sequence here");
        int n = StdIn.readInt();
        Stopwatch timer = new Stopwatch();
        StdOut.println("Element at position " + n + ": " + fibonacci(n));
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}