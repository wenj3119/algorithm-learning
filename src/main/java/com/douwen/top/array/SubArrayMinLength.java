package com.douwen.top.array;

public class SubArrayMinLength {



    public static int minSubArrayLen(int k,int[] nums){
        int p1 = 0;
        int p2 = 0;
        int sum = 0;
        int result = Integer.MAX_VALUE;
        for(;p2 < nums.length; p2 ++){
            sum += nums[p2];
            while(p1 <= p2 && sum >= k){
                result = Math.min(result,p2 - p1 + 1);
                sum -= nums[p1 ++];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

}
