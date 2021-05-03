# COMP20290 - Algorithms - 2021
### Author: Patrikas Seskauskas - (19369726)

Java implementations of algorithms given in weekly practicals for COMP20290.

### Installation
* Please install JDK 8 from Oracle [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html), 
as I used JDK 8 for the entirety of this module.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) was my IDEA of choice for this module.

### Build and Run
Clone the repository into your IDE. Every algorithm was separated into separate classes. Each class is in its corresponding package depending on which practical the algorithm was introduced. Therefore, each algorithm can be built and run separately. Otherwise, [Main.java](./src/Main.java) can be run to give an overview of every algorithm implemented in my repository

### Util package 
The [Util](src/Util) package in [src](./src) contains all helper classes needed to run each algorithm, i.e., reading in standard input, generating a random array of size N, stopwatch etc.

### Data package
The [data](./data) package contains all the different size int files that can be used to test certain algorithms. The file sizes range from 8 ints - 16k ints.

### Graphs package 
The [graphs](./graphs) package contains all of the graph files that were used in displaying results from running the algorithms with the stopwatch.

### Practical Answers
The [practicalAnswers](./practicalAnswers) package contains all of the PDF files containing answers to practical questions and results obtained from running each algorithm with various inputs and pictures of graphs. 

### Tests
The [Tests](./src/Tests) package contains basic tests that I created to test each non-void algorithm that it was returning the correct output. 

## Algorithms
Table of the algorithms implemented in the [src](./src) directory.
 <br> **NOTE:** The algorithms listed below either take in user input/command line arguments.

