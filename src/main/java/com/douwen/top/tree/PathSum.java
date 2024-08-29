package com.douwen.top.tree;

import java.util.HashMap;
import java.util.Map;

public class PathSum {


    public int pathSum(TreeNode root,int sum){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);
        return dfs(root,sum,map,0);
    }
    private int dfs(TreeNode root,int sum,Map<Integer,Integer> map,int path){
        if(root == null){
            return 0;
        }
        path += root.val;
        int count = map.getOrDefault(path - sum, 0);
        map.put(path,map.getOrDefault(path,0) + 1);
        count += dfs(root.left,sum,map,path);
        count += dfs(root.right,sum,map,path);
        map.put(path,map.get(path) - 1);
        return count;
    }

}
