package com.douwen.top.listnode;

public class CircularLinkedList {

    public static Node insert(Node head,int insertVal){
        Node node = new Node(insertVal);
        if(head == null){
            head = node;
            head.next = head;
        }else if(head.next == head){
            head.next = node;
            node.next = head;
        }else{
            insertCore(head,node);
        }
        return head;
    }
    public static void insertCore(Node head,Node node) {
        Node cur = head;
        Node next = head.next;
        Node biggest = head;
        //未找到Node属于相邻两个节点之间时，去遍历链表获取链表最大值的节点
        while (!(cur.val <= node.val && next.val >= node.val) && next != head) {
            cur = next;
            next = next.next;
            if (cur.val >= biggest.val) {
                biggest = cur;
            }
        }
        //正常情况下，找到大于node值的和小于node值的两个相邻节点，将node插入进去
        if (cur.val <= node.val && next.val >= node.val) {
            cur.next = node;
            node.next = next;
        } else {
            //特殊情况，将node插入到最大节点和最小节点之间
            node.next = biggest.next;
            biggest.next = node;
        }
    }

}
