package com.douwen.top.tree;

public class SearchBST {

    public TreeNode searchBST(TreeNode root, int val){
        TreeNode cur = root;
        while(cur != null){
            if(cur.val == val){
                break;
            }
            if(cur.val < val){
                cur = cur.right;
            }else{
                cur = cur.left;
            }
        }
        return cur;
    }

}
