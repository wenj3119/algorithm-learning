package com.douwen.top.string;

import java.util.ArrayList;
import java.util.List;

public class FindAnaGrams {

    public static void main(String[] args) {
        String s1 =  "cbaebabacd";
        String s2 = "abc";
        System.out.println(findAnagrams(s1, s2));
    }

    public static List<Integer> findAnagrams(String s1,String s2){
        List<Integer> result = new ArrayList<>();
        int s1Length = s1.length();
        int s2Length = s2.length();
        if(s1Length < s2Length){
            return result;
        }
        int[] counts = new int[26];
        for(int i = 0; i < s2Length; i ++){
            counts[s2.charAt(i) - 'a'] ++;
            counts[s1.charAt(i) - 'a'] --;
        }
        if(areAllZero(counts)){
            result.add(0);
        }
        for(int i = s2Length; i < s1Length; i ++){
            counts[s1.charAt(i) - 'a'] --;
            counts[s1.charAt(i - s2Length) - 'a'] ++;
            if(areAllZero(counts)){
                result.add(i - s2Length + 1);
            }
        }
        return result;
    }
    private static boolean areAllZero(int[] counts){
        for(int count : counts){
            if(count != 0){
                return false;
            }
        }
        return true;
    }
}
