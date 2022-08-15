package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MaxConsecutiveOnesTest {

    private final MaxConsecutiveOnes app = new MaxConsecutiveOnes();

    @Test
    void testCase1() {
        assertEquals(3, app.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
    }

    @Test
    void testCase2() {
        assertEquals(2, app.findMaxConsecutiveOnes(new int[]{1, 0, 1, 1, 0, 1}));
    }

    @Test
    void testCase3() {
        assertEquals(1, app.findMaxConsecutiveOnes(new int[]{1}));
    }

    @Test
    void testCase4() {
        assertEquals(0, app.findMaxConsecutiveOnes(new int[]{0}));
    }
}