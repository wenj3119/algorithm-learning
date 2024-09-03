package com.douwen.top.map;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public  class MyMap {

    public static class Test {
        private int a ;
        private int b;
        private static int c;
        public class A{

        }
    }

    public static  class Test1{
        private A a;
        private A.B.C c;
        public class A {
            public class B{
                public class C{

                }
            }
        }
        public Test1(){

        }
        public void test1(){
             class TestI{
                public  void test(){
                    System.out.println("asdf test1");
                }
            }
            new TestI().test();
        }
    }
    public static void main(String[] args) throws Exception{

        Map<Integer,Integer> map = new ConcurrentHashMap<>();
        //map.put(null,null);
        //System.out.println(map.get(null));
        Map<Integer,Integer> map1 = new HashMap<>();
        map1.put(null,null);
        System.out.println(map1.get(null));

        Map<Integer,Integer> hashTable = new Hashtable<>();
        hashTable.put(null,1);
        System.out.println(hashTable.get(null));
    }
    public static synchronized void test1(){
        class TestI{
            public void test(){
                System.out.println("asdf test1");
            }
        }
        new TestI().test();
    }
}
