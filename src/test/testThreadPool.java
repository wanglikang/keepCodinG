package  test;
import org.junit.Test;

import java.util.concurrent.*;

/**
 * 2020/4/1 9:23
 * author:WLK
 */

public class testThreadPool {
    public static void main(String[] args) {
        Runnable r =new Runnable() {
            @Override
            public void run() {
                System.out.println("running...");
                try {
                    Thread.sleep(2*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName());
                throw new RuntimeException("自定义运行时异常");

            }
        };


         System.out.println(System.currentTimeMillis()/1000);
//        ExecutorService pool = Executors.newFixedThreadPool(3);
//        ExecutorService pool = Executors.newSingleThreadExecutor();

        ThreadPoolExecutor pool2 = new ThreadPoolExecutor(1,
                3, 3, TimeUnit.SECONDS, new LinkedBlockingQueue<>(5),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        System.out.println("产生了工作thread");
                        Thread workerThread = new Thread(r) ;
                        workerThread.setUncaughtExceptionHandler((t,e)->{
                            System.out.println("当前线程:"+Thread.currentThread().getName()+" 发生异常");
                            System.out.println(t + ":" + e.toString());
                        });
                        return workerThread;
                    }
        }){
            @Override
            protected void beforeExecute(Thread t, Runnable r){
                System.out.println(Thread.currentThread().getName()+" before execute");
            }

            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("after execute");
                try {
                    if(t!=null) {
                        throw new Exception("自定义的afterExecute 异常:"+t.toString());
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        };

        for(int i = 0;i<5;i++) {
            pool2.execute(r);
//            Future<?> tt = pool.submit(r);
            System.out.println("提交成功。。");
            try {
                Thread.sleep(10 * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        Executors.newCachedThreadPool();
        System.out.println("结束。。。");
        System.out.println(System.currentTimeMillis()/1000);
    }


}
