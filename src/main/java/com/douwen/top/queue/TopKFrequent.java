package com.douwen.top.queue;

import java.util.*;

public class TopKFrequent {


    public List<Integer> topKFrequent(int[] nums, int k){
        Map<Integer,Integer> numToCount = new HashMap<>();
        for(int num : nums){
            numToCount.put(num,numToCount.getOrDefault(num,0) + 1);
        }
        Queue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>((e1,e2) -> e1.getValue() - e2.getValue());
        for(Map.Entry<Integer,Integer> entry : numToCount.entrySet()){
            if(minHeap.size() < k){
                minHeap.offer(entry);
            }else{
                if(entry.getValue() > minHeap.peek().getValue()){
                    minHeap.poll();
                    minHeap.offer(entry);
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        for(Map.Entry<Integer,Integer> entry : minHeap){
            result.add(entry.getKey());
        }
        return result;
    }
}
