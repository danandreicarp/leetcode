package com.danandreicarp.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Root, Left, Right
 */
public class BinaryTreePreorderTraversal {

    public List<Integer> preorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> nodes = new ArrayList<>();

        stack.add(root);
        while(!stack.isEmpty()) {
            root = stack.pop();
            nodes.add(root.val);
            if (root.right != null) stack.add(root.right);
            if (root.left != null) stack.add(root.left);
        }

        return nodes;
    }

    public List<Integer> preorderTraversalRec(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        return preorderTraversalRec(root, nodes);
    }

    private List<Integer> preorderTraversalRec(TreeNode node, List<Integer> nodes) {
        if (node == null) return nodes;

        nodes.add(node.val);
        if (node.left != null) preorderTraversalRec(node.left, nodes);
        if (node.right != null) preorderTraversalRec(node.right, nodes);

        return nodes;
    }
}
