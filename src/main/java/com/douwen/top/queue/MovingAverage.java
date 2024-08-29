package com.douwen.top.queue;

import java.util.LinkedList;
import java.util.Queue;

public class MovingAverage{
    private Queue<Integer> nums;
    private int capacity;
    private int sum;
    public MovingAverage(int size){
        nums = new LinkedList<>();
        capacity = size;
    }
    public double next(int val){
        nums.offer(val);
        sum += val;
        if(nums.size() > capacity){
            sum -= nums.poll();
        }
        return (double)sum/nums.size();
    }
}
