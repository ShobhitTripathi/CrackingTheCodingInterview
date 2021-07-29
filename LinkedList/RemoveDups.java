package LinkedLists;

import java.util.HashSet;

public class RemoveDups {

    static void removeDuplicatesHashMapSol (ListNode<Integer> head) {
        ListNode<Integer> curr = head;
        ListNode<Integer> prev = null;
        HashSet<Integer> set = new HashSet<>();

        while (curr != null) {
            int curr_value = curr.val;

            if(set.contains(curr_value)) {
                prev.next = curr.next;
            } else {
                set.add(curr.val);
                prev = curr;
            }
            curr = curr.next;
        }
    }

    static void removeDuplicatesInSortedList (ListNode<Integer> head) {
        ListNode<Integer> curr = head;

        while (curr != null) {
            ListNode<Integer> temp = curr;
            while (temp != null && curr.val == temp.val)
                temp = temp.next;
            curr.next = temp;
            curr = curr.next;
        }
    }

    /*-------------Driver code -------------*/
    public static void main(String[] args) {
        ListNode<Integer> head = new ListNode<>(9);
        head.next = new ListNode(9);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(7);

        //remove duplicate using hashSet O(n)
//        removeDuplicatesHashMapSol(head);

        //Sort and then remove duplicates O(nLogn)
        MergeSortInLinkedList obj = new MergeSortInLinkedList();
        ListNode<Integer> sortedList = obj.mergeSort(head);
        removeDuplicatesInSortedList(sortedList);
        ListNode<Integer> temp = sortedList;

    }
}
