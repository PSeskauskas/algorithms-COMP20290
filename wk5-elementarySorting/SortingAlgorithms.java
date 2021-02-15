import java.util.Arrays;
public class SortingAlgorithms {
    /* Selection sort finds the smallest value in the array and swaps it with the element at index 0
    * Then it finds the second smallest value and swaps it with the element at index 1
    * Then it finds the third smallest value and swaps it with the element at index 2 and so on
    * continuing until the array is sorted fully */
    public static int[] selectionSort(int[] array) {
        int min;
        int temp;
        for(int i = 0; i < array.length; i++) {
            min = i;
            for(int j = i + 1; j < array.length; j++) {
                if(array[min] > array[j]) {
                    min = j;
                }
            }
            temp = array[i];
            array[i] = array[min];
            array[min] = temp;
        }
        return array;
    }

    /* Insertion sort compares the current element i with the previous adjacent
    * elements in the array, these comparisons reveal that the element can be inserted
    * at a particular position prior to index i, once the comparisons are complete,
    * space is created for the element to be inserted in its new position by shifting
    * the other elements to the right by one index and then inserting the element in
    * its correct position. This is repeated until the array is fully sorted */
    public static int[] insertionSort(int[] array) {
        int N = array.length;
        for(int i = 0; i < N; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
                else {
                    break;
                }
            }
        }
        return array;
    }

    /* Stalin sort searches an array, and if an element is not in the correct order, i.e. the current element is not
    * greater than the previous element, then that current element is removed from the array entirely */
    public static int[] stalinSort(int[] array) {
        int temp = array[0];
        int count = 1;
        for(int i = 1; i < array.length; i++) {
            if(temp < array[i]) {
                temp = array[i];
                count++;
            }
            else {
                array[i] = 0;
            }
        }
        int[] copy = new int[count];
        int x = 0;
        int y = 0;
        while(x < copy.length) {
            if(array[y] == 0) {
                y++;
            }
            else {
                copy[x] = array[y];
                y++;
                x++;
            }
        }
        return copy;
    }

    /* Main method */
    public static void main(String[] args) {
        /* Read in all of the integers in a given data file, and store them in array a, and then copy them into array
        * b and array c */
        In in = new In(args[0]);
        int[] a = in.readAllInts();
        int[] b = Arrays.copyOf(a, a.length);
        int[] c = Arrays.copyOf(a, a.length);

        /* Define a stopwatch for the selection sort, run selection sort on array a, and print the sorted array to the
        * command line and the elapsed time */
        Stopwatch timer = new Stopwatch();
        selectionSort(a);
        System.out.println(Arrays.toString(a));
        String formattedString = String.format("%.09f", timer.elapsedTime());
        StdOut.println("elapsed time = " + formattedString);

        /* Define a stopwatch for the insertion sort, run insertion sort on array b, and print the sorted array to the
        * command line and the elapsed time */
        Stopwatch timer2 = new Stopwatch();
        insertionSort(b);
        System.out.println(Arrays.toString(b));
        String formattedString2 = String.format("%.09f", timer2.elapsedTime());
        StdOut.println("elapsed time = " + formattedString2);

        /* Define a stopwatch for the Stalin sort, run stalin sort on array c, and print the sorted array to the
        * command line and the elapsed time */
        Stopwatch timer3 = new Stopwatch();
        System.out.println(Arrays.toString(stalinSort(c)));
        String formattedString3 = String.format("%.09f", timer3.elapsedTime());
        StdOut.println("elapsed time = " + formattedString3);
    }
}