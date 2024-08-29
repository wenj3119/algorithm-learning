package com.douwen.top.hash;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {

    public static void main(String[] args) {

    }


    public boolean isAnagram(String str1,String str2){
        if(str1.length() != str2.length()){
            return false;
        }
        Map<Character,Integer> counts = new HashMap<>();
        for(char ch : str1.toCharArray()){
            counts.put(ch,counts.getOrDefault(ch,0)+1);
        }
        for(char ch : str2.toCharArray()){
            if(!counts.containsKey(ch) || counts.get(ch) == 0){
                return false;
            }
            counts.put(ch,counts.get(ch) -1);
        }
        return true;
    }
}
