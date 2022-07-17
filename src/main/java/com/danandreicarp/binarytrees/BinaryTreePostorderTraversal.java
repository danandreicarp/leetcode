package com.danandreicarp.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * Left, Right, Root
 */
public class BinaryTreePostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        if (root == null) {
            return Collections.emptyList();
        }

        Stack<TreeNode> stack = new Stack<>();
        Stack<Integer> outputStack = new Stack<>();

        stack.add(root);
        while (!stack.isEmpty()) {
            root = stack.pop();
            outputStack.add(root.val);

            if (root.left != null) stack.add(root.left);
            if (root.right != null) stack.add(root.right);
        }

        List<Integer> nodes = new ArrayList<>(outputStack.size());
        while (!outputStack.isEmpty()) {
            nodes.add(outputStack.pop());
        }
        return nodes;
    }

    public List<Integer> postorderTraversalRec(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        return postorderTraversalRec(root, nodes);
    }

    private List<Integer> postorderTraversalRec(TreeNode node, List<Integer> nodes) {
        if (node == null) return nodes;

        if (node.left != null) postorderTraversalRec(node.left, nodes);
        if (node.right != null) postorderTraversalRec(node.right, nodes);
        nodes.add(node.val);

        return nodes;
    }
}
