package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindNumbersWithEvenNumberOfDigitsTest {

    private final FindNumbersWithEvenNumberOfDigits app = new FindNumbersWithEvenNumberOfDigits();

    @Test
    void testCase1() {
        assertEquals(2, app.findNumbers(new int[]{12, 345, 2, 6, 7896}));
    }

    @Test
    void testCase2() {
        assertEquals(1, app.findNumbers(new int[]{555, 901, 482, 1771}));
    }

    @Test
    void testCase3() {
        assertEquals(3, app.findNumbers(new int[]{2, 20, 200, 2000, 20_000, 200_000}));
    }
}