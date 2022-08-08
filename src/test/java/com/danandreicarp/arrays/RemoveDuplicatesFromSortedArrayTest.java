package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveDuplicatesFromSortedArrayTest {

    private final RemoveDuplicatesFromSortedArray app = new RemoveDuplicatesFromSortedArray();

    @Test
    void testCase1() {
        int result = app.removeDuplicates(new int[]{1, 1, 2});
        assertEquals(2, result);
    }

    @Test
    void testCase2() {
        int result = app.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});
        assertEquals(5, result);
    }

    @Test
    void testCase3() {
        int result = app.removeDuplicates(new int[]{0, 1, 1, 2, 2, 2, 3, 3, 4, 5, 6});
        assertEquals(7, result);
    }
}