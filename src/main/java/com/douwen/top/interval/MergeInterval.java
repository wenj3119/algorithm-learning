package com.douwen.top.interval;

import java.util.ArrayList;
import java.util.List;

public class MergeInterval {
    public static void main(String[] args) {
        int[][] ints = {{1,4},{0,4}};
        int[][] rel = merge(ints);
        for(int i = 0; i < rel.length; i ++){
            System.out.println(rel[i][0] + " " + rel[i][1]);
        }
        List<Integer> list = new ArrayList<>();

    }

    public static int[][] merge(int[][] intervals) {

        for(int i = 0 ; i < intervals.length; i ++){
            for(int j = i + 1; j < intervals.length; j ++){
                if(intervals[i][0] < intervals[j][0] && intervals[i][1] >= intervals[j][1]){
                    int[] temp = intervals[i];
                    intervals[i] = intervals[j];
                    intervals[j] = temp;
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0; i < intervals.length; i ++){
            int l = intervals[i][0],r = intervals[i][1];
            if(result.size() == 0 || result.get(result.size() -1 ).get(1) < l){
                List<Integer> list = new ArrayList<>();
                list.add(l);
                list.add(r);
                result.add(list);
            }else {
                result.get(result.size() - 1).set(1,Math.max(result.get(result.size() - 1).get(1),r));
            }
        }
        int length = result.size();
        int[][] rel = new int[length][2];
        for(int i = 0; i < length; i ++){
            int[] temp = new int[2];
            temp[0] = result.get(i).get(0);
            temp[1] = result.get(i).get(1);
            rel[i] = temp;
        }
        return rel;
    }
}
