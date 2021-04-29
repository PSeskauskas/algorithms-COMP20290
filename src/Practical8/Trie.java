package Practical8;

import Util.StdOut;

/* @Author: Patrikas Seskauskas (19369726) */

public class Trie {
    /* 26 characters in English alphabet */
    static final int ALPHABET_SIZE = 26;

    /**
     * Nested TrieNode class
     */
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        boolean isEndOfWord;

        TrieNode() {
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

        public static void main(String[] args) {
            String[] keys = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};
            String[] output = {"Not present in trie", "Present in trie"};
            root = new TrieNode();
            int i;

            for(i = 0; i < keys.length; i++) {
                insert(keys[i]);
            }

            if(search("bar")) {
                StdOut.println("bar - " + output[1]);
            } else {
                StdOut.println("bar - " + output[0]);
            }

            if(search("film")) {
                StdOut.println("film - " + output[1]);
            } else {
                StdOut.println("film - " + output[0]);
            }

            if(search("boo")) {
                StdOut.println("boo - " + output[1]);
            } else {
                StdOut.println("boo - " + output[0]);
            }

            if(search("ban")) {
                StdOut.println("ban - " + output[1]);
            } else {
                StdOut.println("ban - " + output[0]);
            }
        }
    }
    public static void main(String[] args) {
        TrieNode.main(null);
    }
}
