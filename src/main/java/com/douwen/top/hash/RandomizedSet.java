package com.douwen.top.hash;

import java.util.*;

public class RandomizedSet {
    Map<Integer,Integer> numToLocation;
    List<Integer> nums;
    public RandomizedSet(){
        numToLocation = new HashMap<>();
        nums = new ArrayList<>();
    }
    public boolean insert(int val){
        if(numToLocation.containsKey(val)){
            return false;
        }
        numToLocation.put(val,nums.size());
        nums.add(val);
        return true;
    }
    public boolean remove(int val){
        if(!numToLocation.containsKey(val)){
            return false;
        }
        int index = numToLocation.get(val);
        numToLocation.put(nums.get(nums.size() -1),index);
        numToLocation.remove(val);
        nums.set(index,nums.get(nums.size() -1));
        nums.remove(nums.size() - 1);
        return true;
    }
    public int getRandom(){
        Random random = new Random();
        int r = random.nextInt(nums.size());
        return nums.get(r);
    }
}
