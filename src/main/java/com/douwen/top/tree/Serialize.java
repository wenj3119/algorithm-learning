package com.douwen.top.tree;

public class Serialize {


    public String serialize(TreeNode root){
        if(root == null){
            return "#";
        }
        String leftStr = serialize(root.left);
        String rightStr = serialize(root.right);
        return String.valueOf(root.val + "," + leftStr + "," + rightStr);
    }

    public TreeNode deserialize(String data){
        String[] nodeStrs = data.split(",");
        int[] i ={0};
        return dfs(nodeStrs,i);
    }
    private TreeNode dfs(String[] strs,int[] i){
        String str = strs[i[0]];
        i[0] ++;
        if(str.equals("#")){
            return null;
        }
        TreeNode node = new TreeNode(Integer.valueOf(str));
        node.left = dfs(strs,i);
        node.right = dfs(strs,i);
        return node;
    }

}
