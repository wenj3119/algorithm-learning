package com.douwen.top.listnode;

public class DumpList {

    public ListNode append(ListNode head, int val){
        ListNode newNode = new ListNode(val);
        //需要对头节点判空
        if(head == null){
            return newNode;
        }
        ListNode node = head;
        while(node.next != null){
            node = node.next;
        }
        node.next = newNode;
        return head;
    }

    public ListNode append1(ListNode head, int val){
        //创建哨兵节点
        ListNode dumpNode = new ListNode(-1);
        //将哨兵节点的下一个节点指向头节点
        dumpNode.next  = head;

        ListNode newNode = new ListNode(val);
        ListNode node = dumpNode;
        while(node.next != null){
            node = node.next;
        }
        node.next = newNode;
        return dumpNode.next;
    }

    public ListNode delete(ListNode head,int val){
        if(head == null){
            return head;
        }
        if(head.val == val){
            return head.next;
        }
        ListNode node = head;
        while(node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
                break;
            }
            node = node.next;
        }
        return head;
    }

    public ListNode delete1(ListNode head, int val){
        ListNode dumpNode = new ListNode(-1);
        dumpNode.next = head;
        ListNode node = dumpNode;
        while(node.next != null){
            if(node.next.val == val){
                node.next = node.next.next;
            }
            node = node.next;
        }
        return dumpNode.next;
    }

}
