package com.douwen.top.tree;

import java.util.Stack;

public class BSTIteratorReversed{
    TreeNode cur;
    Stack<TreeNode> stack;
    public BSTIteratorReversed(TreeNode root){
        this.cur = root;
        this.stack = new Stack<>();
    }
    public boolean hasPrev(){
        return cur != null || !stack.isEmpty();
    }
    public int prev(){
        while(cur != null){
            stack.push(cur);
            cur = cur.right;
        }
        cur = stack.pop();
        int val = cur.val;
        cur = cur.left;
        return val;
    }
}
