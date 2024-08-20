package com.douwen.top.tree;

import java.util.HashMap;
import java.util.Map;



public class InorderPostTreeBuild {

    public static void main(String[] args) {
        int[] inorder = {9,3,15,20,7};
        int[] post = {9,15,7,20,3};
        TreeNode treeNode = buildTree(inorder, post);
        System.out.println(treeNode);

    }

    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }
    static int post_index;
    static Map<Integer,Integer> inorderMap;

    public static TreeNode buildTree(int[] inorder,int[] post ){
        int n = inorder.length;
        if(n == 0){
            return null;
        }
        post_index = n - 1;
        inorderMap = new HashMap<>();
        for(int i = 0; i < n; i ++){
            inorderMap.put(inorder[i],i);
        }
        return dbuildTree(inorder,post,0,n - 1);
    }

    private static TreeNode dbuildTree(int[] inorder, int[] post, int in_left, int in_right) {
        if(in_left > in_right){
            return null;
        }
        int root_val = post[post_index];

        TreeNode root = new TreeNode(root_val);

        int root_index = inorderMap.get(root_val);

        post_index --;
        root.right = dbuildTree(inorder,post,root_index + 1,in_right);
        root.left = dbuildTree(inorder,post,in_left,root_index - 1);

        return root;
    }


}
