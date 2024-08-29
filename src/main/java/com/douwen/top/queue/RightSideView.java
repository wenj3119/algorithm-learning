package com.douwen.top.queue;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightSideView {
    public List<Integer> rightSideView(TreeNode root){
        List<Integer> result = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        if(root != null){
            queue1.offer(root);
        }else{
            return result;
        }
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(node.left != null){
                queue2.offer(node.left);
            }
            if(node.right != null){
                queue2.offer(node.right);
            }
            if(queue1.isEmpty()){
                result.add(node.val);
                queue1 = queue2;
                queue2 = new LinkedList<>();
            }
        }
        return result;
    }
}
