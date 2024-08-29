package com.douwen.top.tree;

import java.util.Stack;

public class InorderSuccessor {
    //增加中间变量标记是否遍历到p节点，如果遍历到则中间遍历标记为true，如果中间变量为true时，遍历到的下个节点即为答案
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        boolean flag = false;
        while(cur != null || !stack.isEmpty()){
            while (cur != null){
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(flag){
                break;
            }else if(p == cur){
                flag = true;
            }
            cur = cur.right;
        }
        return cur;
    }

    /**p的下一个节点的值一定是比p的值大于等于里面最小的一个值，每到达一个根节点就比较其值与p节点值的大小，如果当前节点
     *的值小于或等于p的值，那么节点p的下一个节点应该在它的右子树，如果当前节点的值大于节点p的值，那么当前节点有可能是它
     *的下一个节点。此时当前节点的值比节点p的值大，但节点p的下一个节点时所有比它大的节点中值最小的一个，所以接下来前往
     *当前节点的左子树，找到值更小但仍然大于节点p的值的节点，重复这样的比较，直到找到最后一个大于节点p值的节点。
     */
    public TreeNode inorderSuccessor1(TreeNode root,TreeNode p){
        TreeNode cur = root;
        TreeNode result = null;
        while(cur != null){
            if(cur.val > p.val){
                result = cur;
                cur = cur.left;
            }else{
                cur = cur.right;
            }
        }
        return result;
    }
}
