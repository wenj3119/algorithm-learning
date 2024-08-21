package com.douwen.top.string;

public class IsPalindrome {

    public static void main(String[] args) {
        String s = "sadg gasdg";
        System.out.println(isPalindrome(s));
    }

    public static boolean isPalindrome(String s){
        int i = 0;
        int j = s.length() - 1;
        while(i < j){
            char ch1 = s.charAt(i);
            char ch2 = s.charAt(j);
            if(!Character.isLetterOrDigit(ch1)){
                i ++;
            }else if(!Character.isLetterOrDigit(ch2)){
                j --;
            }else{
                ch1 = Character.toLowerCase(ch1);
                ch2 = Character.toLowerCase(ch2);
                if(ch1 != ch2){
                    return false;
                }
            }
            i ++;
            j --;
        }
        return true;
    }
}