| Code Package | Topic + Link to PDF | File Name | Summary |  
|---| ----- | ---- | ----------- |
| [Practical1](./src/Practical1) | [Empirical Analysis](./practicalAnswers/Practical1-EmpiricalAnalysis.pdf) | [ThreeSumA](./src/Practical1/ThreeSumA.java) | Brute force algorithm to count the number of triples in a file, summing to 0. <br> Time Complexity = O(n<sup>3</sup>)
| | | [ThreeSumB](./src/Practical1/ThreeSumB.java) | Binary search algorithm to count the number of triples in a file, summing to 0. <br> Time Complexity = O(n<sup>2</sup> log n)
| [Practical2](./src/Practical2) | [Complexity Analysis](./practicalAnswers/Practical2-ComplexityAnalysis.pdf) | [russianPeasant](./src/Practical2/russianPeasant.java) | Implementation of the Russian Peasant algorithm to multiply two numbers, using doubling, halving and addition to get the final result. <br> Time Complexity = O(log n)
| [Practical3](./src/Practical3) | [Recursion](./practicalAnswers/Practical3-Recursion.pdf) | [fibonacciIterative](./src/Practical3/fibonacciIterative.java) | Iterative implementation of the Fibonacci algorithm. The iterative implementation loops from 2 to n, adding the previous two values of the sequence to obtain the current one. <br> Time Complexity = O(n)
| | | [fibonacciRecursive](./src/Practical3/fibonacciRecursive.java) | Recursive implementation of the Fibonacci algorithm. The recursive implementation passes in n-1 and n-2, another two method calls are created with each recursive call. So, the number of method calls grows exponentially. <br> Time Complexity = O(2<sup>n</sup>)
| | | [towersOfHanoi](./src/Practical3/towersOfHanoi.java) | Solves the Towers of Hanoi problem recursively, outputting the steps needed to move all disks from the source to the destination for n disks. <br> Time Complexity = O(2<sup>n</sup>)
| [Practical4](./src/Practical4) | [Elementary Sorting](./practicalAnswers/Practical4-ElementarySorting.pdf) | [insertionSort](./src/Practical4/insertionSort.java) | Implementation of the insertion sort algorithm. Insertion sort compares the current element with the previous adjacent elements in the array and swaps accordingly. <br> Time Complexity = O(n<sup>2</sup>)
| | | [selectionSort](./src/Practical4/selectionSort.java) | Implementation of the selection sort algorithm. Selection sort finds the smallest value in the array and swaps it with the element at index 0. Then it finds the second smallest value and swaps it with the element at index 1, continuining until the final index is reached. <br> Time Complexity = O(n<sup>2</sup>)
| | | [stalinSort](./src/Practical4/stalinSort.java) | Implementation of the stalin sort algorithm. Stalin sort searches an array, and if an element is not greater than the previous element, then that current element is removed from the array entirely. <br> Time Complexity = O(1)
| [Practical5](./src/Practical5) | [Efficient Sorting](./practicalAnswers/Practical5-EfficientSorting.pdf) | [mergeSort](./src/Practical5/mergeSort.java) | Implementation of the merge sort algorithm. Merge Sort takes in an array containing elements and an auxiliary array, the array is split in half and each half is sorted recursively, then the merge procedure begins, merging each sorted half together leaving the original array in sorted order. <br> Time Complexity = O(n log n)
| | | [mergeSortEnhanced](./src/Practical5/mergeSortEnhanced.java) | Implementation of the enhanced merge sort algorithm. The enhanced version of merge sort uses insertion sort for small subarrays. As well as that, the enhanced version stops the sort if part of the array is already sorted, reducing the runtime by approximately 10-15%. <br> Time Complexity = O(n log n)
| [Practical6](./src/Practical6) | [Quick Sort](./practicalAnswers/Practical6-QuickSort.pdf) | [quickSort](./src/Practical6/quickSort.java) | Implementation of the quick sort algorithm. Quick sort takes in an array, a pivot is selected, and the array is partitioned, every element less than the pivot will be before the pivot and every element greater than the pivot will be after the pivot in the array. Then, each half of the array, before and after the pivot, are sorted. <br> Time Complexity = O(n log n)
| | | [quickSortEnhanced](./src/Practical6/quickSortEnhanced.java) | Implementation of the enhanced quick sort algorithm. The enhanced quick sort uses insertion sort for small subarrays. As well as that, the pivot is the median of a sample of 3 random elements in the array. <br> Time Complexity = O(n log n)
| [Practical7](./src/Practical7) | [Substring Search](./practicalAnswers/Practical7-SubstringSearch.pdf) | [bruteForceSearch](./src/Practical7/bruteForceSearch.java) | The brute-force search algorithm starts at the beginning of the string and compares each character from the pattern against the search string. Once the algorithm finishes checking the first pattern then increment the pointer to the next character in the string and start the process again. <br> Time Complexity = O(m * n)
| | | [knuthMorrisPrattSearch](./src/Practical7/knuthMorrisPrattSearch.java) | The KMP search algorithm improves on the brute-force algorithm by having prior information about the text being searched. If the first x characters have been matched and then a mismatch is found. The algorithm can skip some iterations for where no match is possible and it can skip some iterations in the inner loop. <br> Time Complexity = O(n)
| [Practical8](./src/Practical8) | [Tries](./practicalAnswers/Practical8-Tries.pdf) | [Trie](./src/Practical8/Trie.java) | Java implementation of a Trie. The search algorithm goes through the children of the trie, and iterates through the string and checks each character with the nodes of the trie. If the character isn't a part of a sub-trie, then return false, if the end of the string is reached, return true. <br> Time Complexity = O(n)
| [Practical9](./src/Practical9) | [Run Length Compression](./practicalAnswers/Practical9-RunLengthCompression.pdf) | [RunLength](./src/Practical9/RunLength.java) | Java implementation of Run Length Compression compression and decompression of binary input from standard input. <br> Time Complexity = O(n)
| | | [RunLengthEncoding](./src/Practical9/RunLengthEncoding.java) | Java implementation of Run Length Encoding, compressing a user input string to characters with character counts, i.e., user input of "aaaaabbbbbccccc" is compressed to "a5b5c5". <br> Time Complexity = O(n)
| [Assignment](./src/Assignment) | [Assignment Sheet](./src/Assignment/COMP20290-Assignment-2-Compression.pdf) | [Huffman Algorithm](./src/Assignment/HuffmanAlgorithm.java) | Java implementation of the Huffman compression/decompression algorithm using tries to obtain a lower number of bits for characters that occur most frequently. <br> Time Complexity = O(n log n)