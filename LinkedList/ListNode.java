package LinkedLists;

public class ListNode<T> {
    public Object printList;
    public T val;
    public ListNode<T> next;

    public ListNode() {}
    public ListNode(T val) {
        this.val = val;
    }
    ListNode (T val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printList (ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}


