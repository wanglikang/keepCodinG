package cn.wlk.keepcoding.niuke.Y2020.Tencent.tongyibishi;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/26 20:51
 * author:WLK
 */

public class T5 {

    @Test
    public void test() {
        T5 t = new T5();
        System.out.println(T5.func(10,1));
        System.out.println(T5.func(10,2));
        System.out.println(T5.func(10,3));
        System.out.println(T5.func(10,4));
        System.out.println(T5.func(10,5));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        while(n-->0){
            long x = scanner.nextLong();
            int k = scanner.nextInt();
            System.out.println(func(x,k));
        }
    }

    public static long func(long x,int k){
        int level = (int) (Math.log(x)/Math.log(2));
        if(level<k){
            return -1;
        }
        long result = x;
        while(level>=k){
            result = result/2;
            level--;
        }
        return result;
    }

}
