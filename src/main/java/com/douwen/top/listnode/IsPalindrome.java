package com.douwen.top.listnode;

public class IsPalindrome {
    public static boolean isPalindrome(ListNode head){
        if(head == null || head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while(fast.next != null && fast.next.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
        }
        ListNode temp = slow.next;
        if(fast.next != null){
            temp = slow.next.next;
        }
        slow.next = null;
        return equals(temp,reverseList(head));
    }
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

    public static boolean equals(ListNode node1, ListNode node2){
        while(node1 != null && node2 != null){
            if(node1.val != node2.val){
                return false;
            }
            node1 = node1.next;
            node2 = node2.next;
        }
        return node1 == null && node2 == null;
    }
}
