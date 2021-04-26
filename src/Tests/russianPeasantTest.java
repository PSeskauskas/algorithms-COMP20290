package Tests;

import Practical2.russianPeasant;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class russianPeasantTest {
    @Test
    void testPositive() {
        assertEquals(230, russianPeasant.calculation(10, 23));
    }
    @Test
    void testLargeNumbers() {
        assertEquals(52728, russianPeasant.calculation(169, 312));
    }
}