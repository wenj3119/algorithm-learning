package com.douwen.top.linkedlist;

public class KReverse {
    public static void main(String[] args) {

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if(head == null){
            return  head;
        }
        ListNode p = head;
        int size = 1;
        while(p != null && p.next != null && size < k){
            size ++;
            p = p.next;
        }
        if(size < k){
            return head;
        }
        ListNode h = head;
        ListNode pre = null;
        ListNode next = p.next;
        while (h != next){
            ListNode temp = h.next;
            h.next = pre;
            pre = h;
            h = temp;
        }
        head.next = reverseKGroup(next,k);
        return p;
    }

}
