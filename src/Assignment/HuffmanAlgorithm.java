package Assignment;

/******************************************************************************
 *  Compilation:  javac Assignment/Huffman.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 * Add instructions and documentation related to your Huffman algorithm here...
 *
 ******************************************************************************/

import Util.*;

public class HuffmanAlgorithm {
    /**
     * Variables that will hold the input and output files
     */
    private static BinaryIn binaryIn;
    private static BinaryOut binaryOut;

    /**
     * Alphabet size of extended ASCII variable
     */
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() {}

    /**
     * Huffman trie node nested class
     */
    private static class Node implements Comparable<Node> {
        private final char ch;
        private final int freq;
        private final Node left, right;

        Node(char ch, int freq, Node left, Node right) {
            this.ch    = ch;
            this.freq  = freq;
            this.left  = left;
            this.right = right;
        }

        /**
         * Method to check if a node is a leaf node or not
         * @return a boolean representing if a node is a leaf or not
         */
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        /**
         * Comparison function comparing two frequencies
         * @param that of type Node
         * @return an integer conveying the difference between the frequencies
         */
        public int compareTo(Node that) {
            return this.freq - that.freq;
        }
    }

    /**
     * Reads a sequence of 8-bit bytes from standard input; compresses them
     * using Huffman codes with an 8-bit alphabet; and writes the results
     * to standard output.
     */
    public static void compress() {
        // read the input
        char[] input = binaryIn.readString().toCharArray();
        // tabulate frequency counts
        int[] frequency = new int[R];
        for(char c : input) {
            frequency[c]++;
        }
        // build Huffman trie
        Node root = buildTrie(frequency);
        // build code table
        String[] codes = new String[R];
        buildCode(codes, root, "");
        // print trie for decoder
        writeTrie(root);
        // print number of bytes in original uncompressed message
        binaryOut.write(input.length);
        // use Huffman code to encode input
        for (char c : input) {
            String code = codes[c];
            for (int j = 0; j < code.length(); j++) {
                binaryOut.write(code.charAt(j) == '1');
            }
        }
        binaryOut.close();
    }

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {
        // read in Huffman trie from input stream
        Node root = readTrie();
        // number of bytes to write
        int numberOfBytes = binaryIn.readInt();
        // decode using the Huffman trie
        int i = 0;
        while(i < numberOfBytes) {
            Node node = root;
            while(!node.isLeaf()) {
                if(!binaryIn.readBoolean()) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            binaryOut.write(node.ch, 8);
            i++;
        }
        binaryOut.close();
    }

    /**
     * Building a Huffman trie given an array of frequencies
     * @param freq an integer array
     * @return a Node
     */
    private static Node buildTrie(int[] freq) {
        // initialze priority queue with singleton trees
        MinPQ<Node> pq = new MinPQ<Node>();
        for (char i = 0; i < R; i++) {
            if (freq[i] > 0)
                pq.insert(new Node(i, freq[i], null, null));
        }
        // special case in case there is only one character with a nonzero frequency
        if (pq.size() == 1) {
            if (freq['\0'] == 0) pq.insert(new Node('\0', 0, null, null));
            else { pq.insert(new Node('\1', 0, null, null)); };
        }

        // merge two smallest trees
        while (pq.size() > 1) {
            Node left  = pq.delMin();
            Node right = pq.delMin();
            Node parent = new Node('\0', left.freq + right.freq, left, right);
            pq.insert(parent);
        }
        return pq.delMin();
    }

    /**
     * Write bitstring-encoded trie to standard output
     * @param x the root Node
     */
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            binaryOut.write(true);
            binaryOut.write(x.ch, 8);
            return;
        }
        binaryOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    /**
     * Make a lookup table from symbols and their encodings
     * @param st an array of strings
     * @param x a Node
     * @param s a String
     */
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    /**
     * Read the bitstring-encoded trie
     * @return a Node
     */
    private static Node readTrie() {
        boolean isLeaf = binaryIn.readBoolean();
        if (isLeaf) {
            return new Node(binaryIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" and {@code decompress()} if it is "decompress".
     * With error checking printing out the correct usage if the user enters incorrect arguments to the program
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        if(args.length != 3 || !(args[0].equals("compress") || args[0].equals("decompress"))) {
            StdOut.println("Error, incorrect usage.\nMake sure you're in the source directory when running the huffman code.\n" +
                    "Compilation: javac Assignment/HuffmanAlgorithm.java\n" +
                    "Compression Execution: java Assignment/HuffmanAlgorithm compress Assignment/inputFile Assignment/outputFile\n" +
                    "Decompress Execution: java Assignment/HuffmanAlgorithm decompress Assignment/inputFile Assignment/outputFile");
        }
        Stopwatch timer = new Stopwatch();
        binaryIn = new BinaryIn(args[1]);
        binaryOut = new BinaryOut(args[2]);
        if(args[0].equals("compress")) {
            compress();
            StdOut.println("elapsed time = " + timer.elapsedTime());
            StdOut.println("Original file = " + args[1] + "\nCompressed file = " + args[2]);
        }
        else if(args[0].equals("decompress")) {
            decompress();
            StdOut.println("elapsed time = " + timer.elapsedTime());
            StdOut.println("Compressed file = " + args[1] + "\nDecompressed file = " + args[2]);
        }
    }
}
