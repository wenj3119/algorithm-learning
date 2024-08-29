package com.douwen.top.listnode;

public class AddTwoNumbers {


    public static ListNode reverseList(ListNode head){
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode addTwoNumbers(ListNode head1,ListNode head2){
        head1 = reverseList(head1);
        head2 = reverseList(head2);
        ListNode reverseHead = addReversed(head1, head2);
        return reverseList(reverseHead);
    }

    public static ListNode addReversed(ListNode head1, ListNode head2){
        ListNode dumpNode = new ListNode(-1);
        ListNode sumNode = dumpNode;
        int carry = 0;
        while(head1 != null || head2 != null){
            int sum = (head1 == null ? 0 : head1.val) + (head2 == null ? 0 : head2.val) + carry;
            carry = sum >=10 ? 1: 0;
            sum = sum >= 10 ? sum - 10 : sum;
            ListNode newNode = new ListNode(sum);
            sumNode.next = newNode;
            sumNode = sumNode.next;
            head1 = head1 == null ? null : head1.next;
            head2 = head2 == null ? null : head2.next;
        }
        if(carry > 0){
            sumNode.next = new ListNode(carry);
        }
        return dumpNode.next;
    }

}
