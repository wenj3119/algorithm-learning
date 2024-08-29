package com.douwen.top.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class InorderTraversal {

    //使用递归实现
    public List<Integer> inorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root, List<Integer> result){
        if(root == null){
            return;
        }
        dfs(root.left,result);
        result.add(root.val);
        dfs(root.right,result);
    }

    //非递归实现
    public List<Integer> inorderTraversals(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            result.add(cur.val);
            cur = cur.right;
        }
        return result;
    }

}
