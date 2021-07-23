package LinkedLists;

import java.util.List;

public class DeleteMiddleNode {

    public static int findMiddle (ListNode head) {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        int i = 0, index = 0;

        while (fastPtr.next != null) {
            if (i == 1) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
                i = 0;
                index++;
            } else {
                fastPtr = fastPtr.next;
                i = 1;
            }
        }
        return index;
    }

    public static void deleteNodeAtIndex(ListNode head, int pos) {
        ListNode curr = head;
        ListNode prev = null;
        if (pos == 0) {
            head = curr.next;
            return;
        }
        int index = 0;
        while (curr != null && index < pos) {
            prev = curr;
            curr = curr.next;
            index++;

        }
        prev.next = curr.next;
    }


    public static void deleteNode (ListNode<Integer> node) {
        int temp;
        temp = node.val;
        node.val = node.next.val;
        node.next.val = temp;

        node.next = node.next.next;

    }

    /*-----------Driver Code--------------*/
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        deleteNode(head.next.next.next);
        ListNode<Integer> temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
    }
}

