package TreesAndGraphs;

public class checkSubtree {
    //Method1 : check for the node and check from there if tree is same
    public static boolean containsTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t2 == null)
            return true;
        return subTree(t1, t2);
    }

    public static boolean subTree(BinaryTreeNode r1, BinaryTreeNode r2) {
        //big tree empty & subTree still not found
        if (r1 == null)
            return false;
        else if (r1.val == r2.val && isSameTree(r1, r2)) {
            return true;
        }
        return subTree(r1.left, r2) || subTree(r1.right, r2);
    }

    //check if two trees are same.
    public static boolean isSameTree(BinaryTreeNode a, BinaryTreeNode b) {
        if (a == null && b == null)
            return true;
        else if (a == null || b == null)
            return false;
        else if (a.val != b.val)
            return false;
        else
            return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }



    //Method 2: find the node in the subtree and check id both the trees are same
    public static boolean isSubTree(BinaryTreeNode t1, BinaryTreeNode t2) {
        if (t1 == null || t2 == null)
            return false;
        BinaryTreeNode node = findNode(t1, t2);
        boolean flag = isSameTree(node, t2);
        return flag;
    }

    private static BinaryTreeNode findNode(BinaryTreeNode root, BinaryTreeNode node) {
        if (root != null) {
            if (root == node) {
                return root;
            } else {
                BinaryTreeNode res = findNode(root.left, node);
                if (res == null)
                    res = findNode(root.right, node);
                return res;
            }
        } else {
            return null;
        }
    }



    public static void main (String[] args) {
        /*    4
            2    7
          1  3  5  6
         */
        BinaryTreeNode root1 = new BinaryTreeNode(4);
        root1.left = new BinaryTreeNode(2);
        root1.left.left = new BinaryTreeNode(1);
        root1.left.right = new BinaryTreeNode(3);
        root1.right = new BinaryTreeNode(7);
        root1.right.left = new BinaryTreeNode(5);
        root1.right.right = new BinaryTreeNode(8);

        TreeOperation to = new TreeOperation();
        to.show(root1);

        System.out.println("method1:");
        BinaryTreeNode temp1 = root1.left;
        System.out.println("check for subtree: " + temp1.val);
        System.out.println("containsTree(" + root1.val + ", " + temp1.val + ") : " + containsTree(root1, root1.left));
        System.out.println();
        System.out.println("method2:");
        BinaryTreeNode temp2 = root1.right;
        System.out.println("check for subtree: " + temp2.val);
        System.out.println("isSubTree(" + root1.val + ", " + temp2.val + ") : "+ isSubTree(root1, root1.right));
    }
}
