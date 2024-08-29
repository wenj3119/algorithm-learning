package com.douwen.top.listnode;

public class RecorderList {


    public static void reorderList(ListNode head){
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode fast = dumpNode;
        ListNode slow = dumpNode;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null){
                fast = fast.next;
            }
        }
        //中间节点
        ListNode temp = slow.next;
        slow.next = null;
        link(head,reverseList(temp),dumpNode);
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
    public static void link(ListNode node1, ListNode node2, ListNode head){
        ListNode pre = head;
        while(node1 != null && node2 != null){
            ListNode temp = node1.next;

            pre.next = node1;
            node1.next = node2;
            pre = node2;

            node1 = temp;
            node2 = node2.next;
        }
        if(node1 != null){
            pre.next = node1;
        }
    }

}
