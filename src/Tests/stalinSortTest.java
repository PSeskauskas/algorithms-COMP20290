package Tests;

import Practical4.stalinSort;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class stalinSortTest {
    @Test
    void testSort() {
        int[] array = {5, 3, 8, 9, 1, 2, 7, 6, 4, 0};
        int[] newArray = stalinSort.sort(array);
        assertEquals("[5, 8, 9]", Arrays.toString(newArray));
    }
}