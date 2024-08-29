package com.douwen.top.listnode;

public class GetIntersectionNode {


    public static ListNode getIntersectionNode(ListNode headA,ListNode headB){
        int count1 = countList(headA);
        int count2 = countList(headB);
        int delta = Math.abs(count1 - count2);
        ListNode longNode = count1 > count2 ? headA : headB;
        ListNode shortNode = count1 > count2 ? headB : headA;
        ListNode temp1Node = longNode;
        for(int i = 0; i < delta; i ++){
            temp1Node = temp1Node.next;
        }
        ListNode temp2Node = shortNode;
        while(temp1Node != temp2Node){
            temp1Node = temp1Node.next;
            temp2Node = temp2Node.next;
        }
        return temp1Node;
    }

    public static int countList(ListNode head){
        int result = 0;
        while(head != null){
            head = head.next;
            result ++;
        }
        return result;
    }

}
