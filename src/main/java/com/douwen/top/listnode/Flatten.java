package com.douwen.top.listnode;

public class Flatten {

    public static Node flatten(Node head){
        flattenGetTail(head);
        return head;
    }
    public static Node flattenGetTail(Node head){
        Node node = head;
        Node tail = null;
        while(node != null){
            Node next = node.next;
            //判断子链表是否为空
            if(node.child != null){
                //获取子链表
                Node child = node.child;
                //多子链表进行展平
                Node childTail = flattenGetTail(child);
                //展平之后节点的子链表为空
                node.child = null;
                //将节点的下一个指针指向子链表的头节点
                node.next = child;
                //将子链表的头节点的前一个指针指向node节点
                child.prev = node;
                // 将子链表的尾节点的下一个指针指向 node的下一个节点
                childTail.next = next;
                if(next != null){
                    //如果下一个节点不是空，则将下一个节点的前一个指针指向子链表的尾节点
                    next.prev = childTail;
                }
                //将子链表的尾节点赋值给原来的尾节点
                tail = childTail;
            }else{
                //如果没有子链表，则将当前节点赋值给尾节点
                tail = node;
            }
            //将下一个节点赋值给当前节点，进行链表遍历
            node = next;
        }
        return tail;
    }
}
