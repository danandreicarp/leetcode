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

    @Test
    void testCase3() {
        int[] output = app.sortedSquares(new int[]{-7, -3, 4, 5, 11});
        assertEquals(5, output.length);
        assertEquals(9, output[0]);
        assertEquals(16, output[1]);
        assertEquals(25, output[2]);
        assertEquals(49, output[3]);
        assertEquals(121, output[4]);
    }

    @Test
    void testCase4() {
        int[] output = app.sortedSquares(new int[]{-10, -1, 0, 3, 4});
        assertEquals(5, output.length);
        assertEquals(0, output[0]);
        assertEquals(1, output[1]);
        assertEquals(9, output[2]);
        assertEquals(16, output[3]);
        assertEquals(100, output[4]);
    }

    @Test
    void testCase5() {
        int[] output = app.sortedSquares(new int[]{-4, -4, -3});
        assertEquals(3, output.length);
        assertEquals(9, output[0]);
        assertEquals(16, output[1]);
        assertEquals(16, output[2]);
    }

    @Test
    void testCase6() {
        int[] output = app.sortedSquares(new int[]{-5, 4, 4});
        assertEquals(3, output.length);
        assertEquals(16, output[0]);
        assertEquals(16, output[1]);
        assertEquals(25, output[2]);
    }

    @Test
    void testCase7() {
        int[] output = app.sortedSquares(new int[]{1, 3, 3});
        assertEquals(3, output.length);
        assertEquals(1, output[0]);
        assertEquals(9, output[1]);
        assertEquals(9, output[2]);
    }
}