package com.douwen.top.string;

public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s){
        int result = 0;
        int length = s.length();
        if(length == 0){
            return result;
        }
        int[] counts = new int[256];
        int countTemp = 0;
        int low = -1;
        for(int i = 0; i < length; i ++){
            counts[s.charAt(i)]++;
            if(counts[s.charAt(i)] == 2){
                countTemp ++;
            }
            while(countTemp > 0){
                low ++;
                counts[s.charAt(low)] --;
                if(counts[s.charAt(low)] == 1){
                    countTemp --;
                }
            }
            result = Math.max(i - low, result);
        }
        return result;
    }
}
