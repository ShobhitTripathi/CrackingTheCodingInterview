package TreesAndGraphs;

public class CheckBalanced {

    public static boolean isBalanced(BinaryTreeNode root) {
        if (root == null)
            return true;
        if (Math.abs(height(root.left) - height(root.right)) <= 1)
            return (isBalanced(root.left) && isBalanced(root.right));
        return false;
    }

    public static int height(BinaryTreeNode root) {
        if (root == null)
            return 0;
        int left = height(root.left);
        int right= height(root.right);
        return (Math.max(left, right) + 1);
    }

    public static void main(String args[])
    {
        BinaryTreeNode tree = new BinaryTreeNode(1);
        tree.left = new BinaryTreeNode(2);
        tree.right = new BinaryTreeNode(3);
        tree.left.left = new BinaryTreeNode(4);
        tree.left.right = new BinaryTreeNode(5);
        tree.right.left = new BinaryTreeNode(8);
        tree.right.right = new BinaryTreeNode(9);

        TreeOperation to = new TreeOperation();
        to.show(tree);

        if (isBalanced(tree))
            System.out.println("Tree is balanced");
        else
            System.out.println("Tree is not balanced");
    }


}
