package Practical8;

/* Java implementation of search and insert operations on a Trie */
public class Trie {
    /* 26 characters in English alphabet */
    static final int ALPHABET_SIZE = 26;

    /* Class for TrieNode */
    static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET_SIZE];
        /* isEndOfWord is true if the node represents end of a word, i.e., a leaf node */
        boolean isEndOfWord;

        TrieNode() {
            isEndOfWord = false;

            for(int i = 0; i < ALPHABET_SIZE; i++) {
                children[i] = null;
            }
        }

        static TrieNode root;

        /* If not key present, inserts into trie, If the key is a prefix of a Trie node, mark as a leaf node */
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

            /* Mark the last node as a leaf node */
            searchNode.isEndOfWord = true;
        }

        /* Returns true if key is present in trie, else, return false */
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

        /* Main method */
        public static void main(String[] args) {
            String[] keys = {"bank", "book", "bar", "bring", "film", "filter", "simple", "silt", "silver"};

            String[] output = {"Not present in trie", "Present in trie"};

            root = new TrieNode();

            /* Construct trie */
            int i;
            for(i = 0; i < keys.length; i++) {
                insert(keys[i]);
            }

            /* Search for different keys */
            if(search("bar")) {
                System.out.println("bar - " + output[1]);
            } else {
                System.out.println("bar - " + output[0]);
            }

            if(search("film")) {
                System.out.println("film - " + output[1]);
            } else {
                System.out.println("film - " + output[0]);
            }

            if(search("boo")) {
                System.out.println("boo - " + output[1]);
            } else {
                System.out.println("boo - " + output[0]);
            }

            if(search("ban")) {
                System.out.println("ban - " + output[1]);
            } else {
                System.out.println("ban - " + output[0]);
            }

        }
    }
}
