package com.douwen.top.hash;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    //声明一个头节点和尾节点方面操作
    private ListNode head;
    private ListNode tail;
    //声明一个哈希缓存用于降低操作时间复杂度
    private Map<Integer,ListNode> map;
    int capacity;
    public LRUCache(int cap){
        //在构造方法中初始化容器与节点并将双向链表链接起来
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
        capacity = cap;
    }
    //根据key获取value值
    public int get(int key){
        //从map缓存中获取
        ListNode node = map.get(key);
        //如果缓存中没有，则返回-1
        if(node == null){
            return -1;
        }
        //缓存中有，则将获取到的节点移动到最后面
        moveToTail(node,node.value);
        //并返回节点的值
        return node.value;
    }
    public void put(int key,int value){
        //如果缓存中有，则将node移动到链表末尾
        if(map.containsKey(key)){
            moveToTail(map.get(key),value);
        }else{
            // 如果缓存中没有，并且缓存已经放满
            if(map.size() == capacity){
                //则删除头节点，因为最近使用的都放在末尾节点，头节点为最近最少使用的
                ListNode toBeDeleted = head.next;
                deleteNode(toBeDeleted);
                //并且删除该节点的环境
                map.remove(toBeDeleted.key);
            }
            //根据key和value创建新的node节点，并加入到链表尾部
            ListNode node = new ListNode(key,value);
            insertToTail(node);
            //并加入到缓存中
            map.put(key,node);
        }
    }
    //移动node节点到尾部的操作，先删除当前node节点，然后将修改当前node节点的value值，然后将node插入的尾节点。
    private void moveToTail(ListNode node,int newValue){
        deleteNode(node);
        node.value = newValue;
        insertToTail(node);
    }
    //删除节点，将node节点的前一个节点的下一个指针指向node节点的下一个节点，然后将node节点的下一个节点的上一个指针指向node节点的上一个节点
    private void deleteNode(ListNode node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    //将node节点插入尾部，将尾部的前一个节点的下一个指针指向node节点，将node节点的向前指针指向尾节点的上一个节点，node节点的下一个指针指向尾节点，尾节点的前一个指针指向node
    private void insertToTail(ListNode node){
        tail.prev.next = node;
        node.prev = tail.prev;
        node.next = tail;
        tail.prev = node;
    }

}
