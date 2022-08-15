package com.danandreicarp.linkedlist;

public class MiddleOfTheLinkedList {

    public ListNode middleNode(ListNode head) {
        ListNode middle = head;
        int size = 0;
        while (head.next != null) {
            if (size % 2 == 0) {
                middle = middle.next;
            }
            ++size;
            head = head.next;
        }

        return middle;
    }
}
