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

    @Test
    void testCase3() {
        int[] arr = new int[] {0,0,0,0,0,0,0};
        app.duplicateZeros(arr);

        assertEquals(7, arr.length);
        assertEquals(0, arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(0, arr[2]);
        assertEquals(0, arr[3]);
        assertEquals(0, arr[4]);
        assertEquals(0, arr[5]);
        assertEquals(0, arr[6]);
    }

    @Test
    void testCase4() {
        int[] arr = new int[] {8,4,5,0,0,0,0,7};
        app.duplicateZeros(arr);

        assertEquals(8, arr.length);
        assertEquals(8, arr[0]);
        assertEquals(4, arr[1]);
        assertEquals(5, arr[2]);
        assertEquals(0, arr[3]);
        assertEquals(0, arr[4]);
        assertEquals(0, arr[5]);
        assertEquals(0, arr[6]);
        assertEquals(0, arr[7]);
    }

    @Test
    void testCase5() {
        int[] arr = new int[] {9,0,0,3,0,0,0};
        app.duplicateZeros(arr);

        assertEquals(7, arr.length);
        assertEquals(9, arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(0, arr[2]);
        assertEquals(0, arr[3]);
        assertEquals(0, arr[4]);
        assertEquals(3, arr[5]);
    }

    @Test
    void testCase6() {
        int[] arr = new int[] {9,0,9,0,6,0,0,0,1};
        app.duplicateZeros(arr);

        assertEquals(9, arr.length);
        assertEquals(9, arr[0]);
        assertEquals(0, arr[1]);
        assertEquals(0, arr[2]);
        assertEquals(9, arr[3]);
        assertEquals(0, arr[4]);
        assertEquals(0, arr[5]);
        assertEquals(6, arr[6]);
    }
}