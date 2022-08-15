package com.danandreicarp.arrays;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RichestCustomerWealthTest {

    private final RichestCustomerWealth app = new RichestCustomerWealth();

    @Test
    void testCase1() {
        assertEquals(6, app.maximumWealth(new int[][]{{1, 2, 3}, {3, 2, 1}}));
    }

    @Test
    void testCase2() {
        assertEquals(10, app.maximumWealth(new int[][]{{1, 5}, {7, 3}, {3, 5}}));
    }

    @Test
    void testCase3() {
        assertEquals(17, app.maximumWealth(new int[][]{{2, 8, 7}, {7, 1, 3}, {1, 9, 5}}));
    }
}