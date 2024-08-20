package com.douwen.top.integer;

/**
 * @Author wenjun
 * @Date 2024/7/25
 * @Describe
 */
public class Division {

    public static void main(String[] args) {
        System.out.println(divide(15,2));
    }

    private static int divide(
            int dividend,
            int divisor
    ){
        if(dividend == 0x8000000 && divisor == -1){
            return Integer.MAX_VALUE;
        }
        int negative = 2;
        if(dividend > 0){
            negative --;
            dividend = - dividend;
        }
        if(divisor > 0){
            negative --;
            divisor = - divisor;
        }
        int result = divideCore(dividend,divisor);
        return negative == 1 ? -result : result;
    }

    private static int divideCore(
            int dividend,
            int divisor
    ){
        int result = 0;
        while (dividend <= divisor){
            int value = divisor;
            int quotient = 1;
            while (value >= 0xc0000000 && dividend <= value + value){
                quotient += quotient;
                value += value;
            }
            result += quotient;
            dividend -= value;
        }
        return result;
    }

}
