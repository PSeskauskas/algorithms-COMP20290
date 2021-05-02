package Practical2;

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;
import Util.generateRandomArray;

import java.util.Arrays;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical2/russianPeasant.java
 *  Execution: java Practical2/russianPeasant
 *  */

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

    /**
     * Main method allows the user to choose between having a randomly generated array of size N or to input two integers
     * to be multiplied themselves.
     * Once the user chooses, they are prompted to enter the size of the array/2 integers. The size of the array portion
     * contains error testing.
     * If a randomly generated array is chosen, then the generateRandomArray class in Util is called and returns the array
     * of size N. And multiplies each index by index + 1 until it reaches the end of the array
     * @param args
     */
    public static void main(String[] args) {
        boolean finished = false;

        while(!finished) {
            StdOut.print("Please choose\n1. To generate a random array of numbers to run the algorithm on on\n2. To enter " +
                    "two numbers of your choice\n");
            int pick = StdIn.readInt();

            if (pick == 1) {
                int size = -1;
                while(size < 1) {
                    StdOut.println("Please enter the size of the randomly generated array here");
                    size = StdIn.readInt();
                }
                int[] a = generateRandomArray.generateArray(size);
                StdOut.println(Arrays.toString(a));
                Stopwatch timer = new Stopwatch();
                for (int i = 0; i < a.length - 1; i++) {
                    StdOut.println(a[i] + " x " + a[i + 1]);
                    StdOut.println(calculation(a[i], a[i + 1]));
                }
                StdOut.println("elapsed time for entire array = " + timer.elapsedTime());
                finished = true;
            }

            else if (pick == 2) {
                StdOut.print("Please enter the two integers you would like to multiply\n");
                int first = StdIn.readInt();
                int second = StdIn.readInt();
                StdOut.println(first + " x " + second);
                Stopwatch timer = new Stopwatch();
                StdOut.println(calculation(first, second));
                StdOut.println("elapsed time = " + timer.elapsedTime());
                finished = true;
            }

            else {
                StdOut.println("Error, you must select a valid option");
            }
        }
    }
}