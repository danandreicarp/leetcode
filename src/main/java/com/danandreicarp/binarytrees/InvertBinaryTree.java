package com.danandreicarp.binarytrees;

import java.util.LinkedList;
import java.util.Queue;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
//        invertTreeRec(root);
        invertTreeIter(root);
        return root;
    }

    private void invertTreeRec(TreeNode root) {
        if (root.left != null) {
            TreeNode temp = root.left;
            root.left = root.right;
            root.right = temp;
            invertTreeRec(root.right);
            if (root.left != null)
                invertTreeRec(root.left);
        } else if (root.right != null) {
            root.left = root.right;
            root.right = null;
            invertTreeRec(root.left);
        }
    }
    
    private void invertTreeIter(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                if (node.right != null) {
                    TreeNode temp = node.left;
                    node.left = node.right;
                    node.right = temp;
                    queue.add(node.left);
                    queue.add(node.right);
                } else {
                    node.right = node.left;
                    node.left = null;
                    queue.add(node.right);
                }
            } else {
                if (node.right != null) {
                    node.left = node.right;
                    node.right = null;
                    queue.add(node.left);
                }
            }
        }
    }
}
