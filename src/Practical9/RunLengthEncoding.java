package Practical9;

import Util.StdOut;

import java.util.Scanner;

public class RunLengthEncoding {
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
