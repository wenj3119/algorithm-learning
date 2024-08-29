package com.douwen.top.tree;

import java.util.Stack;

public class IncreasingBST {

    public TreeNode increasingBST(TreeNode root){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode prev = null;
        TreeNode first = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(prev != null){
                prev.right = cur;
            }else{
                first = cur;
            }
            prev = cur;
            cur.left = null;
            cur = cur.right;
        }
        return first;
    }

}
