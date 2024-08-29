package com.douwen.top.tree;

import java.util.Stack;

public class BSTIterator{
    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIterator(TreeNode root){
        this.cur = root;
        this.stack = new Stack<>();
    }
    public boolean hasNext(){
        return cur != null || !stack.isEmpty();
    }
    public int next(){
        while(cur != null){
            stack.push(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.right;
        return val;
    }
}
