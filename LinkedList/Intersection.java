package LinkedLists;

public class Intersection {

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int diff = 0;
        ListNode listA, listB;
        ListNode result = null;
        int L1 = getLength(headA);
        int L2 = getLength(headB);

        if (L1 < L2) {
            listA = headB;
            listB = headA;
            diff = L2 - L1;
        } else {
            listA = headA;
            listB = headB;
            diff = L1 - L2;
        }

        for (int i = 0; i < diff; i++)
            listA = listA.next;

        while (listA != null && listB != null) {
            if (listA == listB) {
                result = listA;
                break;
            }
            listA = listA.next;
            listB = listB.next;
        }
        return result;
    }

    public static int getLength (ListNode head) {
        int length = 0;

        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }

    /*-----------Driver Code--------------*/
    public static void main (String[] args) {
        ListNode head1 = new ListNode (1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode (11);
        head2.next = new ListNode(121);
        head2.next.next = head1.next.next;

        System.out.println("Intersection node value : " + getIntersectionNode(head1, head2).val);
    }
}
