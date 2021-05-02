package Practical9;

import Util.StdOut;

import java.util.Scanner;

/**
 * @Author: Patrikas Seskauskas (19369726)
 * Compilation: javac Practical9/RunLengthEncoding.java
 * Execution: java Practical9/RunLengthEncoding
 */

public class RunLengthEncoding {
    /**
     * Compresses the string into each character followed by the number of occurrences of that character. For example,
     * "aaaabbbbcccc" would be compressed to "a4b4c4"
     * @param s a string
     */
    public static void compress(String s) {
        int count = 1;
        s += " ";
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) != s.charAt(i - 1)) {
                StdOut.print(s.charAt(i - 1));
                if(count > 1) { StdOut.print(count); }
                count = 1;
            } else {
                count++;
            }
        }
        StdOut.println();
    }

    /**
     * Main method to take in the user input for the string that will be compressed, the user is prompted until they
     * enter a valid string of size greater than 0.
     * @param args
     */
    public static void main(String[] args) {
        String string = "";
        Scanner scanner = new Scanner(System.in);
        while(string.length() < 1) {
            StdOut.println("Please enter the string to be compressed here");
            string = scanner.nextLine();
        }
        StdOut.println("Original String: " + string);
        StdOut.print("Compressed String: ");
        compress(string);
    }
}
