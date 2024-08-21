package com.douwen.top.array;

import java.util.HashMap;
import java.util.Map;

public class SubarraySum {

    public static void main(String[] args) {
        int nums[] = {1,1,1};
        int k = 2;
        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums,int k){
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int result = 0;
        for(int num : nums){
            sum += num;
            // sum - k  和之前的sum 相等了，说明当前又增加了一个和为k的子数组
            result += sumToCount.getOrDefault(sum - k,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0) + 1);
        }
        return result;
    }


    public static int findMaxLength(int[] nums){
        Map<Integer,Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i] == 0 ? -1 : 1;
            if(sumToIndex.containsKey(sum)){
                result = Math.max(result,i - sumToIndex.get(sum));
            }else{
                sumToIndex.put(sum,i);
            }
        }
        return result;
    }
}
