package com.douwen.top.stack;

import java.util.Stack;

public class LargestRectangleArea {

    public static void main(String[] args) {
        int[] heights = {3,2,5,4,6,1,4,2};
        int i = largestRectangleArea2(heights);
        System.out.println(i);
    }

    //解法一： 蛮力法
    public static int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            int min = heights[i];
            for (int j = i; j < heights.length; j++) {
                min = Math.min(min, heights[j]);
                int area = min * (j - i + 1);
                maxArea = Math.max(area, maxArea);
            }
        }
        return maxArea;
    }

    // 分治法
    public static int largestRectangleArea1(int[] heights) {
        return helper(heights, 0, heights.length);
    }

    private static int helper(int[] heights, int start, int end) {
        if (start == end) {
            return 0;
        }
        if (start + 1 == end) {
            return heights[start];
        }
        //先求出最小下标
        int minIndex = start;
        for (int i = start + 1; i < end; i++) {
            if (heights[i] < heights[minIndex]) {
                minIndex = i;
            }
        }
        //求出面积
        int area = (end - start) * heights[minIndex];
        //求出最小矩形左边面积
        int left = helper(heights, start, minIndex);
        //求出最小矩形右边面积
        int right = helper(heights, minIndex + 1, end);
        //比较最大的面积然后返回
        area = Math.max(area, left);
        return Math.max(area, right);
    }

    //单调栈法
    public static int largestRectangleArea2(int[] heights){
        //栈中存放数组下标
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int areaMax = 0;
        for(int i = 0; i < heights.length; i ++){
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                areaMax = Math.max(areaMax,height * width);
            }
            stack.push(i);
        }
        while(stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            areaMax = Math.max(areaMax,height * width);
        }
        return areaMax;
    }
}
