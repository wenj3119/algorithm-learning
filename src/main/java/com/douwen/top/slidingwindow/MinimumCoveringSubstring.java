package com.douwen.top.slidingwindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class MinimumCoveringSubstring {
    static Map<Character,Integer> ori = new HashMap<>();
    static Map<Character,Integer> cnt = new HashMap<>();
    public static void main(String[] args) {
        String s = coveringSubString("ADOBECODEBANC", "ABC");
        System.out.println("s : " + s);
    }

    public static String coveringSubString(String s, String t){
        int sLength = s.length();
        int tLength = t.length();
        if(tLength > sLength){
            return "";
        }
        for(int i = 0 ; i < tLength; i ++){
            ori.put(t.charAt(i),ori.getOrDefault(t.charAt(i),0) + 1);
        }
        int l = 0, r = -1;
        int len = Integer.MAX_VALUE, resL = -1, resR = -1;
        while (r < sLength){
            r ++;
            if(r < sLength && ori.containsKey(s.charAt(r))){
                cnt.put(s.charAt(r),cnt.getOrDefault(s.charAt(r),0) + 1);
            }
            while (check() && l < r){
                if(len > r - l + 1){
                    len = r - l + 1;
                    resL = l;
                    resR = l + len;
                }
                if(cnt.containsKey(s.charAt(l))){
                    cnt.put(s.charAt(l),cnt.getOrDefault(s.charAt(l),0) - 1);
                }
                l ++;
            }
        }

        return resL == -1 ? "": s.substring(resL,resR);
    }

    public static boolean check(){
        Iterator<Map.Entry<Character, Integer>> iterator = ori.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Character, Integer> next = iterator.next();
            Character key = next.getKey();
            Integer value = next.getValue();
            if(cnt.getOrDefault(key,0) < value){
                return false;
            }
        }
        return true;
    }
}
