import java.util.*;
public class generateRandomArray {
    public static int[] generateArray(int n) {
        int[] array = new int[n];
        Random rand = new Random();
        for(int i = 0; i < n; i++) {
            array[i] = rand.nextInt(n) + 1;
        }
        return array;
    }
}