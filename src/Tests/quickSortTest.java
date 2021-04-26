package Tests;

import Practical6.quickSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class quickSortTest {
    @Test
    void testSort() {
        int[] array = {5, 3, 8, 9, 1, 2, 7, 6, 4, 0};
        quickSort.sort(array, 0, array.length - 1);
        assertEquals("[0, 1, 2, 3, 4, 5, 6, 7, 8, 9]", Arrays.toString(array));
    }
}