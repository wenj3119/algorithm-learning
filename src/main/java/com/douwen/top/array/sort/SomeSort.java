package com.douwen.top.array.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SomeSort {

    //冒泡排序
    public static void bubbleSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    //插入排序
    public static void insertSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > temp) {
                arr[j + 1] = arr[j];
                j --;
            }
            arr[j + 1] = temp;
        }
    }

    //快速排序
    public static void quickSort(int[] arr, int left, int right){
        if(arr == null || arr.length < 2){
            return;
        }
        int start = left;
        int end = right;
        int key = arr[start];
        while(start < end){
            while(start < end && arr[end] >= key){
                end --;
            }
            if(arr[end] <= key){
                int temp = arr[end];
                arr[end] = arr[start];
                arr[start] = temp;
            }
            while(start < end && arr[start] <= key){
                start ++;
            }
            if(arr[start] >= key){
                int temp = arr[start];
                arr[start] = arr[end];
                arr[end] = temp;
            }
        }
        if(start > left){
            quickSort(arr, left, start - 1);
        }
        if(end < right){
            quickSort(arr, end + 1, right);
        }
    }

    //希尔排序
    public static void shellSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        int gap = arr.length / 3 + 1;
        while (gap != 1) {
           shellInsertSort(arr,gap);
           gap = gap / 3 + 1;
        }
        shellInsertSort(arr, gap);
    }
    private static void shellInsertSort(int[] arr, int gap) {
        for (int i = gap; i < arr.length; i++) {
            if (arr[i] < arr[i - gap]) {
                int j;
                int x = arr[i];
                arr[i] = arr[i - gap];
                for (j = i - gap; j >= 0 && x < arr[j]; j = j - gap) {
                    arr[j + gap] = arr[j];
                }
                arr[j + gap] = x;
            }
        }
    }

    //归并排序
    public static void mergeSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        sort(arr,0,arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if(left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(arr,left,mid);
        sort(arr,mid+1,right);
        merge(arr,left,mid,right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int[] tempArr = new int[arr.length];
        int center = mid + 1;
        int third = left;
        int temp = left;
        while (left <= mid && center <= right) {
            if (arr[left] <= arr[center]) {
                tempArr[third ++] = arr[left ++];
            }else{
                tempArr[third ++] = arr[center++];
            }
        }
        while(center <= right){
            tempArr[third++] = arr[center++];
        }
        while (left <= mid){
            tempArr[third++] = arr[left++];
        }
        while (temp <= right){
            arr[temp] = tempArr[temp ++];
        }
    }

    //桶排序算法
    public static void bucketSort(int[] arr) {
        if (arr == null || arr.length < 2) {}
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            min = Math.min(arr[i], min);
            max = Math.max(arr[i], max);
        }
        int bucketNum = (max - min) / arr.length + 1;
        List<List<Integer>> bucketArr = new ArrayList<>();
        for(int i = 0; i < bucketNum; i ++){
            bucketArr.add(new ArrayList<>());
        }
        for(int i = 0; i < arr.length; i ++){
            int num = (arr[i] - min)/arr.length;
            bucketArr.get(num).get(arr[i]);
        }
        for(int i = 0; i < bucketArr.size(); i ++){
            Collections.sort(bucketArr.get(i));
        }
        List<Integer> resultList = new ArrayList<>();
        for(int i = 0; i < bucketArr.size(); i ++){
            resultList.addAll(bucketArr.get(i));
        }
        for (int i = 0; i < resultList.size(); i++) {
            arr[i] = resultList.get(i);
        }
    }

    //基数排序
    public static void radixSort(int[] arr, int radix) {
        if (arr == null || arr.length < 2) {
            return;
        }
        double max = Math.pow(10, radix);
        int n = 1;
        int k = 0;
        int length = arr.length;
        int[][] bucket = new int[10][length];
        int[] order = new int[length];
        while (n < max){
            for(int num : arr){
                int digit = (num / n) % 10;
                bucket[digit][order[digit]++] = num;
            }
            for(int i = 0; i < length; i ++){
                if(order[i] != 0){
                    for(int j = 0; j < order[i]; j ++){
                        arr[k++] = bucket[i][j];
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
        }
    }
}
