package com.douwen.top.interval;

public class Dividend {

    public static void main(String[] args) {
        int divide = divide(15, 2);
        System.out.println(divide);
    }

    public static int divide(int dividend, int divisor){
        //考虑溢出情况（被除数是最小int整数，除数是-1会溢出）
        if(dividend == 0x80000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        //用于判断结果的正负号，如果等于1则结果为负数
        int negative = 2;
        if(dividend > 0){
            negative --;
            dividend = -dividend;
        }
        if(divisor > 0){
            negative --;
            divisor = -divisor;
        }
        int result = divideCore(dividend,divisor);
        return negative == 1 ? -result : result;
    }

    private static int divideCore(int dividend,int divisor){
        int result = 0;
        //判断被除数是否小于等于除数，如果是，则继续循环
        while(dividend <= divisor){
            //将除数赋值给变量value用于计算可以进行多轮减法
            int value = divisor;
            //每进行一轮减法，被减去的数会翻倍，则将结果翻倍
            int quotient = 1;
            // 0xc0000000 是 -2^30,被除数小于等于2被的除数
            while(value >= 0xc0000000 && dividend <= value + value){
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }
}
