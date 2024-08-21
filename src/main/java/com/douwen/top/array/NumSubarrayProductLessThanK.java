package com.douwen.top.array;

public class NumSubarrayProductLessThanK {

    public static void main(String[] args) {
        int[] nums =  {10,5,2,6};
        int k = 100;
        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums,int k){
        int product = 1;
        int p1 = 0;
        int p2 = 0;
        int result = 0;
        for(;p2 < nums.length; p2 ++){
            product *= nums[p2];
            while(p1 <= p2 && product >= k){
                product /= nums[p1 ++];
            }
            result += p2 >= p1 ? p2 - p1 + 1 : 0;
        }
        return result;
    }
}
