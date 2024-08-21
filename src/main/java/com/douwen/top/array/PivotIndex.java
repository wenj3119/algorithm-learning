package com.douwen.top.array;

public class PivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums){
        int total = 0;
        for(int num : nums){
            total += num;
        }
        int sum = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i];
            //前面和等于后面和
            if(sum - nums[i] == total - sum){
                return i;
            }
        }
        return -1;
    }
}
