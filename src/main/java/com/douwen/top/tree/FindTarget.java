package com.douwen.top.tree;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FindTarget {

    //利用哈希表
    public boolean findTarget(TreeNode root, int k){
        Set<Integer> set = new HashSet<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(set.contains(k - cur.val)){
                return true;
            }
            set.add(cur.val);
            cur = cur.right;
        }
        return false;
    }

    public boolean findTarget1(TreeNode root, int k){
        if(root == null){
            return false;
        }
        BSTIteratorReversed iterPrev = new BSTIteratorReversed(root);
        BSTIterator iterNext = new BSTIterator(root);
        int next = iterNext.next();
        int prev = iterPrev.prev();
        while(next != prev){
            if(next + prev == k){
                return true;
            }
            if(next + prev < k){
                next = iterNext.next();
            }else{
                prev = iterPrev.prev();
            }
        }
        return false;
    }

}
