package com.douwen.top.tree;

import java.util.HashMap;
import java.util.Map;

public class PreInorderTreeBuild {

    public static void main(String[] args) {
        int[] pre = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode treeNode = buildTree(pre, inorder);
        System.out.println(treeNode.val);
    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(){

        }
        public TreeNode(int val){
            this.val = val;
        }
    }

    static Map<Integer,Integer> inorderMap;
    public static TreeNode buildTree(int[] pre,int[] inorder){
        int n = inorder.length;
        if(n == 0){
            return null;
        }
        inorderMap = new HashMap<>();
        for(int i = 0; i < n; i ++){
            inorderMap.put(inorder[i],i);
        }
        return myBuildTree(pre,inorder,0,n - 1,0, n - 1);
    }

    private static TreeNode myBuildTree(int[] pre, int[] inorder, int pre_left, int pre_right, int inorder_left, int inorder_right) {
        if(pre_left > pre_right){
            return null;
        }

        int pre_root_index = pre_left;

        int inorder_root_index = inorderMap.get(pre[pre_root_index]);

        int left_size = inorder_root_index - inorder_left;

        TreeNode root = new TreeNode(pre[pre_root_index]);

        root.left = myBuildTree(pre,inorder,pre_left + 1,pre_left + left_size,inorder_left,inorder_root_index -1);

        root.right = myBuildTree(pre,inorder,pre_left + left_size + 1,pre_right,inorder_root_index + 1,inorder_right);

        return root;
    }

}
