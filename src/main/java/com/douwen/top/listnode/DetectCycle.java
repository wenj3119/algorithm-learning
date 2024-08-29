package com.douwen.top.listnode;

public class DetectCycle {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
    }

    public static ListNode getNodeInLoop(ListNode head){
        if(head == null || head.next == null){
            return null;
        }
        ListNode slow = head;
        ListNode fast = slow.next;
        while(slow != null && fast != null){
            if(slow == fast){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast != null){
                fast = fast.next;
            }
        }
        return null;
    }

    public static ListNode detectCycle(ListNode head){
        ListNode inLoop = getNodeInLoop(head);
        if(inLoop == null){
            return null;
        }
        ListNode node = head;
        while(node != inLoop){
            node = node.next;
            inLoop = inLoop.next;
        }
        return node;
    }

}
