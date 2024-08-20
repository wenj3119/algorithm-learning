package com.douwen.top.integer;

/**
 * @Author wenjun
 * @Date 2024/7/25
 * @Describe
 */
public class Binary {

    public static String addBinary(
            String a,
            String b
    ){
        StringBuffer result = new StringBuffer();
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        while (i >=0 || j >= 0){
            int digitA = i >= 0 ? a.charAt(i --) - '0' : 0;
            int digitB = j >= 0 ? b.charAt(j --) - '0' : 0;
            int sum = digitA + digitB + carry;
            carry = sum >= 2 ? 1 : 0;
            sum = sum >= 2 ? sum - 2 : sum;
            result.append(sum);
        }
        return result.reverse().toString();
    }
}
