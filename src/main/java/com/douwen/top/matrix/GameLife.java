package com.douwen.top.matrix;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameLife {
    public static void main(String[] args) {
        Map<Character, List<Integer>> map = new HashMap<>();
        for(Map.Entry<Character,List<Integer>> entry : map.entrySet()){
            List<Integer> value = entry.getValue();
        }
        String aaa = "";
        aaa.toCharArray();

        
    }

    public static void gameOfLife(int[][] board){
        if(board == null || board.length == 0 || board[0].length == 0){
            return;
        }
        int[] neiBoards = {0,1,-1};
        int rows = board.length;
        int cols = board[0].length;
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col ++){
                int neiLiveBoards = 0;
                for(int i = 0; i < 3; i ++){
                    for(int j = 0; j < 3; j ++){
                        if(!(neiBoards[i] == 0 && neiBoards[j] == 0)){
                            int r = row + neiBoards[i];
                            int c = col + neiBoards[j];

                            if((r < rows && r >=0) && (c < cols && c >=0) && (Math.abs(board[r][c]) == 1)){
                                neiLiveBoards +=1;
                            }
                        }

                    }
                }
                if(board[row][col] == 1 && (neiLiveBoards < 2 || neiLiveBoards > 3)){
                    board[row][col] = -1;
                }

                if(board[row][col] == 0 && neiLiveBoards == 3){
                    board[row][col] = 2;
                }

            }
        }
        for(int row = 0; row < rows; row ++){
            for(int col = 0; col < cols; col ++){
                if(board[row][col] <= 0){
                    board[row][col] = 0;
                }else{
                    board[row][col] = 1;
                }
            }
        }
    }
}
