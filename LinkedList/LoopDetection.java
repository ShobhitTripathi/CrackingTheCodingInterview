package LinkedLists;

public class LoopDetection {

    public static ListNode getStartNodeIfLoop (ListNode head) {
        System.out.println("DetectLoop");
        boolean flag = false;
        ListNode slowPtr = head;
        ListNode fastPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;

            if (fastPtr == slowPtr) {
                flag = true;
                break;
            }
        }

        if (flag == true) {
            System.out.println("The linkedList have loop.");
            slowPtr = head;

            while (slowPtr != fastPtr) {
                slowPtr = slowPtr.next;
                fastPtr = fastPtr.next;
            }
        } else {
            System.out.println("The linkedList does not have a loop.");
            return new ListNode(-1);
        }
        return slowPtr;
    }

    /*--------------Driver Code-------------*/
    public static void main (String[] args) {
        ListNode head = new ListNode (1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next = head.next.next;

        System.out.println("The value for start of loop is : " + getStartNodeIfLoop(head).val);
    }

}
