package com.danandreicarp.number;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfStepsToReduceNumberToZeroTest {

    private final NumberOfStepsToReduceNumberToZero app = new NumberOfStepsToReduceNumberToZero();

    @Test
    void testCase1() {
        assertEquals(6, app.numberOfSteps(14));
    }

    @Test
    void testCase2() {
        assertEquals(4, app.numberOfSteps(8));
    }

    @Test
    void testCase3() {
        assertEquals(12, app.numberOfSteps(123));
    }
}