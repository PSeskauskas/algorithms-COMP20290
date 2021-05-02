package Practical7;

import Util.StdIn;
import Util.StdOut;
import Util.Stopwatch;

import java.util.Scanner;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical7/knuthMorrisPrattSearch.java
 *  Execution: java Practical7/knuthMorrisPrattSearch
 *  */

public class knuthMorrisPrattSearch {
    /**
     * Java implementation of the Knuth-Morris-Pratt search algorithm. The algorithm works by computing the longest prefix
     * suffix array for the pattern. Comparing the characters of each array, if the characters match, increment the two
     * indexes, else, compute a jump to be made in the search string. This algorithm is better than brute force because
     * in brute force the algorithm wouldn't jump if the characters didn't match. The method prints out the index of the
     * start of the pattern in the search string if it is found
     *
     * @param pat the pattern string
     * @param txt the search string
     */
    public static void knuthMorrisPratt (String pat, String txt)
    {
        int M = pat.length();
        int N = txt.length();
        int lps[] = new int[M];
        int j = 0;
        computeLPSArray(pat, M, lps);
        int i = 0;
        while(i < N) {
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            if(j == M) {
                StdOut.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            }
            else if(i < N && pat.charAt(j) != txt.charAt(i)) {
                if(j != 0) {
                    j = lps[j - 1];
                }
                else {
                    i += 1;
                }
            }
        }
    }

    /**
     * Method to compute the longest prefix suffix array to be used in the Knuth-Morris-Pratt algorithm. The longest
     * prefix suffix will be used as the jump when a character mismatch occurs in the search.
     *
     * @param pat the pattern string
     * @param M the size of the longest prefix suffix array
     * @param lps the array containing the longest prefix suffixes
     */
    public static void computeLPSArray(String pat, int M, int lps[])
    {
        int len = 0;
        int i = 1;
        lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else
            {
                if(len != 0) {
                    len = lps[len - 1];
                }
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    /**
     * The user is prompted to enter valid strings to be used in the searching algorithm. Prompts are run until two
     * valid strings of length greater than 0 are entered. And then the pattern is searched for in the search string
     * and the result is printed.
     * @param args
     */
    public static void main(String[] args)
    {
        String txt = "";
        String pat = "";
        Scanner readLine = new Scanner(System.in);
        while(txt.length() < 1) {
            StdOut.println("Please enter the string to be searched here");
            txt = readLine.nextLine().trim().toUpperCase();
            if(txt.length() < 1) {
                StdOut.println("Error, please enter a valid string");
            }
        }
        while(pat.length() < 1) {
            StdOut.println("Please enter the search string here");
            pat = readLine.nextLine().trim().toUpperCase();
            if(pat.length() < 1) {
                StdOut.println("Error, please enter a valid string");
            }
        }
        Stopwatch timer = new Stopwatch();
        knuthMorrisPratt(pat, txt);
        StdOut.println("elapsed time = " + timer.elapsedTime());
    }
}
