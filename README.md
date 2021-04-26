# COMP20290 - Algorithms - 2021
### Author: Patrikas Seskauskas

Java implementations of algorithms given in weekly practicals for COMP20290.
 <br> Practical questions are completed in the practical document given each week and saved as PDFs in the practicalAnswers folder.
 <br> I used Intellij as my IDEA and Microsoft Word/Google Sheets for answering questions and drawing graphs respectively.

## Getting Started
### Prerequisites
* Please install JDK 8 from Oracle [here](https://www.oracle.com/java/technologies/javase/javase-jdk8-downloads.html), 
as I used JDK 8 for the entirety of this module.
* [IntelliJ IDEA](https://www.jetbrains.com/idea/) was my IDEA of choice for this module.

### Build and Run
Clone the repository into your IDE.
 <br> Every algorithm was separated into separate classes.
 <br> Subsequently, each class is in its corresponding package depending on which practical the algorithm was introduced.
 <br> Therefore, each algorithm can be built and run separately.

### Util package 
The [Util](src/Util) package in [src](./src) contains all helper classes needed to run each algorithm, i.e., reading in standard input, generating a random array of size N, stopwatch etc.

### Data package
The [data](./data) package contains all the different size int files that can be used to test certain algorithms. The file sizes range from 8 ints - 16k ints.

## Algorithms
Summary of the algorithms implemented in the [src](./src) directory.
 <br> Along with links to the practical documents containing the questions and answers for each practical. 
 <br> **NOTE:** The algorithms listed below have been designed to work for specific input types. Some of them take in a file from the data package. Others a randomly generated array of size n or just n for the towers of Hanoi implementation.

| Code Package | Topic + Link to PDF | File Name | Summary |  
|---| ----- | ---- | ----------- |
| [Practical1](./src/Practical1) | [Empirical Analysis](./practicalAnswers/Practical1-EmpiricalAnalysis.pdf) | [ThreeSumA](./src/Practical1/ThreeSumA.java) | Brute force algorithm to count the number of triples in a file, summing to 0. <br> Time Complexity = O(n<sup>3</sup>)
| | | [ThreeSumB](./src/Practical1/ThreeSumB.java) | Binary search algorithm to count the number of triples in a file, summing to 0. <br> Time Complexity = O(n<sup>2</sup> log n)
| [Practical2](./src/Practical2) | [Complexity Analysis](./practicalAnswers/Practical2-ComplexityAnalysis.pdf) | [russianPeasant](./src/Practical2/russianPeasant.java) | Implementation of the Russian Peasant algorithm to multiply two numbers. <br> The Russian Peasant algorithm uses doubling, halving and addition to get the final result. The smaller number is halved, and the larger number is doubled until the smaller number reaches 1. Then, add all of the larger numbers values for when the value of the smaller number was odd. <br> Time Complexity = O(log n)
| [Practical3](./src/Practical3) | [Recursion](./practicalAnswers/Practical3-Recursion.pdf) | [fibonacciIterative](./src/Practical3/fibonacciIterative.java) | Iterative implementation of the Fibonacci algorithm. <br> The iterative implementation loops from 2 to n, adding the previous two values of the sequence and updating the variables accordingly. <br> Time Complexity = O(n)
| | | [fibonacciRecursive](./src/Practical3/fibonacciRecursive.java) | Recursive implementation of the Fibonacci algorithm. <br> The recursive implementation calls the method again recursively, passing in n-1 and n-2 in two recursive calls. For each recursive call, another two method calls are created. So, the number of method calls grows exponentially. <br> Time Complexity = O(2<sup>n</sup>)
| | | [towersOfHanoi](./src/Practical3/towersOfHanoi.java) | Solves the [Towers of Hanoi](https://en.wikipedia.org/wiki/Tower_of_Hanoi) problem recursively, outputting the steps needed to move all disks from the source to the destination for n disks. <br> Time Complexity = O(2<sup>n</sup>)
| [Practical4](./src/Practical4) | [Elementary Sorting](./practicalAnswers/Practical4-ElementarySorting.pdf) | [insertionSort](./src/Practical4/insertionSort.java) | Implementation of the insertion sort algorithm. <br> Insertion sort compares the current element with the previous adjacent elements in the array, these comparisons reveal that the element can be inserted at a particular position prior to the current index, once the comparisons are complete, space is created for the element to be inserted in its new position by shifting the other elements to the right by one index and then inserting the element in its correct position. This is repeated until the array is fully sorted <br> Time Complexity = O(n<sup>2</sup>)
| | | [selectionSort](./src/Practical4/selectionSort.java) | Implementation of the selection sort algorithm. <br> Selection sort finds the smallest value in the array and swaps it with the element at index 0. <br> Then it finds the second smallest value and swaps it with the element at index 1. <br> Then it finds the third smallest value and swaps it with the element at index 2 and so on continuing until the array is fully sorted. <br> Time Complexity = O(n<sup>2</sup>)
| | | [stalinSort](./src/Practical4/stalinSort.java) | Implementation of the stalin sort algorithm. <br> Stalin sort searches an array, and if an element is not in the correct order, i.e. the current element is not greater than the previous element, then that current element is removed from the array entirely <br> Time Complexity = O(1)
| [Practical5](./src/Practical5) | [Efficient Sorting](./practicalAnswers/Practical5-EfficientSorting.pdf) | [mergeSort](./src/Practical5/mergeSort.java) | Implementation of the merge sort algorithm. <br> Merge Sort takes in an array containing elements and an auxiliary array, the array is split in half and each half is sorted recursively, once both halves are sorted, the auxiliary array contains both sorted halves. <br> Then, the two sorted halves of the auxiliary array are merged together into the original array, the output being the original array in sorted order. <br> Time Complexity = O(n log n)
| | | [mergeSortEnhanced](./src/Practical5/mergeSortEnhanced.java) | Implementation of the enhanced merge sort algorithm. <br> The enhanced version of merge sort uses insertion sort for small subarrays, e.g., size 10 in my implementation. <br> As well as that, the enhanced version stops the sort if part of the array is already sorted, reducing the runtime by approximately 10-15%. <br> Time Complexity = O(n log n)
| [Practical6](./src/Practical6) | [Quick Sort](./practicalAnswers/Practical6-QuickSort.pdf) | [quickSort](./src/Practical6/quickSort.java) | Implementation of the quick sort algorithm. <br> Quick sort takes in an array, a pivot is selected, and the array is partitioned, every element less than the pivot will be before the pivot and every element greater than the pivot will be after the pivot in the array. <br> Then, each half of the array, before and after the pivot, are sorted. <br> Time Complexity = O(n log n)
| | | [quickSortEnhanced](./src/Practical6/quickSortEnhanced.java) | Implementation of the enhanced quick sort algorithm. <br> The enhanced quick sort uses insertion sort for small subarrays, e.g., size 10 in my implementation. <br> As well as that, the pivot is the median of a sample of 3 random elements in the array. <br> Time Complexity = O(n log n)
| [Practical7](./src/Practical7) | [Substring Search](./practicalAnswers/Practical7-SubstringSearch.pdf) | [bruteForceSearch](./src/Practical7/bruteForceSearch.java) | The brute-force search algorithm starts at the beginning of the string and compares each character from the pattern against subsequent characters in the string. <br> Once the algorithm finishes checking the first pattern then increment the pointer to the next character in the string and start the process again. <br> The algorithm stops at the first occurrence of the pattern. <br> Time Complexity = O(m * n)
| | | [knuthMorrisPrattSearch](./src/Practical7/knuthMorrisPrattSearch.java) | The KMP search algorithm improves on the brute-force algorithm by having prior information about the text being searched. <br> If the first x characters have been matched and then a mismatch is found, the algorithm doesn't have to move to the next character in the search string. <br> The algorithm can skip some iterations for where no match is possible and it can skip some iterations in the inner loop. <br> Time Complexity = O(n)
| [Practical8](./src/Practical8) | [Tries](./practicalAnswers/Practical8-Tries.pdf) | [Trie](./src/Practical8/Trie.java) | Java implementation of a Trie. <br> A trie is a tree in which each node has many children, The value at each node consists of a character, and a boolean to display if a character is the end of a word or not. <br> The search algorithm goes through the children of the trie, and iterates through the string and checks each character with the nodes of the trie. <br> If the character isn't a part of a sub-trie, then return false, if the end of the string is reached, the trie contains the string, therefore, return true. <br> Time Complexity = O(n)
