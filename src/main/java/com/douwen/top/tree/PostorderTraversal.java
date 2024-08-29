package com.douwen.top.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class PostorderTraversal {
    // 使用递归方式实现
    public List<Integer> postorderTraversal(TreeNode root){
        List<Integer> result = new LinkedList<>();
        dfs(root,result);
        return result;
    }
    public void dfs(TreeNode root,List<Integer> result){
        if(root == null){
            return;
        }
        dfs(root.left,result);
        dfs(root.right,result);
        result.add(root.val);
    }
    //使用非递归方式实现
    public List<Integer> postorderTraversalp(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode pre = null;
        while(cur != null || !stack.isEmpty()){
            while(cur != null){
                stack.push(cur);
                cur = root.left;
            }
            cur = stack.peek();
            if(cur.right != null && cur.right != pre){
                cur = cur.right;
            }else{
                stack.pop();
                result.add(cur.val);
                pre = cur;
                cur = null;
            }
        }
        return result;
    }
}
