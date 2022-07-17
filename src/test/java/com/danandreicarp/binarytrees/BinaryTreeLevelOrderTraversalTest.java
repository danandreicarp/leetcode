package com.danandreicarp.binarytrees;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BinaryTreeLevelOrderTraversalTest {

    private final BinaryTreeLevelOrderTraversal app = new BinaryTreeLevelOrderTraversal();

    @Test
    void testLevelOrderIterNull() {
        List<Integer> result = app.levelOrderIter(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testLevelOrderIterSingle() {
        List<Integer> result = app.levelOrderIter(new TreeNode(3));
        assertEquals(1, result.size());
        assertEquals(3, result.get(0));
    }

    @Test
    void testLevelOrder() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Integer> result = app.levelOrderIter(root);
        assertEquals(5, result.size());
        assertEquals(3, result.get(0));
        assertEquals(9, result.get(1));
        assertEquals(20, result.get(2));
        assertEquals(15, result.get(3));
        assertEquals(7, result.get(4));
    }

    @Test
    void testLevelOrderRec() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<Integer> result = app.levelOrderRec(root);
        assertEquals(5, result.size());
        assertEquals(3, result.get(0));
        assertEquals(9, result.get(1));
        assertEquals(20, result.get(2));
        assertEquals(15, result.get(3));
        assertEquals(7, result.get(4));
    }

    @Test
    void testLevelOrderNull() {
        List<List<Integer>> result = app.levelOrder(null);
        assertTrue(result.isEmpty());
    }

    @Test
    void testLevelOrderSingle() {
        List<List<Integer>> result = app.levelOrder(new TreeNode(3));
        assertEquals(1, result.size());
        List<Integer> firstLevel = result.get(0);
        assertEquals(1, firstLevel.size());
        assertEquals(3, firstLevel.get(0));
    }

    @Test
    void testLevelOrderList() {
        TreeNode root = new TreeNode(3, new TreeNode(9), new TreeNode(20, new TreeNode(15), new TreeNode(7)));
        List<List<Integer>> result = app.levelOrder(root);
        assertEquals(3, result.size());

        List<Integer> firstLevel = result.get(0);
        assertEquals(1, firstLevel.size());
        assertEquals(3, firstLevel.get(0));

        List<Integer> secondLevel = result.get(1);
        assertEquals(2, secondLevel.size());
        assertEquals(9, secondLevel.get(0));
        assertEquals(20, secondLevel.get(1));

        List<Integer> thirdLevel = result.get(2);
        assertEquals(2, thirdLevel.size());
        assertEquals(15, thirdLevel.get(0));
        assertEquals(7, thirdLevel.get(1));
    }

    @Test
    void testLevelOrderList2() {
        TreeNode root = new TreeNode(3, 
                new TreeNode(9), 
                new TreeNode(20, 
                        new TreeNode(15, 
                                new TreeNode(13), 
                                new TreeNode(16)), 
                        new TreeNode(7,
                                new TreeNode(6),
                                new TreeNode(8))));
        List<List<Integer>> result = app.levelOrder(root);
        assertEquals(4, result.size());

        List<Integer> firstLevel = result.get(0);
        assertEquals(1, firstLevel.size());
        assertEquals(3, firstLevel.get(0));

        List<Integer> secondLevel = result.get(1);
        assertEquals(2, secondLevel.size());
        assertEquals(9, secondLevel.get(0));
        assertEquals(20, secondLevel.get(1));

        List<Integer> thirdLevel = result.get(2);
        assertEquals(2, thirdLevel.size());
        assertEquals(15, thirdLevel.get(0));
        assertEquals(7, thirdLevel.get(1));

        List<Integer> fourthLevel = result.get(3);
        assertEquals(4, fourthLevel.size());
        assertEquals(13, fourthLevel.get(0));
        assertEquals(16, fourthLevel.get(1));
        assertEquals(6, fourthLevel.get(2));
        assertEquals(8, fourthLevel.get(3));
    }
    
}