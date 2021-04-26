package Tests;

import Practical3.fibonacciIterative;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class fibonacciRecursiveTest {
    @Test
    void testFibonacciLow() {
        assertEquals(8, fibonacciIterative.fibonacci(6));
    }
    @Test
    void testFibonacciHigh() {
        assertEquals(832040, fibonacciIterative.fibonacci(30));
    }
}