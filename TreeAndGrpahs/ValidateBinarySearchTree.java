package TreesAndGraphs;

import java.sql.SQLOutput;

public class ValidateBinarySearchTree {
    public static int prev = Integer.MIN_VALUE;
    public static boolean isBST(BinaryTreeNode root) {
        if (root == null)
            return true;
        if (!isBST(root.left))
            return false;
        if (prev > root.val)
            return false;
        prev = root.val;
        return isBST(root.right);
    }

    public static void main (String[] args) {
        /*    4
            2    7
          1  3  5  6
         */
        BinaryTreeNode root = new BinaryTreeNode(4);
        root.left = new BinaryTreeNode(2);
        root.left.left = new BinaryTreeNode(1);
        root.left.right = new BinaryTreeNode(3);
        root.right = new BinaryTreeNode(7);
        root.right.left = new BinaryTreeNode(5);
        root.right.right = new BinaryTreeNode(8);

        System.out.println("is Binary Search Tree: " + isBST(root));
        //Inorder traversal of binary tree gives sorted list
        BinaryTreeNode.inOrderTraversal(root);
        String s = "a";
        System.out.println(Integer.valueOf(s.charAt(0)));


    }
}
