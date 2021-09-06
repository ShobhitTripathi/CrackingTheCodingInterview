package TreesAndGraphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTSequence {
    public static int count = 0;

    public static ArrayList<LinkedList<Integer>> allSequence(BinaryTreeNode node) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();

        if (node == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(node.val);

        /* Recurse on left and right subtrees. */
        ArrayList<LinkedList<Integer>> leftSeq = allSequence(node.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequence(node.right);

        /* Weave together each list from the left and right sides. */
        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
//                System.out.println("left: " + left.toString());
//                System.out.println("right: " + right.toString());
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }
        return result;
    }

    /* Weave lists together in all possible ways. This algorithm works by removing the
        head from one list, recursing, and then doing the same thing with the other list. */
    public static void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                                 ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
//        System.out.println();
//        System.out.println("weaveLists: count " + count);
//        count++;
//        System.out.println("weaveLists: first : " + first.toString());
//        System.out.println("weaveLists: second : " + second.toString());
//        System.out.println("weaveLists: results : " + results.toString());
//        System.out.println("weaveLists: prefix : " +prefix.toString());

        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
//            System.out.println();
//            System.out.println("first.size() :" + first.size() + " second.size() : " + second.size());
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
//            System.out.println("inside if: result :" + result.toString());
//            System.out.println("inside if: first :" + first.toString());
//            System.out.println("inside if: second :" + second.toString());
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the head will damage first,
        so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list. */
        int secondFirst = second.removeFirst();
        prefix.addLast(secondFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(secondFirst);
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
//        root.right = new BinaryTreeNode(7);
//        root.right.left = new BinaryTreeNode(5);
//        root.right.right = new BinaryTreeNode(8);

        ArrayList<LinkedList<Integer>> result = allSequence(root);

        System.out.println("result: "+result.toString());
    }
}
