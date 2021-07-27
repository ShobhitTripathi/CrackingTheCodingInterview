package LinkedLists;

import java.util.LinkedList;

public class MergeSortInLinkedList {

    public MergeSortInLinkedList () {
    }

    public static ListNode sortedMerge (ListNode<Integer> a, ListNode<Integer> b) {
        ListNode result = null;
        if (a == null)
            return b;
        if (b == null)
            return a;

        if (a.val <= b.val) {
            result = a;
            result.next = sortedMerge(a.next, b);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next);
        }
        return result;
    }

    public static ListNode mergeSort (ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode<Integer> middle = getMiddleNode(head);
        ListNode<Integer> nextOfMiddle = middle.next;
        middle.next = null;

        // Apply mergeSort on left list
        ListNode<Integer> left = mergeSort(head);

        // Apply mergeSort on right list
        ListNode<Integer> right = mergeSort(nextOfMiddle);

        // Merge the left and right lists
        ListNode<Integer> sortedlist = sortedMerge(left, right);
        return sortedlist;
    }

    public static ListNode<Integer> getMiddleNode (ListNode<Integer> head) {
        ListNode<Integer> slow = head;
        ListNode<Integer> fast = head;
        int i = 0;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    /*-------------Driver Code -------------*/
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode(1);
        head.next = new ListNode(15);
        head.next.next = new ListNode(11);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(5);

        ListNode<Integer> temp = mergeSort(head);
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }

    }
}
