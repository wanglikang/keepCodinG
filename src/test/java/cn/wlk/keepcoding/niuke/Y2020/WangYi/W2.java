package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import org.junit.Test;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2020/4/5 14:17
 * author:WLK
 * [编程题]翻倍
 *
 * 时间限制：C/C++ 2秒，其他语言4秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易给定你数字和系数。每次操作你可以将变成或者将变成。问至少几次操作使得。
 *
 * 输入描述:
 *
 * 第一行数据组数，对于每组数据，一行四个整数。
 * .
 *
 *
 * 输出描述:
 *
 * 对于每组数据，输出一个数字表示答案
 *
 *
 * 输入例子1:
 *
 * 2
 * 1 5 7 2
 * 3 5 1 2
 *
 *
 * 输出例子1:
 *
 * 1
 * 2
 *
 *
 * 输入例子2:
 *
 * 2
 * 1 15 4 2
 * 12 19 3 2
 *
 *
 * 输出例子2:
 *
 * 3
 * 3
 *
 * 解法：暴力，dfs会超时，bfs通过
 */

public class W2 {

    @Test
    public void test() {
        W2 t = new W2();
        System.out.println(W2.func(1 ,5 ,7, 2));//1
        System.out.println(W2.func(3,5,1,2));//2
        System.out.println(W2.func(1,15,4,2));//3
        System.out.println(W2.func(12,19,3,2));//3
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        while(n-->0){
            long A = scanner.nextLong();
            long B = scanner.nextLong();
            long p = scanner.nextLong();
            long q = scanner.nextLong();
            System.out.println(func(A,B,p,q));

        }
    }
    public static long func(long A,long B,long p,long q){
//        return dfs(A,B,p,q,1);
        return bfs(A,B,p,q);

    }


    public static long dfs(long A,long B,long p,long q,long depth){

        if(A+p>=B || A>=B){
            return depth;
        }

        long t1 = dfs(A+p,B,p,q,depth+1);
        long t2 = dfs(A,B,p*q,q,depth+1);
        return Math.min(t2,t2);
    }

    public static long  bfs(long A,long B,long p,long q){
        Queue<long[]> queue = new LinkedBlockingQueue<>();
        queue.add(new long[]{A,B,p,q,0});
        boolean hasFound = false;
        while(!queue.isEmpty() && !hasFound){
            long[] status = queue.poll();
            long AA = status[0];
            long BB = status[1];
            long pp = status[2];
            long qq = status[3];
            long depth = status[4];
            if(AA>=BB){
                return depth;
            }
            queue.add(new long[]{AA+pp,BB,pp,qq,depth+1});
            queue.add(new long[]{AA,BB,pp*qq,qq,depth+1});
        }

        return 0;
    }
}
