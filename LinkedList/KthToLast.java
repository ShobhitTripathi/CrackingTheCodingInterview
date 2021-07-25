package LinkedLists;

import java.util.List;

public class KthToLast {

    static int getLength (ListNode head) {
        ListNode temp = head;
        int len = 0;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }

    static ListNode getKthFromLast (ListNode head, int k) {
        int len = getLength(head);
        int finalIndex = len - k;
        ListNode temp = head;
        int i = 0;

        while (temp != null && i < finalIndex) {
            temp = temp.next;
            i++;
        }
        return temp;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.val);
            temp = temp.next;
        }
        System.out.println("len : " + getLength(head));
        System.out.println("kth index from last value is : " + getKthFromLast(head,2).val);
    }
}
