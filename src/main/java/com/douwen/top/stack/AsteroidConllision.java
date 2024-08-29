package com.douwen.top.stack;

import java.util.Stack;

public class AsteroidConllision {

    public int[] asteroidConllision(int[] asteroids){
        Stack<Integer> stack = new Stack<>();
        for(int as : asteroids){
            //当栈不为空并且栈顶数据大于0，且栈顶数据小于当前数据时，将栈顶出栈，栈顶数据爆炸
            while(!stack.isEmpty() && stack.peek() > 0 && stack.peek() < -as){
                stack.pop();
            }
            //当栈不为空，并且当前数据是负数，并且栈顶数据和当前数据是相反数，则将数据出栈，并且当前数据不入栈，两个都爆炸
            if(!stack.empty() && as < 0 && stack.peek() == -as){
                stack.pop();
            }else if(as > 0 ||stack.isEmpty() || stack.peek() < 0){
                stack.push(as);
            }
        }
        return stack.stream().mapToInt(i -> i).toArray();
    }
}
