package com.douwen.top.slidingwindow;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] maxtix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> integers = spiralMatrix(maxtix);
        integers.forEach(
                i ->{
                    System.out.println(i);
                }
        );

    }

    public static List<Integer> spiralMatrix(int[][] matrix){
        List<Integer> result = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return result;
        }
        int rows = matrix.length;
        int columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while (left <= right && top <= bottom){
            for(int column = left; column <= right; column ++){
                result.add(matrix[top][column]);
            }
            for(int row = top + 1; row <= bottom; row ++){
                result.add(matrix[row][right]);
            }
            if(left < right && top < bottom){
                for(int column = right - 1; column > left; column --){
                    result.add(matrix[bottom][column]);
                }
                for(int row = bottom; row > top; row --){
                    result.add(matrix[row][left]);
                }
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }

        return result;
    }
}
