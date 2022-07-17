package com.danandreicarp.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreePreorderTraversalTest {

    private final BinaryTreePreorderTraversal app = new BinaryTreePreorderTraversal();

    @Test
    void testPreorderRecNull() {
        List<Integer> nodes = app.preorderTraversalRec(null);
        assertTrue(nodes.isEmpty());
    }

    @Test
    void testPreorderRecSingle() {
        List<Integer> nodes = app.preorderTraversalRec(new TreeNode(1));
        assertEquals(1, nodes.size());
        assertEquals(1, nodes.get(0));
    }

    @Test
    void testPreorderRec1() {
        TreeNode root = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> nodes = app.preorderTraversalRec(root);

        assertEquals(3, nodes.size());
        assertEquals(1, nodes.get(0));
        assertEquals(2, nodes.get(1));
        assertEquals(3, nodes.get(2));
    }

    @Test
    void testPreorderNull() {
        List<Integer> nodes = app.preorderTraversal(null);
        assertTrue(nodes.isEmpty());
    }

    @Test
    void testPreorderSingle() {
        List<Integer> nodes = app.preorderTraversal(new TreeNode(1));
        assertEquals(1, nodes.size());
        assertEquals(1, nodes.get(0));
    }

    @Test
    void testInorderIter1() {
        TreeNode root = new TreeNode(8,
                new TreeNode(4,
                        new TreeNode(2,
                                new TreeNode(1),
                                new TreeNode(3)),
                        new TreeNode(6,
                                new TreeNode(5),
                                new TreeNode(7))),
                new TreeNode(10,
                        new TreeNode(9),
                        new TreeNode(11)));

        List<Integer> nodes = app.preorderTraversal(root);
        assertEquals(11, nodes.size());
        assertEquals(8, nodes.get(0));
        assertEquals(4, nodes.get(1));
        assertEquals(2, nodes.get(2));
        assertEquals(1, nodes.get(3));
        assertEquals(3, nodes.get(4));
        assertEquals(6, nodes.get(5));
        assertEquals(5, nodes.get(6));
        assertEquals(7, nodes.get(7));
        assertEquals(10, nodes.get(8));
        assertEquals(9, nodes.get(9));
        assertEquals(11, nodes.get(10));
    }
}