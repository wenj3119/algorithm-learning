package com.douwen.top.map;

public class MyText {
    public static void main(String[] args) {
        MyText text = new MyText();
        text.test();
    }
    public void test() {
        MyMap.Test1 map = new MyMap.Test1();
        map.test1();
        int a = 1;
        if(a > 0){
            System.out.println("a 大于 0");
        }else if(a == 1){
            System.out.println("a 等于 1");
        }else if(a > -1){
            System.out.println("a 大于 -1");
        }else{
            System.out.println(" anther ");
        }
    }
}
