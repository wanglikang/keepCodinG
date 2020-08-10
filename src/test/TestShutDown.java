package test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 2020/4/1 11:24
 * author:WLK
 */

public class TestShutDown {

    static void asynExecuteOne() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new  Runnable() {
            public void run() {
                System.out.println("--async execute one ---");
            }
        });
    }

    static void asynExecuteTwo() {
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new  Runnable() {
            public void run() {
                System.out.println("--async execute two ---");
            }
        });
    }


    public static void main(String[] args) {
        //(1)同步执行
        System.out.println("---sync execute---");
        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(new  Runnable() {
            public void run() {
                System.out.println("--async execute one ---");
            }
        });
        executor.execute(new  Runnable() {
            public void run() {
                System.out.println("--async execute one ---");
            }
        });
//        //(2)异步执行操作one
//        asynExecuteOne();
//        //(3)异步执行操作two
//        asynExecuteTwo();
        //(4)执行完毕
        System.out.println("---execute over---");
    }
}
