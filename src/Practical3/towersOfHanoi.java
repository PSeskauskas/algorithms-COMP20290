package Practical3;

/* @Author: Patrikas Seskauskas (19369726) */

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;

public class towersOfHanoi {
    /**
     * Recursive Java implementation for the Towers of Hanoi problem. The method outputs the moves required to move the
     * N disks from the source to the destination peg. Disk == 0 is the base case of my algorithm.
     *
     * @param disk an integer variable representing the number of disks
     * @param source a char variable representing the source peg
     * @param dest a char variable representing the destination peg
     * @param auxiliary a char variable representing the middle/temporary peg
     */
    public static void towers(int disk, char source, char dest, char auxiliary) {
        if(disk == 0) { return; }
        else {
            towers(disk - 1, source, auxiliary, dest);
            StdOut.println("Disk " + disk + " from " + source + " to " + dest);
            towers(disk - 1, auxiliary, dest, source);
        }
    }
    public static void main(String[] args) {
        int numDisks = -1;
        while(numDisks < 0) {
            StdOut.println("Please enter the number of disks you'd like to move from peg A to peg C");
            numDisks = StdIn.readInt();
        }
        Stopwatch timer = new Stopwatch();
        towers(numDisks, 'A', 'C', 'B');
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}