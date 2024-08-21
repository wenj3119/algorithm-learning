package com.douwen.top.string;

public class CountSubstrings {

    public static void main(String[] args) {
        String s = "abcba";
        int i = countSubstrings(s);
        System.out.println(i);
    }

    public static int countSubstrings(String s){
        if(s == null || s.isEmpty()){
            return 0;
        }
        int result = 0;
        for(int i = 0; i < s.length(); i ++){
            result += countPalindrome(s,i,i);
            result += countPalindrome(s,i,i + 1);
        }
        return result;
    }
    //获取每个字符串，从起始到结束的回文字符串个数
    private static int countPalindrome(String s,int start,int end){
        int count = 0;
        while(start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            count ++;
            start --;
            end ++;
        }
        return count;
    }
}
