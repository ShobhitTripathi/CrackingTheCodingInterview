package TreesAndGraphs;

import com.sun.source.tree.BinaryTree;

class Node {

    int data;
    Node left, right, parent;

    Node(int d) {
        data = d;
        left = right = parent = null;
    }
}

public class InOrderSuccessor {

    Node insert(Node node, int data) {
        if (node == null) {
            return (new Node(data));
        } else {
            Node temp = null;
            if (data <= node.data) {
                temp = insert(node.left, data);
                node.left = temp;
                temp.parent = node;
            } else {
                temp = insert(node.right, data);
                node.right = temp;
                temp.parent = node;
            }
            return node;
        }
    }

    Node inOrderSuccessor(Node root, Node n) {
        if (n.right != null) {
            return minValue(n.right);
        }

        Node p = n.parent;
        while (p != null && n == p.right) {
            n = p;
            p = p.parent;
        }
        return p;
    }

    Node minValue(Node node) {
        Node current = node;

        /* loop down to find the leftmost leaf */
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    public static void withParentNode() {
        InOrderSuccessor tree = new InOrderSuccessor();
        Node root = null, temp = null, suc = null, min = null;
        root = tree.insert(root, 20);
        root = tree.insert(root, 8);
        root = tree.insert(root, 22);
        root = tree.insert(root, 4);
        root = tree.insert(root, 12);
        root = tree.insert(root, 10);
        root = tree.insert(root, 14);
        temp = root.left.right.right;
        suc = tree.inOrderSuccessor(root, temp);
        if (suc != null) {
            System.out.println("withParentNode: Inorder successor of " + temp.data + " is " + suc.data);
        } else {
            System.out.println("withParentNode: Inorder successor does not exist");
        }
    }

    //Solution without having the parent Information in the TreeNode
    public static BinaryTreeNode getInorderSuccessor(BinaryTreeNode root, BinaryTreeNode node) {
        if (node == null)
            return null;

        if (node.right != null) {
            return getMinimum(node.right);
        }

        BinaryTreeNode succ = null;

        while (root != null) {
            if (node.val < root.val) {
                succ = root;
                root = root.left;
            } else if (node.val > root.val) {
                root = root.right;
            } else
                break;
        }

        return succ;
    }

    public static BinaryTreeNode getMinimum(BinaryTreeNode root) {
        if (root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    public static void withoutParentNode () {
                /*    8
            4     14
          2   7  10  16
         1 3 5  9       18
         */
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


        BinaryTreeNode temp = root.left.left.right;

        BinaryTreeNode ans = getInorderSuccessor(root, temp);
        if (ans != null)
            System.out.println("withoutParentNode: InorderSuccessor for " + temp.val + " is : " + ans.val);
        else
            System.out.println("withoutParentNode: Inorder successor does not exist");
    }

    public static void main(String[] args) {
        withoutParentNode();
        withParentNode();

    }
}
