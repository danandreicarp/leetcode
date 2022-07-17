package com.danandreicarp.binarytrees;

import java.util.*;

/**
 * Left, Root, Right
 */
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nodes = new ArrayList<>();

        while (root != null || !stack.isEmpty()) {
            if (root != null) {
                stack.add(root);
                root = root.left;
            } else {
                root = stack.pop();
                nodes.add(root.val);
                root = root.right;
            }
        }

        return nodes;
    }

    public List<Integer> inorderTraversalRec(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        return inorderRec(root, nodes);
    }

    private List<Integer> inorderRec(TreeNode root, List<Integer> nodes) {
        if (root == null) {
            return nodes;
        }

        if (root.left != null) inorderRec(root.left, nodes);
        nodes.add(root.val);
        if (root.right != null) inorderRec(root.right, nodes);

        return nodes;
    }
}
