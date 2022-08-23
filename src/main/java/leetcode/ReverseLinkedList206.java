package leetcode;

import org.junit.Test;

public class ReverseLinkedList206 {


    @Test
    public void testReverseList() {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2, listNode1);
        ListNode listNode3 = new ListNode(3, listNode2);
        ListNode listNode4 = new ListNode(4, listNode3);
        ListNode listNode5 = new ListNode(5, listNode4);
        ListNode listNode6 = new ListNode(6, listNode5);
        ListNode listNode7 = new ListNode(7, listNode6);
        ListNode listNode8 = new ListNode(8, listNode7);
        ListNode listNode9 = new ListNode(9, listNode8);

        printListNode(listNode9);
        printListNode(reverseList(listNode9));
    }

    public void printListNode(ListNode head) {
        System.out.print(head.val + " ");
        if(head.next == null) {
            System.out.println();
            return;
        }
        printListNode(head.next);
    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode rvList = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return rvList;
    }
}

