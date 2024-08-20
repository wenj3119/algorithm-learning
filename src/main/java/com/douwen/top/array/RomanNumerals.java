package com.douwen.top.array;

import java.util.HashMap;
import java.util.Map;

public class RomanNumerals {

    public static void main(String[] args) {
        int result = romanToInt("MCMXCIV");
        System.out.println("result: " + result);

        String resultS = intToRoman(111);
        char c = resultS.charAt(1);
        StringBuffer sb = new StringBuffer();
        sb.append(c);
        System.out.println("resultS: " + resultS);
    }
    static Map<Character,Integer> values = new HashMap<>(){{
       put('I',1);
       put('V',5);
       put('X',10);
       put('L',50);
       put('C',100);
       put('D',500);
       put('M',1000);
    }};


    public static int romanToInt(String s){
        int result = 0;
        int length = s.length();
        for(int i = 0; i < length; i ++){

            int value = values.get(s.charAt(i));
            if(i < length - 1 && value < values.get(s.charAt(i + 1))){
                result -= value;
            }else{
                result += value;
            }
        }
        return result;
    }
    static int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] symbols = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

    public static String intToRoman(int num){
        StringBuffer result = new StringBuffer();
        for(int i = 0 ; i < nums.length; i ++){
            int value = nums[i];
            String symbol = symbols[i];
            while (num >= value){
                num -= value;
                result.append(symbol);
            }
            if(num == 0){
                break;
            }
        }
        return result.toString();
    }

}
