package Practical9;

import Util.StdOut;

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
    }

    public static void main(String[] args) {
        StdOut.println("Original String: " + args[0]);
        StdOut.print("Compressed String: ");
        compress(args[0]);
    }
}
