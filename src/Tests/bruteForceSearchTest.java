package Tests;

import Practical7.bruteForceSearch;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class bruteForceSearchTest {
    @Test
    void testAbra() {
        String text = "ABRACADABRA";
        String pattern = "ABRA";
        assertEquals(0, bruteForceSearch.search(text, pattern));
    }
}