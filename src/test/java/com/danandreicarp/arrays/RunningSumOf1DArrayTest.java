package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RunningSumOf1DArrayTest {

    private final RunningSumOf1DArray app = new RunningSumOf1DArray();

    @Test
    void testCase1() {
        int[] result = app.runningSum(new int[]{1, 2, 3, 4});
        assertEquals(4, result.length);
        assertEquals(1, result[0]);
        assertEquals(3, result[1]);
        assertEquals(6, result[2]);
        assertEquals(10, result[3]);
    }

    @Test
    void testCase2() {
        int[] result = app.runningSum(new int[]{1, 1, 1, 1, 1});
        assertEquals(5, result.length);
        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
        assertEquals(4, result[3]);
        assertEquals(5, result[4]);
    }

    @Test
    void testCase3() {
        int[] result = app.runningSum(new int[]{3, 1, 2, 10, 1});
        assertEquals(5, result.length);
        assertEquals(3, result[0]);
        assertEquals(4, result[1]);
        assertEquals(6, result[2]);
        assertEquals(16, result[3]);
        assertEquals(17, result[4]);
    }
}