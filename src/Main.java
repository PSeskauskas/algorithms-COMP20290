import Util.StdIn;
import Util.StdOut;

public class Main {
    /**
     * Run the Main class printing my information and calling the display menu method and run menu method with the
     * user input for the options
     * @param args
     */
    public static void main(String[] args) {
        StdOut.print("|||| COMP20290 Repository by Patrikas Seskauskas - 19369726 ||||\n");
        displayMenu();
        runMenu(StdIn.readInt());
    }

    /**
     * displayMenu displays the options that the user can run to test out each algorithm or to exit the program entirely
     */
    public static void displayMenu() {
        StdOut.println("\nAvailable options for you to run are listed below\n" +
                "0. Exit the program\n" +
                "1. Three Sum - Find the number of triples that sum to 0 in an input data file\n" +
                "2. Russian Peasants - Russian Peasants algorithm implementation\n" +
                "3. Fibonacci - Iterative/Recursive implementation of the fibonacci sequence\n" +
                "4. Towers of Hanoi - Generate the steps required to solve the towers of hanoi problem for a given number of disks\n" +
                "5. Insertion Sort - Implementation of the insertion sort algorithm\n" +
                "6. Selection Sort - Implementation of the selection sort algorithm\n" +
                "7. Stalin Sort - Implementation of the stalin sort algorithm\n" +
                "8. Merge Sort - Implementation of the merge sort/enhanced merge sort algorithm\n" +
                "9. Quick Sort - Implementation of the quick sort/enhanced quick sort algorithm\n" +
                "10. Brute Force Search - Finding a given pattern in a string using brute force\n" +
                "11. Knuth-Morris-Pratt Search - Finding a given pattern in a string using the KMP search algorithm\n" +
                "12. Trie Search - Finding if a string is in a generated Trie\n" +
                "13. Run Length Encoding - Run Length encoding implementation for input files\n" +
                "14. Huffman Encoding - Java implementation of the Huffman encoding algorithm for input files\n");
    }

    /**
     * runMenu method takes in an integer option and either calls the subsequent algorithms main method or prints out
     * the instructions on how to run that algorithm from the terminal, afterwards, the menu is displayed again and the
     * runMenu method is called again with a new integer option until the user enters 0 to exit the program.
     * @param selected an Integer
     */
    public static void runMenu(int selected) {
        boolean finished = false;
        int pick = 0;
        switch(selected) {
            case 0:
                StdOut.print("Exiting now.\n");
                break;
            case 1:
                StdOut.println("Three Sum A/B requires the use of the terminal to run these classes due to them taking " +
                        "in input txt files.\nInput txt files are located in the data package outside of source.\nThese " +
                        "input files range from 8 ints - 16k ints.\nEach file is listed below\n8ints.txt, 1Kints.txt, " +
                        "2Kints.txt, 4Kints.txt, 8Kints.txt, 16Kints.txt\nTo compile either file. cd into the source " +
                        "directory and input\n$ javac Practical1/ThreeSumA.java or $ javac Practical1/ThreeSumB.java\n" +
                        "To run either class with one of the data files, input either of these commands as an example\n" +
                        "$ java Practical1/ThreeSumA ../data/2Kints.txt || $java Practical1/ThreeSumB ../data/4Kints.txt\n");
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 2:
                Practical2.russianPeasant.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 3:
                while(!finished) {
                    StdOut.print("Please select one of\n1. Fibonacci Iterative\n2. Fibonacci Recursive\n");
                    pick = StdIn.readInt();
                    if(pick == 1) {
                        Practical3.fibonacciIterative.main(null);
                        finished = true;
                    }
                    else if(pick == 2) {
                        Practical3.fibonacciRecursive.main(null);
                        finished = true;
                    }
                    else {
                        StdOut.print("Error, please select a valid option\n");
                    }
                }
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 4:
                Practical3.towersOfHanoi.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 5:
                Practical4.insertionSort.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 6:
                Practical4.selectionSort.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 7:
                Practical4.stalinSort.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 8:
                while(!finished) {
                    StdOut.print("Please select one of\n1. Merge Sort\n2. Merge Sort Enhanced\n");
                    pick = StdIn.readInt();
                    if(pick == 1) {
                        Practical5.mergeSort.main(null);
                        finished = true;
                    }
                    else if(pick == 2) {
                        Practical5.mergeSortEnhanced.main(null);
                        finished = true;
                    }
                }
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 9:
                while(!finished) {
                    StdOut.print("Please select one of\n1. Quick Sort\n2. Quick Sort Enhanced\n");
                    pick = StdIn.readInt();
                    if(pick == 1) {
                        Practical6.quickSort.main(null);
                        finished = true;
                    }
                    else if(pick == 2) {
                        Practical6.quickSortEnhanced.main(null);
                        finished = true;
                    }
                }
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 10:
                Practical7.bruteForceSearch.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 11:
                Practical7.knuthMorrisPrattSearch.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 12:
                Practical8.Trie.main(null);
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 13:
                while(!finished) {
                    StdOut.println("Please choose\n1. User Input\n2. Input files");
                    pick = StdIn.readInt();
                    if(pick == 1) {
                        Practical9.RunLengthEncoding.main(null);
                        finished = true;
                    }
                    else if(pick == 2) {
                        StdOut.println("To use input files on the RunLength class, the terminal will be required.\nInput " +
                                "files are contained in the same package as the class, files are listed below.\n" +
                                "4runs.bin, abra.txt, q32x48.bin, q64x96.bin\n" +
                                "To compile and run RunLength/BinaryDump on these files, cd into the source directory and run the commands below.\n" +
                                "Compile Binary Dump: $ javac util/BinaryDump.java\n" +
                                "Compile Run Length Encoding: $ javac Practical9/RunLengthEncoding.java\n" +
                                "Run Binary Dump on uncompressed file: $ java util/BinaryDump 40 < Practical9/4runs.bin\n" +
                                "Run Length Compression on file in place: $ java Practical9/RunLength - < Practical9/4runs.bin | java util/BinaryDump 8\n" +
                                "Run Length Compression to New File: $ java Practical9/RunLength - < Practical9/4runs.bin > Practical9/4runsrle.bin\n" +
                                "Run Binary Dump on compressed file: $ java util/BinaryDump 40 < Practical9/4runsrle.bin");
                        finished = true;
                    }
                }
                displayMenu();
                runMenu(StdIn.readInt());
                break;
            case 14:
                break;
            default:
                StdOut.print("Error, please select a valid option from the list below\n");
                displayMenu();
                runMenu(StdIn.readInt());
        }
    }
}
