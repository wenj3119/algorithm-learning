package com.douwen.top.test;

public class ThreadStateExample {

    final static Object object = new Object();
    public static void main(String[] args) {
        Thread thread1 = new Thread(new RunnableTask());

        Thread thread2 = new Thread(new RunnableTask1());

        // Print initial state (should be NEW)
        //System.out.println("Thread State (initial): " + thread1.getState());

        // Start the thread
        thread1.start();
        thread2.start();

        // Print state after starting (should be RUNNABLE)
        //System.out.println("Thread State (after start): " + thread1.getState());

        // Wait for the thread to finish

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Print final state (should be TERMINATED)
        //System.out.println("Thread State (after completion): " + thread1.getState());

    }

    static class RunnableTask implements Runnable {
        @Override
        public void run() {
            try {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + "before await: " + Thread.currentThread().getState());
                    object.wait();
                    System.out.println(Thread.currentThread().getName() + "after await: " + Thread.currentThread().getState());
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    static class RunnableTask1 implements Runnable{
        @Override
        public void run(){
            try {
                synchronized (object){
                    System.out.println(Thread.currentThread().getName() + "before notify: " + Thread.currentThread().getState());
                    object.notify();
                    System.out.println(Thread.currentThread().getName() + "after notify: " + Thread.currentThread().getState());
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
