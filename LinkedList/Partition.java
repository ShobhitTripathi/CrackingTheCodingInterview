package LinkedLists;

import static LinkedLists.ListNode.printList;

public class Partition {
    /** the basic idea is to maintain two queues,
     * the first one stores all nodes with val less than x , and the second queue stores all the rest nodes.
     * Then concat these two queues.
     * Remember to set the tail of second queue a null next, or u will get TLE.
     */

    public static ListNode partition(ListNode<Integer> head, int x) {
        //dummy heads of the 1st and 2nd queues
        ListNode<Integer> dummy1 = new ListNode<>(0);
        ListNode<Integer> dummy2 = new ListNode<>(0);
        //current tails of the two queues;
        ListNode<Integer> curr1 = dummy1, curr2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }

    /*------------Driver Code-------------*/
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode(3);
        head.next = new ListNode(5);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(1);
        System.out.println("Before Partition.");
        printList(head);
        ListNode<Integer> resultList = partition(head,5);
        System.out.println("After Partition.");
        printList(resultList);

    }
}
