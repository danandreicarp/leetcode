package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SquaresOfASortedArrayTest {

    private final SquaresOfASortedArray app = new SquaresOfASortedArray();

    @Test
    void testCase1() {
        int[] output = app.sortedSquares(new int[]{-4, -1, 0, 3, 10});
        assertEquals(5, output.length);
        assertEquals(0, output[0]);
        assertEquals(1, output[1]);
        assertEquals(9, output[2]);
        assertEquals(16, output[3]);
        assertEquals(100, output[4]);
    }

    @Test
    void testCase2() {
        int[] output = app.sortedSquares(new int[]{-7, -3, 2, 3, 11});
        assertEquals(5, output.length);
        assertEquals(4, output[0]);
        assertEquals(9, output[1]);
        assertEquals(9, output[2]);
        assertEquals(49, output[3]);
        assertEquals(121, output[4]);
    }
}