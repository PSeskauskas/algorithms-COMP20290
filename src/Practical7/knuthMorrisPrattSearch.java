package Practical7;

public class knuthMorrisPrattSearch {
    public static void knuthMorrisPratt (String pat, String txt)
    {
        //Store the lengths of the two strings
        int M = pat.length();
        int N = txt.length();

        //create lps[] that will hold the longest prefix suffix values for pat string
        int lps[] = new int[M];

        //index for pat string
        int j = 0;

        //Preprocess the pattern (calculate lps[] array)
        computeLPSArray(pat, M, lps);

        //Create an index for the string
        int i = 0;

        //Loop until i equals N
        while(i < N) {
            //If pat[j] equals txt[i], increment the indexes
            if(pat.charAt(j) == txt.charAt(i)) {
                i++;
                j++;
            }
            //If j equals M, print out the index of the match and compute the jump
            if(j == M) {
                System.out.println("Found pattern " + "at index " + (i - j));
                j = lps[j - 1];
            }
            //If i less than N and the characters of the strings don't match, compute the jump if j isn't 0 or increment
            //the index i.
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

    public static void computeLPSArray(String pat, int M, int lps[])
    {
        //length of the previous longest prefix suffix
        int len = 0;
        int i = 1;
        //lps[0] is always 0
        lps[0] = 0;

        //Loop until i = M
        while (i < M) {
            //If characters are equal at indexes i and len, increment the indexes and update the lps array
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            //Else if the characters at indexes i and len aren't equal, execute this code
            else
            {
                //If len isn't 0, update the len variable with the corresponding index of the lps array
                if(len != 0) {
                    len = lps[len - 1];
                }
                //Else, update the lps array and increment the variable i
                else
                {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }

    public static void main(String args[])
    {
        String txt = "ABABDABACDABABCABAB";
        String pat = "ABABCABAB";
        knuthMorrisPratt(pat, txt);
    }
}
