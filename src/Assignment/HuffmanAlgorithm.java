package Assignment;

/******************************************************************************
 *  Compilation:  javac Huffman.java
 *
 *  Compress or expand a binary input stream using the Huffman algorithm.
 *
 * Add instructions and documentation related to your Huffman algorithm here...
 *
 ******************************************************************************/

import Util.BinaryStdIn;
import Util.BinaryStdOut;
import Util.MinPQ;

/**
 *  Add in your information about each method etc. here
 *
 *
 *  @author Patrikas Seskauskas
 */

public class HuffmanAlgorithm {
    // alphabet size of extended ASCII
    private static final int R = 256;

    // Do not instantiate.
    private HuffmanAlgorithm() {}

    // Huffman trie node
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

        // is the node a leaf node?
        private boolean isLeaf() {
            assert ((left == null) && (right == null)) || ((left != null) && (right != null));
            return (left == null) && (right == null);
        }

        // compare, based on frequency
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
        char[] input = BinaryStdIn.readString().toCharArray();
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
        BinaryStdOut.write(input.length);
        // use Huffman code to encode input
        for(char c : input) {
            for(char code : codes[c].toCharArray()) {
                BinaryStdOut.write(code == '1');
            }
        }
        BinaryStdOut.close();
    }

    /**
     * Reads a sequence of bits that represents a Huffman-compressed message from
     * standard input; expands them; and writes the results to standard output.
     */
    public static void decompress() {
        // read in Huffman trie from input stream
        Node root = readTrie();
        // number of bytes to write
        int numberOfBytes = BinaryStdIn.readInt();
        // decode using the Huffman trie
        int i = 0;
        while(i < numberOfBytes) {
            Node node = root;
            while(!node.isLeaf()) {
                if(!BinaryStdIn.readBoolean()) {
                    node = node.left;
                } else {
                    node = node.right;
                }
            }
            BinaryStdOut.write(node.ch, 8);
            i++;
        }
        BinaryStdOut.close();
    }

    // build the Huffman trie given frequencies
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

    // write bitstring-encoded trie to standard output
    private static void writeTrie(Node x) {
        if (x.isLeaf()) {
            BinaryStdOut.write(true);
            BinaryStdOut.write(x.ch, 8);
            return;
        }
        BinaryStdOut.write(false);
        writeTrie(x.left);
        writeTrie(x.right);
    }

    // make a lookup table from symbols and their encodings
    private static void buildCode(String[] st, Node x, String s) {
        if (!x.isLeaf()) {
            buildCode(st, x.left,  s + '0');
            buildCode(st, x.right, s + '1');
        }
        else {
            st[x.ch] = s;
        }
    }

    private static Node readTrie() {
        boolean isLeaf = BinaryStdIn.readBoolean();
        if (isLeaf) {
            return new Node(BinaryStdIn.readChar(), -1, null, null);
        }
        else {
            return new Node('\0', -1, readTrie(), readTrie());
        }
    }

    /**
     * Sample client that calls {@code compress()} if the command-line
     * argument is "compress" an {@code decompress()} if it is "decompress".
     *
     * @param args the command-line arguments
     */
    public static void main(String[] args) {}
}
