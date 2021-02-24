package Practical3;

import util.StdOut;
import util.Stopwatch;

/* Recursive Java implementation of the Fibonacci sequence. My implementation uses double recursion to obtain the Nth
* value of the fibonacci sequence. The Nth term is obtained by adding the two previous terms in the sequence.
*
* @Author: Patrikas Seskauskas */

public class fibonacciRecursive {
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