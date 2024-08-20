package com.douwen.top.array;

import java.util.HashMap;
import java.util.Map;

public class ZShapeTrans {
    public static void main(String[] args) {
        String s = zShapeTrans("PAYPALISHIRING", 4);
        System.out.println(s);
        Map<String,String> map = new HashMap<>();
        for(Map.Entry<String,String> m : map.entrySet()){

        }
    }

    //Z字反转字符串
    public static String zShapeTrans(String s,int numRows){
        int length = s.length();
        if(length == 0 || length == 1 || numRows == 0 || numRows == 1){
            return s;
        }
        //首先判断出字符周期变化
        int t = 2 * numRows - 2;
        //先创建一个二维数组存放数据 行数 numRows,列数 (length + t - 1) / t * (numRows -1);
        int c = (length + t - 1) / t * (numRows - 1);
        char[][] chars = new char[numRows][c];
        for(int i = 0, x = 0, y = 0; i < length; i ++){
            chars[x][y] = s.charAt(i);
            if(i % t < (numRows - 1)){
                x ++;
            }else{
                x --;
                y ++;
            }
        }
        StringBuffer result = new StringBuffer();
        for(char[] chs : chars){
            for(char ch : chs){
                if(ch != 0){
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }
}
