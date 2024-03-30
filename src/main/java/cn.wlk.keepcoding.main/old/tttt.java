package test;

import java.util.ArrayList;

/**
 * 2020/4/4 21:16
 * author:WLK
 */

public class tttt {



}
class Demo {
    private Demo() {
        System.out.println("Demo Constructor");
    }
    private static class Singleton {
        static {
            System.out.println("Singleton static...");
        }
        private static final Demo INSTANCE = new Demo();
    }
    public static Demo getInstance() {
        return Singleton.INSTANCE;
    }
}