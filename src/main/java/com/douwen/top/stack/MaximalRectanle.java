package com.douwen.top.stack;

import java.util.Stack;

public class MaximalRectanle {

    public int maximalRectanle(char[][] matrix){
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return 0;
        }
        int[] heights = new int[matrix[0].length];
        int maxArea = 0;
        for(char[] row : matrix){
            for(int i = 0; i < row.length; i ++){
                if(row[i] == '0'){
                    heights[i] = 0;
                }else{
                    heights[i] ++;
                }
            }
            maxArea = Math.max(maxArea,largestRectangleArea(heights));
        }
        return maxArea;
    }



    public int largestRectangleArea(int[] heights){
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int maxArea = 0;
        for(int i = 0; i < heights.length;i ++){
            while (stack.peek() != -1 && heights[stack.peek()] >= heights[i]){
                int height = heights[stack.pop()];
                int width = i - stack.peek() - 1;
                maxArea = Math.max(maxArea,height * width);
            }
            stack.push(i);
        }
        while (stack.peek() != -1){
            int height = heights[stack.pop()];
            int width = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea,height * width);
        }
        return maxArea;
    }

}
