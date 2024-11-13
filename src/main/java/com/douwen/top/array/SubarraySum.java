package com.douwen.top.array;

import java.util.*;
import java.util.stream.Collectors;

public class SubarraySum {

    public static void main(String[] args) {
        int nums[] = {1,1,1,2,2,3,5,5,5,5};
        int k = 2;
        //System.out.println(subarraySum(nums,k));
        System.out.println(Arrays.toString(subJdArraySum(nums, k)));
        //System.out.println(testJD());

    }

    public static int testJD(){
        int a = 1,b = 1;
        try{
            int c = a/0;
        }catch (Exception e){
            return a + b;
        }finally {
            a = 2;
            b = 2;
        }
        return a + b;
    }

    public static int subarraySum(int[] nums,int k){
        Map<Integer,Integer> sumToCount = new HashMap<>();
        sumToCount.put(0,1);
        int sum = 0;
        int result = 0;
        for(int num : nums){
            sum += num;
            // sum - k  和之前的sum 相等了，说明当前又增加了一个和为k的子数组
            result += sumToCount.getOrDefault(sum - k,0);
            sumToCount.put(sum,sumToCount.getOrDefault(sum,0) + 1);
        }
        return result;
    }

    public static int[] subJdArraySum(int[] nums, int k){
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }

        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i],map.getOrDefault(nums[i],1) + 1);
        }

        PriorityQueue<Map.Entry<Integer,Integer>> queue = new PriorityQueue<>(k,Comparator.comparingInt(Map.Entry::getValue));
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            queue.offer(entry);
            if(queue.size() > k){
                queue.poll();
            }
        }
        int[] result = new int[k];
        for(int i = k - 1; i >= 0; i --){
            result[i] = queue.poll().getKey();
        }
        return result;

    }

    public static int[] subKArraySum(int[] nums, int k){
        if(nums == null || nums.length == 0 || k == 0){
            return new int[0];
        }
        Map<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i ++){
            map.put(nums[i],map.getOrDefault(nums[i],1) + 1);
        }
        LinkedHashMap<Integer, Integer> collect = map.entrySet().stream()
                .sorted(Map.Entry.<Integer,Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e2, LinkedHashMap::new));
        int[] result = new int[k];
        int i = 0;
        for(Map.Entry<Integer,Integer> entry : collect.entrySet()){
            if(i == k){
                break;
            }
            result[i] = entry.getKey();
            i ++;
        }
        return result;
    }


    public static int findMaxLength(int[] nums){
        Map<Integer,Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0,-1);
        int sum = 0;
        int result = 0;
        for(int i = 0; i < nums.length; i ++){
            sum += nums[i] == 0 ? -1 : 1;
            if(sumToIndex.containsKey(sum)){
                result = Math.max(result,i - sumToIndex.get(sum));
            }else{
                sumToIndex.put(sum,i);
            }
        }
        return result;
    }
}
