package com.douwen.top.test;

import java.lang.instrument.Instrumentation;

public class Agent {

    private static Instrumentation instrumentation;

    // premain 方法会在代理启动时调用
    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object obj) {
        return instrumentation.getObjectSize(obj);
    }
}
