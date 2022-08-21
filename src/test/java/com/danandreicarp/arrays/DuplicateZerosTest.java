package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DuplicateZerosTest {

    private final DuplicateZeros app = new DuplicateZeros();

    @Test
    void testCase1() {
        int[] arr = new int[] {1,0,2,3,0,4,5,0};
        app.duplicateZeros(arr);

        assertEquals(8, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(0, arr[2]);
        assertEquals(2, arr[3]);
        assertEquals(3, arr[4]);
        assertEquals(0, arr[5]);
        assertEquals(0, arr[6]);
        assertEquals(4, arr[7]);
    }

    @Test
    void testCase2() {
        int[] arr = new int[] {1,2,3};
        app.duplicateZeros(arr);

        assertEquals(3, arr.length);
        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
    }

}