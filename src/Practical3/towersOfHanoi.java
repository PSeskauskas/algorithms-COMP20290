package Practical3;

/* @Author: Patrikas Seskauskas (19369726) */

import util.StdOut;

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
        int n = 5;
        towers(n, 'A', 'C', 'B');
    }
}