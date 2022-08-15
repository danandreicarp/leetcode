package com.danandreicarp.linkedlist;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MiddleOfTheLinkedListTest {

    private final MiddleOfTheLinkedList app = new MiddleOfTheLinkedList();

    @Test
    void testCase1() {
        ListNode output = app.middleNode(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4, new ListNode(5))))));
        assertEquals(3, output.val);
    }

    @Test
    void testCase2() {
        ListNode output = app.middleNode(new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4,
                                        new ListNode(5, new ListNode(6)))))));
        assertEquals(4, output.val);
    }

    @Test
    void testCase3() {
        ListNode output = app.middleNode(new ListNode(1));
        assertEquals(1, output.val);
    }

    @Test
    void testCase4() {
        ListNode output = app.middleNode(new ListNode(1, new ListNode(2)));
        assertEquals(2, output.val);
    }
}