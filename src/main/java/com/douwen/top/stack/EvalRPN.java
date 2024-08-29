package com.douwen.top.stack;

import java.util.Stack;

public class EvalRPN {


    public int evalRPN(String[] tokens){
        Stack<Integer> stack = new Stack<>();
        for(String token : tokens){
            switch(token){
                case "+":
                case "-":
                case "*":
                case "/":
                    int num1 = stack.pop();
                    int num2 = stack.pop();
                    //需要注意传值顺序和方法对应上，因为减法和除法会有区别
                    stack.push(calculate(num2,num1,token));
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
    private int calculate(int num2, int num1, String token){
        switch(token){
            case "+":
                return num1 + num2;
            case "-":
                return num2 - num1;
            case "*":
                return num2 * num1;
            case "/":
                return num2 / num1;
            default:
                return 0;
        }
    }
}
