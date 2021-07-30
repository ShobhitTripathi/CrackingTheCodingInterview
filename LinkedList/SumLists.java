package LinkedLists;

import java.util.Stack;

import static LinkedLists.ListNode.printList;

public class SumLists {

    public static ListNode addTwoNumbers2 (ListNode<Integer> l1, ListNode<Integer> l2) {
        Stack<Integer> s1 = new Stack<>();
        Stack<Integer> s2 = new Stack<>();

        while (l1 != null) {
            s1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            s2.push(l2.val);
            l2 = l2.next;
        }

        int sum = 0;
        ListNode<Integer> result = new ListNode<>(-1);
        ListNode<Integer> traverse = result;

        while(!s1.empty() || !s2.empty()) {
            if (!s1.empty()) sum += s1.pop();
            if (!s2.empty()) sum += s2.pop();
            result.val = sum % 10;
            ListNode head = new ListNode(sum / 10);
            head.next = result;
            result = head;
            sum /= 10;

        }
        return result.next;
    }

    /** The digits are stored in reverse order, and each of their nodes contains a single digit.**/
    public static ListNode addTwoNumbers1 (ListNode<Integer> l1, ListNode<Integer> l2) {
        ListNode<Integer> result = new ListNode<>(-1);
        ListNode<Integer> traverse = result;
        int sum = 0;

        while (l1 != null || l2 != null || sum != 0) {
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            traverse.next = new ListNode<>(sum % 10);
            traverse = traverse.next;
            sum = sum /10;
        }
        return result.next;
    }

    /*-----------Driver Code---------------*/
    public static void main(String[] args) {
        ListNode<Integer> list1 = new ListNode<>(6);
        list1.next = new ListNode<>(1);
        list1.next.next = new ListNode<>(7);
        System.out.print("List1: ");
        printList(list1);

        ListNode<Integer> list2 = new ListNode<>(2);
        list2.next = new ListNode<>(9);
        list2.next.next = new ListNode<>(5);
        System.out.print("List2: ");
        printList(list2);

        ListNode<Integer> sumList = addTwoNumbers1(list1, list2);
        System.out.print("addTwoNumbers1, SumList : ");
        printList(sumList);

        ListNode<Integer> sumList2 = addTwoNumbers2(list1, list2);
        System.out.print("addTwoNumbers2, SumList : ");
        printList(sumList2);
    }

}
