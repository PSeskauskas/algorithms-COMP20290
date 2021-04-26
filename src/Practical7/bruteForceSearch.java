package Practical7;

import Util.StdOut;

/* @Author: Patrikas Seskauskas (19369726) */

public class bruteForceSearch {
    /**
     * Brute force search checks if each character in the pattern matches a subsequence of the string, if not, the search
     * starts all over again at the next index in the search string.
     *
     * @param txt the string to be checked for a pattern
     * @param pat the pattern string
     * @return an integer representing the found starting index of the pattern in the string, if the pattern isn't found
     * return -1
     */
    public static int search(String txt, String pat)
    {
        int n = txt.length();
        int m = pat.length();
        for(int i = 0; i <= n - m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            if(j == m) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args)
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        int index = search(txt, pat);
        if(index == -1) {
            StdOut.println("Pattern not found");
        }
        else {
            StdOut.println("Pattern starts at index " + index);
        }
    }
}
