package com.douwen.top.array;

public class TwoSum {

    public static void main(String[] args) {
        int[] nums = {1,2,4,6,10};
        int[] ints = twoSum(nums, 8);
        System.out.println(ints);
    }

    public static int[] twoSum(int[] numbers,int target){
        int p1 = 0;
        int p2 = numbers.length - 1;
        while(p1 < p2 && numbers[p1] + numbers[p2] != target){
            if(numbers[p1] + numbers[p2] > target){
                p2 --;
            }else{
                p1 ++;
            }
        }
        return new int[]{p1,p2};
    }
}
