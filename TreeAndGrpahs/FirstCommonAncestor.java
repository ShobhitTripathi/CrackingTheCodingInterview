package TreesAndGraphs;

import java.util.ArrayList;
import java.util.List;

public class FirstCommonAncestor {

    //Method 2 (using single traversal)
    public static BinaryTreeNode firstCommonAncestor(BinaryTreeNode root, BinaryTreeNode a, BinaryTreeNode b) {
        //base case
        if (root == null)
            return null;

        // If either n1 or n2 matches with root's key, report
        // the presence by returning root (Note that if a key is
        // ancestor of other, then the ancestor key becomes LCA
        if (root == a ||  root == b)
            return root;

        // Look for keys in left and right subtrees
        BinaryTreeNode leftLCA = firstCommonAncestor(root.left, a, b);
        BinaryTreeNode rightLCA = firstCommonAncestor(root.right, a, b);

        // If both of the above calls return Non-NULL, then one key
        // is present in one subtree and other is present in other,
        // So this node is the LCA
        if (leftLCA != null && rightLCA != null)
            return root;

        // Otherwise check if left subtree or right subtree is LCA
        return leftLCA != null ? leftLCA : rightLCA;
    }

    //Method 1 (By Storing root to n1 and root to n2 paths)
    public static int getFirstCommonAncestor(BinaryTreeNode root, int a, int b) {
        int res = -1;
        BinaryTreeNode node = null;
        List<Integer> path1 = new ArrayList<>();
        getPath(root, a, path1);
        System.out.println("Path from root to " + a + " is : " + path1.toString());
        List<Integer> path2 = new ArrayList<>();
        getPath(root, b, path2);
        System.out.println("Path from root to " + b + " is : " + path2.toString());

        int index;
        for (index = 0;index < path1.size() && index < path2.size();index++) {
            if (path1.get(index) != path2.get(index)) {
                break;
            }
        }
        res = path1.get(index - 1);
        return res;
    }

    public static boolean getPath(BinaryTreeNode root, int n,  List<Integer> path) {
        //base case
        if (root == null) {
            return false;
        }
        path.add(root.val);

        if (root.val == n) {
            return true;
        }

        if (root.left != null && getPath(root.left, n, path)) {
            return true;
        }
        if (root.right != null && getPath(root.right, n, path)) {
            return true;
        }
        // If not present in subtree rooted with root, remove root from
        // path[] and return false
        path.remove(path.size() - 1);
        return false;
    }

    public static void main (String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(8);
        root.left = new BinaryTreeNode(4);
        root.left.left = new BinaryTreeNode(2);
        root.left.right = new BinaryTreeNode(7);
        root.left.left.left = new BinaryTreeNode(1);
        root.left.left.right = new BinaryTreeNode(3);
        root.left.right.left = new BinaryTreeNode(5);

        root.right = new BinaryTreeNode(14);
        root.right.left = new BinaryTreeNode(10);
        root.right.right = new BinaryTreeNode(16);
        root.right.left.left = new BinaryTreeNode(9);
        root.right.right.right = new BinaryTreeNode(18);

        TreeOperation to = new TreeOperation();
        to.show(root);

        BinaryTreeNode firstNode = root.left;
        BinaryTreeNode secondNode = root.left.left;
        System.out.println("FirstNode : " + firstNode.val + " SecondNode : " + secondNode.val);

        //method 1: getting path list from root to node
        int first_common_ancestor = getFirstCommonAncestor(root, firstNode.val, secondNode.val);
        System.out.println("common ancestor is : " + first_common_ancestor);

        //method 2 : using single traversal
        BinaryTreeNode res = firstCommonAncestor(root, firstNode,secondNode);
        System.out.println("firstCommonAncestor(single traversal) : " + res.val);
    }
}
