package com.danandreicarp;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        if (root == null) return false;
        if (root.left == null) {
            if (root.right == null) {
                return true;
            } else {
                return isValidRight(root);
            }
        } else {
            if (root.right == null) {
                return isValidLeft(root);
            } else {
                return hasValidChildren(root) &&
                        checkRightSubtree(root.right, root.val) &&
                        checkLeftSubtree(root.left, root.val);
            }
        }
    }

    private boolean checkRightSubtree(TreeNode root, int min) {
        if (root.left == null) {
            if (root.right == null) {
                return true;
            } else {
                return isValidRight(root);
            }
        } else {
            if (root.right == null) {
                return isValidLeft(root, min);
            } else {
                return hasValidChildren(root) &&
                        checkRightSubtree(root.right, root.val) &&
                        checkSubtree(root.left, min, root.val) &&
                        root.left.val > min;
            }
        }
    }

    private boolean checkLeftSubtree(TreeNode root, int max) {
        if (root.left == null) {
            if (root.right == null) {
                return true;
            } else {
                return isValidRight(root, max);
            }
        } else {
            if (root.right == null) {
                return isValidLeft(root);
            } else {
                return hasValidChildren(root) &&
                        checkSubtree(root.right, root.val, max) &&
                        checkLeftSubtree(root.left, root.val) &&
                        root.right.val < max;
            }
        }
    }

    private boolean checkSubtree(TreeNode root, int min, int max) {
        if (root.left == null) {
            if (root.right == null) {
                return true;
            } else {
                return isValidRight(root, max);
            }
        } else {
            if (root.right == null) {
                return isValidLeft(root, min);
            } else {
                return hasValidChildren(root) &&
                        checkSubtree(root.right, root.val, max) &&
                        checkSubtree(root.left, min, root.val) &&
                        root.right.val < max &&
                        root.left.val > min;
            }
        }
    }

    private boolean isValidRight(TreeNode root) {
        return root.right.val > root.val &&
                checkRightSubtree(root.right, root.val);
    }

    private boolean isValidLeft(TreeNode root) {
        return root.left.val < root.val &&
                checkLeftSubtree(root.left, root.val);
    }

    private boolean hasValidChildren(TreeNode root) {
        return root.right.val > root.val &&
                root.left.val < root.val;
    }

    private boolean isValidRight(TreeNode root, int max) {
        return root.right.val > root.val &&
                root.right.val < max &&
                checkSubtree(root.right, root.val, max);
    }

    private boolean isValidLeft(TreeNode root, int min) {
        return root.left.val < root.val &&
                root.left.val > min &&
                checkSubtree(root.left, min, root.val);
    }

    public static void main(String[] args) {
        ValidateBinarySearchTree app = new ValidateBinarySearchTree();

        TreeNode root = new TreeNode(5,
                new TreeNode(4),
                new TreeNode(6, new TreeNode(3), new TreeNode(7)));
        System.out.println(app.isValidBST(root));

        root = new TreeNode(0,
                null,
                new TreeNode(1));
        System.out.println(app.isValidBST(root));

        root = new TreeNode(1,
                null,
                new TreeNode(1));
        System.out.println(app.isValidBST(root));

        root = new TreeNode(20,
                new TreeNode(10,
                        new TreeNode(5,
                                new TreeNode(2,
                                        new TreeNode(1),
                                        new TreeNode(3)),
                                new TreeNode(7,
                                        new TreeNode(6),
                                        new TreeNode(8))),
                        new TreeNode(15,
                                new TreeNode(12,
                                        new TreeNode(11),
                                        new TreeNode(13)),
                                new TreeNode(18,
                                        new TreeNode(17),
                                        new TreeNode(19)))),
                new TreeNode(40,
                        new TreeNode(30,
                                new TreeNode(22,
                                        new TreeNode(21),
                                        new TreeNode(23)),
                                new TreeNode(32,
                                        new TreeNode(31),
                                        new TreeNode(33))),
                        new TreeNode(80,
                                new TreeNode(50,
                                        new TreeNode(41),
                                        new TreeNode(51)),
                                new TreeNode(90,
                                        new TreeNode(85),
                                        new TreeNode(91)))));
        System.out.println(app.isValidBST(root));
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
