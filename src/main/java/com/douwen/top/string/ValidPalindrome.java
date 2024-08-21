package com.douwen.top.string;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "sdggdsh";
        boolean b = validPalindrome(s);
        System.out.println(b);
    }

    public static boolean validPalindrome(String s){
        int start = 0;
        int end = s.length() - 1;
        for(; start < s.length()/2; start ++, end --){
            if(s.charAt(start) != s.charAt(end)){
                break;
            }
        }
        return start == s.length() /2 || isPalindrome(s,start,end - 1) || isPalindrome(s,start + 1,end);
    }
    private static boolean isPalindrome(String s, int start ,int end){
        while(start < end){
            if(s.charAt(start) != s.charAt(end)){
                break;
            }
            start ++;
            end --;
        }
        return start >= end;
    }

}
