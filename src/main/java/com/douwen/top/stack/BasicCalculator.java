package com.douwen.top.stack;

import java.util.Stack;

public class BasicCalculator {

    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        int i = basicCal(s);
        System.out.println(i);
    }

    public static int basicCal(String s){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        stack.push(sign);
        int length = s.length();
        int i = 0;
        while(i < length){
            char ch = s.charAt(i);
            switch (ch){
                case ' ':
                    i ++;
                    break;
                case '+':
                    sign = stack.peek();
                    i ++;
                    break;
                case '-':
                    sign = - stack.peek();
                    i ++;
                    break;
                case '(':
                    stack.push(sign);
                    i++;
                    break;
                case ')':
                    stack.pop();
                    i++;
                    break;
                default:
                    int num = 0;
                    while (i < length && Character.isDigit(s.charAt(i))){
                        num += num * 10 + s.charAt(i) - '0';
                        i ++;
                    }
                    result += sign*num;

            }
        }
        return result;
    }
}
