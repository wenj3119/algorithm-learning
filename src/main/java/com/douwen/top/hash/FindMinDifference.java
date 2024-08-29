package com.douwen.top.hash;

import java.util.List;

public class FindMinDifference {

    public int findMinDifference(List<String> timePoints){
        //如果时间组个数都大于每天的分钟数，则最小时间差为0
        if(timePoints.size() > 1440){
            return 0;
        }
        boolean[] minuteFlags = new boolean[1440];
        for(String time : timePoints){
            //将时间组的时间转换为分钟数
            String[] t = time.split(":");
            int min = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            // 如果为true，则说明有两个一样的时间，则时间差为0
            if(minuteFlags[min]){
                return 0;
            }
            minuteFlags[min] = true;
        }
        return helper(minuteFlags);
    }

    private int helper(boolean[] minuteFlags){
        int minDiff = minuteFlags.length - 1;
        int prev = -1;
        int first = minuteFlags.length - 1;
        int last = -1;
        for(int i = 0; i < minuteFlags.length; i ++){
            if(minuteFlags[i]){
                if(prev >= 0){
                    minDiff = Math.min(i - prev,minDiff);
                }
                prev = i;
                first = Math.min(i,first);
                last = Math.max(i,last);
            }
        }
        minDiff = Math.min(first + minuteFlags.length - last, minDiff);
        return minDiff;
    }

}
