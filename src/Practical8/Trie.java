package Practical8;

import Util.StdIn;
import Util.StdOut;

/**
 *  @Author: Patrikas Seskauskas (19369726)
 *  Compilation: javac Practical8/Trie.java
 *  Execution: java Practical8/Trie
 *  */

public class Trie {
    /* 26 characters in English alphabet */
    static final int ALPHABET_SIZE = 26;

    /**
     * Nested TrieNode class
     */
    public static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        public TrieNode() {
            isEndOfWord = false;
            for(int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

        static TrieNode root;

        /**
         * insert inserts the string into the trie if it isn't already in the trie. If the string is a prefix of a Trie
         * node, then mark the string as a leaf node.
         *
         * @param key to be entered in to the Trie
         */
        static void insert(String key) {
            int level;
            int length = key.length();
            int index;
            TrieNode searchNode = root;
            for(level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                if(searchNode.children[index] == null) {
                    searchNode.children[index] = new TrieNode();
                }
                searchNode = searchNode.children[index];
            }
            searchNode.isEndOfWord = true;
        }

        /**
         * Method searches for the key string in the try, if it is found, return true, if it isn't return false.
         *
         * @param key a string variable to be searched in the Trie
         * @return a boolean representing if the string is found in the Trie or not
         */
        static boolean search(String key) {
            int level;
            int length = key.length();
            int index;
            TrieNode searchNode = root;
            for(level = 0; level < length; level++) {
                index = key.charAt(level) - 'a';
                if(searchNode.children[index] == null) {
                    return false;
                }
                searchNode = searchNode.children[index];
            }
            return (searchNode != null && searchNode.isEndOfWord);
        }

        /**
         * Main method to take in user input for the number of strings that will be entered into the Trie and subsequently
         * each string in the Trie. The trie is then created and the user is prompted to enter search string or 0 to exit
         * the program
         * @param args
         */
        public static void main(String[] args) {
            int size = -1;
            while(size < 1) {
                StdOut.println("Please enter the number of strings that will be put into the Trie here\n");
                size = StdIn.readInt();
            }
            String[] keys = new String[size];

            int j = 0;
            while(j < keys.length) {
                StdOut.println("Please enter each key one by one here");
                keys[j] = StdIn.readString();
                j++;
            }

            String[] output = {"Not present in trie", "Present in trie"};
            root = new TrieNode();
            int i;

            for(i = 0; i < keys.length; i++) {
                insert(keys[i]);
            }

            String search = "";
            while(true) {
                StdOut.println("Please enter a string to search for in the trie, or else enter 0 to exit the Trie search program");
                search = StdIn.readString();
                if(search.equals("0")) {
                    break;
                }
                else if(search(search)) {
                    StdOut.println(search + " - " + output[1]);
                }
                else {
                    StdOut.println(search + " - " + output[0]);
                }
            }
        }
    }

    /**
     * Call the main method in the static class
     * @param args
     */
    public static void main(String[] args) {
        TrieNode.main(null);
    }
}
