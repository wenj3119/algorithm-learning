package com.douwen.top.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PreorderTraversal {

    //递归方式实现
    public List<Integer> preorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        result.add(root.val);
        dfs(root.left,result);
        dfs(root.right,result);
    }
    //非递归方式实现
    public List<Integer> preorderTraversalP(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                result.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return result;
    }

}
