package com.danandreicarp.binarytrees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            int[] nodes = new int[size];
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                nodes[i] = node.val;
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }

            nodeList.add(new ArrayList<>(size));
            for (int i = 0; i < size; i++) {
                nodeList.get(nodeList.size() - 1).add(nodes[i]);
            }
        }
        return nodeList;
    }

    public List<Integer> levelOrderIter(TreeNode root) {
        if (root == null) return Collections.emptyList();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<Integer> nodes = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            nodes.add(node.val);
            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return nodes;
    }

    public List<Integer> levelOrderRec(TreeNode root) {
        List<Integer> nodes = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        return levelOrderRec(queue, nodes);
    }

    private List<Integer> levelOrderRec(Queue<TreeNode> queue, List<Integer> nodes) {
        if (queue.isEmpty()) {
            return nodes;
        }

        TreeNode node = queue.poll();
        nodes.add(node.val);
        if (node.left != null) {
            queue.add(node.left);
        }
        if (node.right != null) {
            queue.add(node.right);
        }
        return levelOrderRec(queue, nodes);
    }


}
