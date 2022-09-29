package ru.nsu.vlomakin;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Different tests for heapsort algorithm.
 * 1)Simple test, nothing strange
 * 2)array with repetitive elements
 * 3)inverted array
 */
public class HeapsortTests {
    @Test
    public void testSimple() {
        int[] result = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] test = {3, 10, 7, 6, 9, 4, 1, 8, 2, 5};
        Heapsort.heapsort(test, 10);
        Assertions.assertArrayEquals(result, test);
    }

    @Test
    public void testRepetitiveNumbers() {
        int[] result = {1, 2, 3, 4, 5, 5, 5, 5, 5};
        int[] test = {3, 5, 4, 5, 1, 5, 5, 2, 5};
        Heapsort.heapsort(test, 9);
        Assertions.assertArrayEquals(result, test);
    }

    @Test
    public void testReverseArray() {
        int[] result = {1, 2, 3, 4, 5, 324, 5647, 3245678, 345678909};
        int[] test = {345678909, 3245678, 5647, 324, 5, 4, 3, 2, 1};
        Heapsort.heapsort(test, 9);
        Assertions.assertArrayEquals(result, test);
    }
}
