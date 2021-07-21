package LinkedLists;

import static LinkedLists.ListNode.printList;

public class CheckPalindrome {

    public static boolean isListPalindrome (ListNode head) {
        ListNode middle = getMiddle(head);
        ListNode revFromMiddle = reverseList(middle);
        ListNode curr = head;
        while (curr != middle && revFromMiddle != null) {
            if (curr.val != revFromMiddle.val)
                return false;
            curr = curr.next;
            revFromMiddle = revFromMiddle.next;
        }
        return true;
    }

    public static ListNode getMiddle (ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static ListNode  reverseList(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next = new ListNode(1);

        printList(head);
        System.out.println("is palindrome: " + isListPalindrome(head));
    }
}
