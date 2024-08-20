package com.douwen.top.interval;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval {

    public static void main(String[] args) {
        int[][] ints = {{1,2},{3,5},{6,7},{8,10},{12,16}};
        int[] newInts = {4,8};
        int[][] insert = insert(ints,newInts);
        for(int[] ints1: insert){
            String s = "";
            Integer.parseInt("");
            System.out.println(ints1[0] + ": " + ints1[1]);
        }


    }

    public static int[][] insert(int[][] intervals, int[] newInterval){
        if(newInterval.length == 0){
            return intervals;
        }
        int left = newInterval[0], right = newInterval[1];
        boolean placed = false;
        List<int[]> merged = new ArrayList<>();
        for(int[] ints : intervals){
            if(ints[0] > right){
                if(!placed){
                    merged.add(new int[]{left,right});
                    placed = true;
                }
                merged.add(ints);
            }else if(ints[1] < left){
                merged.add(ints);
            }else{
                left = Math.min(left,ints[0]);
                right = Math.max(right,ints[1]);
            }
        }
        if(!placed){
            merged.add(new int[]{left,right});
        }
        int[][] rel = new int[merged.size()][2];
        for(int i = 0 ; i < merged.size(); i ++){
            rel[i]= merged.get(i);
        }
        return  rel;
    }

}
