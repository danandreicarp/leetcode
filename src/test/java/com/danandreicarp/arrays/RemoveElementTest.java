package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RemoveElementTest {

    private final RemoveElement app = new RemoveElement();

    @Test
    void testCase1() {
        int result = app.removeElement(new int[0], 3);
        assertEquals(0, result);
    }

    @Test
    void testCase2() {
        int result = app.removeElement(new int[]{3}, 3);
        assertEquals(0, result);
    }

    @Test
    void testCase3() {
        int result = app.removeElement(new int[]{3, 2, 2, 3}, 3);
        assertEquals(2, result);
    }

    @Test
    void testCase4() {
        int result = app.removeElement(new int[]{0, 1, 2, 2, 3, 0, 4, 2}, 2);
        assertEquals(5, result);
    }

    @Test
    void testCase5() {
        int result = app.removeElement(new int[]{2}, 3);
        assertEquals(1, result);
    }

    @Test
    void testCase6() {
        int result = app.removeElement(new int[]{3, 3}, 3);
        assertEquals(0, result);
    }

    @Test
    void testCase7() {
        int result = app.removeElement(new int[]{3, 3}, 5);
        assertEquals(2, result);
    }

    @Test
    void testCase8() {
        int result = app.removeElement(new int[]{4, 5}, 4);
        assertEquals(1, result);
    }

    @Test
    void testCase9() {
        int result = app.removeElement(new int[]{1, 2, 3, 4}, 1);
        assertEquals(3, result);
    }
}