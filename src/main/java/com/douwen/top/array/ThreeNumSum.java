package com.douwen.top.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeNumSum {

    public static void main(String[] args) {
        int[] nums = {-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeSum(nums);
        for(List<Integer> list : lists){
            for(Integer i : list){
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        Arrays.sort(nums);
        if(nums[length - 1] == 0 && nums[0] == 0 && nums[length - 2] == 0){
            List<Integer> zList = new ArrayList<>();
            zList.add(0);
            zList.add(0);
            zList.add(0);
            result.add(zList);
            return result;
        }
        for(int i = 0; i < nums.length - 2; i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int temp = nums[i];
            int start = i + 1;
            int end = nums.length - 1;
            boolean isAllZero = false;
            while(start < end){
                int sum = nums[start] + temp + nums[end];
                if(isAllZero && temp == 0 && nums[start] == 0 && nums[end] == 0){
                    start++;
                    continue;
                }
                if(sum == 0){
                    boolean isExist = false;
                    for(List<Integer> exist : result){
                        if(exist.get(0) == temp && exist.get(1) == nums[start] && exist.get(2) == nums[end]){
                            isExist = true;
                            break;
                        }
                    }
                    if(isExist){
                        start++;
                        continue;
                    }
                    if(temp == 0 && nums[start] == 0 && nums[end] == 0){
                        isAllZero = true;
                    }
                    List<Integer> zList = new ArrayList<>();
                    zList.add(temp);
                    zList.add(nums[start]);
                    zList.add(nums[end]);
                    result.add(zList);
                    start ++;
                }else if(sum > 0){
                    end --;
                }else{
                    start ++;
                }
            }

        }
        return result;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int length = nums.length;
        int start = 0;
        int mid = start + 1;
        int end = start + 2;
        Arrays.sort(nums);
        while(start + 2 < length){

            while(end < length){
                addResult(nums,start,mid,end,result);
                end ++;
            }
            if(mid + 2 < length){
                end = mid + 2;
                mid ++;
            }else{
                mid = start + 2;
                end = mid + 1;
                start ++;
            }
        }
        return result;
    }

    public void addResult(int[] nums,int start,int mid, int end,List<List<Integer>> result){
        if(nums[start] + nums[mid] + nums[end] == 0){
            for(List<Integer> exist : result){
                if(exist.get(0) == nums[start] && exist.get(1) == nums[mid] && exist.get(2) == nums[end]){
                    return;
                }
            }
            List<Integer> zList = new ArrayList<>();
            zList.add(nums[start]);
            zList.add(nums[mid]);
            zList.add(nums[end]);
            result.add(zList);
        }
    }
}
