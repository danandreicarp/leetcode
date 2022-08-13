package com.danandreicarp.binarytrees;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

class InvertBinaryTreeTest {

    private final InvertBinaryTree app = new InvertBinaryTree();

    @Test
    void testCase1() {
        TreeNode root = new TreeNode(4,
                new TreeNode(2,
                        new TreeNode(1),
                        new TreeNode(3)),
                new TreeNode(7,
                        new TreeNode(6),
                        new TreeNode(9)));
        app.invertTree(root);
        assertEquals(7, root.left.val);
        assertEquals(2, root.right.val);
        assertEquals(9, root.left.left.val);
        assertEquals(6, root.left.right.val);
        assertEquals(1, root.right.right.val);
        assertEquals(3, root.right.left.val);
    }

    @Test
    void testCase2() {
        TreeNode root = new TreeNode(2, new TreeNode(1), new TreeNode(3));
        app.invertTree(root);
        assertEquals(1, root.right.val);
        assertEquals(3, root.left.val);
    }

    @Test
    void testCase3() {
        TreeNode result = app.invertTree(null);
        assertNull(result);
    }
}