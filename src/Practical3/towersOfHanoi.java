package Practical3;

/* Recursive Java implementation for the Towers of Hanoi problem. The implementation takes in the number of disks, the
* source peg, the auxiliary or middle peg and the destination peg and outputs the moves required to move the N disks
* from the source peg to the destination peg. Disk == 0 is used as the base case.
*
* @Author: Patrikas Seskauskas */

public class towersOfHanoi {
    public static void towers(int disk, char source, char dest, char auxiliary) {
        if(disk == 0) { return; }
        else {
            towers(disk - 1, source, auxiliary, dest);
            System.out.println("Disk " + disk + " from " + source + " to " + dest);
            towers(disk - 1, auxiliary, dest, source);
        }
    }
    public static void main(String[] args) {
        int n = 5;
        towers(n, 'A', 'C', 'B');
    }
}