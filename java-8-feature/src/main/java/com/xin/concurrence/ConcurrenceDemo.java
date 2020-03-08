package com.xin.concurrence;

import java.util.WeakHashMap;

/**
 * 并发编程学习了解
 *
 * @author Y1nzm
 * @Date 2019/12/24
 */
public class ConcurrenceDemo {
    public static void main(String[] args) {
//        WeakReference
        new WeakHashMap();
//        ConcurrentHashMap<Object, Object> concurrentHashMap = new ConcurrentHashMap<>();
        TestRunnable tr = new TestRunnable();

        // main 线程中执行
        tr.run();

        /**
         * result:
         * execute ...
         * threadname = main
         * execute ...
         * threadname = Thread-0
         */

        new Thread(tr).start();

        // execute in main thread
        new Thread(tr).run();
    }
}

class TestRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("execute ...");
        String threadname = Thread.currentThread().getName();
        System.out.println("threadName = " + threadname);
    }
}
