package com.douwen.top.array;

import java.util.Deque;
import java.util.LinkedList;

public class CatchRainwater {

    public static void main(String[] args) {
        int[] nums = {0,1,0,2,1,0,1,3,2,1,2,1};
        int result = doublePointerTrap(nums);
        System.out.println("result: " + result);
    }

    //动态规划
    public static int trap(int[] height) {
        int length = height.length;
        int result = 0;
        int[] leftMax = new int[length];
        leftMax[0] = height[0];
        for(int i = 1; i < length; i ++){
            leftMax[i] = Math.max(leftMax[i - 1],height[i]);
        }
        int[] rightMax = new int[length];
        rightMax[length - 1] = height[length - 1];
        for(int i = length - 2; i >=0; i --){
            rightMax[i] = Math.max(rightMax[i + 1],height[i]);
        }
        for(int i = 0 ;i < length; i ++){
            result += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return result;
    }
    //单调栈法
    public static int stackTrap(int[] height){
        int length = height.length;
        int result = 0;
        Deque<Integer> stack = new LinkedList<>();
        for(int i = 0 ; i < length; i ++){
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                if(stack.isEmpty()){
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left],height[i]) - height[top];
                result += currWidth * currHeight;
            }
            stack.push(i);
        }
        return result;
    }

    //双指针法
    public static int doublePointerTrap(int[] height){
        int result = 0;
        int length = height.length;

        int left = 0;

        int right = length - 1;

        int leftMax = 0;

        int rightMax = 0;

        while (left < right){
            leftMax = Math.max(leftMax,height[left]);
            rightMax = Math.max(rightMax,height[right]);

            if(height[left] < height[right]){
                result += leftMax - height[left];
                left ++;
            }else{
                result += rightMax - height[right];
                right --;
            }
        }
        return result;

    }

}
