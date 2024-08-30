package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 给你一个类：
 *
 * class FooBar {
 *   public void foo() {
 *     for (int i = 0; i < n; i++) {
 *       print("foo");
 *     }
 *   }
 *
 *   public void bar() {
 *     for (int i = 0; i < n; i++) {
 *       print("bar");
 *     }
 *   }
 * }
 * 两个不同的线程将会共用一个 FooBar 实例：
 *
 * 线程 A 将会调用 foo() 方法，而
 * 线程 B 将会调用 bar() 方法
 * 请设计修改程序，以确保 "foobar" 被输出 n 次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 1
 * 输出："foobar"
 * 解释：这里有两个线程被异步启动。其中一个调用 foo() 方法, 另一个调用 bar() 方法，"foobar" 将被输出一次。
 * 示例 2：
 *
 * 输入：n = 2
 * 输出："foobarfoobar"
 * 解释："foobar" 将被输出两次。
 *
 *
 * 提示：
 *
 * 1 <= n <= 1000
 *
 * 2024/8/14 21:10
 * author:nx
 */

public class n1115 {

    /**
     * 使用synchronized实现
     */
    class FooBar {
        private int n;

        public FooBar(int n) {
            this.n = n;
        }

        public String lock = "lock";
        public volatile int flag = 0;
        public void foo(Runnable printFoo) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                synchronized (lock) {
                    while(flag != 0){
                        lock.wait();
                    }
                    printFoo.run();
                    flag = 1;
                    lock.notify();
                }
            }
        }

        public void bar(Runnable printBar) throws InterruptedException {

            for (int i = 0; i < n; i++) {
                    synchronized (lock) {
                        while(flag != 1){
                            lock.wait();
                        }
                        printBar.run();
                        flag = 0;
                        lock.notify();
                    }

            }
        }
    }


    /**
     * 使用Lock实现
     */
    class FooBar2 {
        private int n;
        public Lock lock = new ReentrantLock();
        Condition firstStarted;
//        Condition condition2;
        public FooBar2(int n) {
            this.n = n;
            firstStarted = lock.newCondition();
//            condition2 = lock.newCondition();
        }


        public volatile int flag = 0;
        public void foo(Runnable printFoo)  {
            try {
                for (int i = 0; i < n; i++) {
                    lock.lock();
                    while(flag != 0) {
                        firstStarted.await();
                    }
                    printFoo.run();
                    flag = 1;
                    firstStarted.signal();
                    lock.unlock();

                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        public void bar(Runnable printBar) {
            try {
                for (int i = 0; i < n; i++) {
                    lock.lock();
                    while(flag != 1){
                        firstStarted.await();
                    }

                    printBar.run();
                    flag  = 0;
                    firstStarted.signal();

                    lock.unlock();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void test() {
        n1115 t = new n1115();
        n1115.FooBar2 fooBar = new FooBar2(10);
        Thread foo = new Thread(
                () -> {
                    try {
                        fooBar.foo(() -> {
                            System.out.println("foo");
                        });
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        foo.start();
        Thread bar = new Thread(
                () -> {
                    try {
                        fooBar.bar(() -> {
                            System.out.println("bar");
                        });
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                });
        bar.start();
        try {
            foo.join();
            bar.join();
            System.out.println("结束");
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}