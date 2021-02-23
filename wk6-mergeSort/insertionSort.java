import java.util.Arrays;
public class insertionSort {
    /* Insertion sort compares the current element i with the previous adjacent
     * elements in the array, these comparisons reveal that the element can be inserted
     * at a particular position prior to index i, once the comparisons are complete,
     * space is created for the element to be inserted in its new position by shifting
     * the other elements to the right by one index and then inserting the element in
     * its correct position. This is repeated until the array is fully sorted */
    public static void insertionSort(int[] array, int lo, int hi) {
        for (int i = 0; i <= hi; i++) {
            for (int j = i; j > lo; j--) {
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] array = generateRandomArray.generateArray(100000);
        int[] aux = new int[array.length];
        Stopwatch timer = new Stopwatch();
        insertionSort(array,0, array.length - 1);
        System.out.println(Arrays.toString(array));
        System.out.println("elapsed time = " + timer.elapsedTime());
    }
}