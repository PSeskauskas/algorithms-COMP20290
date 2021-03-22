package Practical7;

public class bruteForceSearch {
    public static int search(String txt, String pat)
    {
        //Store the lengths of the two strings
        int n = txt.length();
        int m = pat.length();
        //Loop until the index of (txt length - pattern length) is reached
        for(int i = 0; i <= n - m; i++) {
            int j;
            for(j = 0; j < m; j++) {
                //If the characters don't match, then break the nested loop and increment i
                if(txt.charAt(i + j) != pat.charAt(j)) {
                    break;
                }
            }
            //If j equals m, then return the starting index of where the pattern is found
            if(j == m) {
                return i;
            }
        }
        //Return -1 if the pattern isn't found
        return -1;
    }

    public static void main(String[] args)
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        int index = search(txt, pat);
        if(index == -1) {
            System.out.println("Pattern not found");
        }
        else {
            System.out.println("Pattern starts at index " + index);
        }
    }
}
