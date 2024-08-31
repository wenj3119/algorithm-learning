package com.douwen.top.queue;

import java.util.*;

public class KSmallestPairs {

    //使用最大堆
    public List<List<Integer>> kSmallectPaires(int[] nums1, int[] nums2, int k){
        Queue<int[]> maxHeap = new PriorityQueue<>((p1, p2) -> p2[0] + p2[1] - p1[0] - p1[1]);
        for(int i = 0; i < Math.min(k,nums1.length); i ++){
            for(int j = 0; j < Math.min(k,nums2.length); j ++){
                if(maxHeap.size() >=k ){
                    int[] root = maxHeap.peek();
                    if(root[0] + root[1] > nums1[i] + nums2[j]){
                        maxHeap.poll();
                        maxHeap.offer(new int[]{nums1[i],nums2[j]});
                    }
                }else{
                    maxHeap.offer(new int[]{nums1[i],nums2[j]});
                }
            }
        }
        List<List<Integer>> result = new LinkedList<>();
        while(!maxHeap.isEmpty()){
            int[] vals = maxHeap.poll();
            result.add(Arrays.asList(vals[0],vals[1]));
        }
        return result;
    }

    //使用最小堆
    public List<List<Integer>> kSmallestPairs(int[] nums1,int[] nums2, int k){
        Queue<int[]> minHeap = new PriorityQueue<>((p1,p2)->nums1[p1[0]] +  nums2[p1[1]] -nums1[p2[0]] - nums2[p2[1]]);
        if(nums2.length > 0){
            for(int i = 0; i < Math.min(k,nums1.length); i++){
                minHeap.offer(new int[]{i,0});
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        while(k-- > 0 && !minHeap.isEmpty()){
            int[] ids = minHeap.poll();
            result.add(Arrays.asList(nums1[ids[0]],nums2[ids[1]]));
            if(ids[1] < nums2.length - 1){
                minHeap.offer(new int[]{ids[0],ids[1] + 1});
            }
        }
        return result;
    }

}
