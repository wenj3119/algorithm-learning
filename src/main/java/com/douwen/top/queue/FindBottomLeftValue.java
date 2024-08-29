package com.douwen.top.queue;

import java.util.LinkedList;
import java.util.Queue;

public class FindBottomLeftValue {


    public int findBottomLeftValue(TreeNode root){
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(root);
        int bottomLeft = root.val;
        while(!queue1.isEmpty()){
            TreeNode node = queue1.poll();
            if(node.left != null){
                queue2.offer(node.left);
            }
            if(node.right != null){
                queue2.offer(node.right);
            }
            if(queue1.isEmpty()){
                queue1 = queue2;
                queue2 = new LinkedList<>();
                if(!queue1.isEmpty()){
                    bottomLeft = queue1.peek().val;
                }
            }
        }
        return bottomLeft;
    }
}
