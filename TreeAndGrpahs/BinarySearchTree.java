package TreesAndGraphs;

import static TreesAndGraphs.BinaryTreeNode.inOrderTraversal;

public class BinarySearchTree {

    public static BinaryTreeNode buildBST (int[] arr) {
        if (arr.length < 1)
            return null;
        int n = arr.length - 1;
        return buildBSTUtil (arr, 0, n);
    }

    public static BinaryTreeNode buildBSTUtil(int[] arr, int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        System.out.println("mid: " + mid);

        BinaryTreeNode root = new BinaryTreeNode(arr[mid]);

        root.left = buildBSTUtil(arr, start, mid - 1);
        root.right = buildBSTUtil(arr, mid + 1, end);

        return root;
    }



    public static void main (String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        BinaryTreeNode root = buildBST(arr);

//        preOrderTraversal(root);
        inOrderTraversal(root);
    }

}
