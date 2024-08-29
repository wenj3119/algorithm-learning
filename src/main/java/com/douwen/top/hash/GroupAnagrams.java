package com.douwen.top.hash;

import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs){
        Map<String,List<String>> groups = new HashMap<>();
        for(String str : strs){
            char[] chars =  str.toCharArray();
            Arrays.sort(chars);
            String temp = new String(chars);
            groups.putIfAbsent(temp,new LinkedList<>());
            groups.get(temp).add(str);
        }
        return new LinkedList<>(groups.values());
    }
}
