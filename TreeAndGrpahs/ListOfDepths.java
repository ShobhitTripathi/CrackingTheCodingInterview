package TreesAndGraphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths {

    public static List<List<Integer>> levelOrderTraversal(BinaryTreeNode root) {
        if (root == null)
            return null;
        List<List<Integer>> res = new ArrayList<>();
        Queue<BinaryTreeNode> q =  new LinkedList<>();
        q.offer(root);
        q.offer(null);

        List<Integer> curr = new ArrayList<>();
        while (!q.isEmpty()) {
            BinaryTreeNode temp = q.poll();
            if (temp != null) {
                curr.add(temp.val);
                if (temp.left != null)
                    q.offer(temp.left);
                if (temp.right != null)
                    q.offer(temp.right);
            } else {
                List<Integer> c_curr = new ArrayList<>(curr);
                res.add(c_curr);
                curr.clear();
                if (!q.isEmpty())
                    q.offer(null);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        BinaryTreeNode root = new BinaryTreeNode(1);
        root.left = new BinaryTreeNode(2);
        root.right = new BinaryTreeNode(3);
        root.left.left = new BinaryTreeNode(4);
        root.right.left= new BinaryTreeNode(5);
        root.left.right= new BinaryTreeNode(6);

        List<List<Integer>> res = levelOrderTraversal(root);
        System.out.println(res.toString());
    }
}
