package cn.wlk.keepcoding.Acmcoder;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2020/4/20 16:55
 * author:WLK
 *
 * 度小满金融 2020春招 Java研发试卷在线考试
 * 编程题|20.0分2/2
 * 传送门
 * 时间限制：C/C++语言 1000MS；其他语言 3000MS
 * 内存限制：C/C++语言 65536KB；其他语言 589824KB
 * 题目描述：
 * 西西所在的国家有N座城市，每座城市都有一道传送门，城市 i 的传送门通往城市 a[i]。当西西位于城市 i 时，每次他可以执行以下三种操作中的一种：
 *
 *   花费 A 的费用，从城市 i 前往城市 a[i]；
 *
 *   如果 a[i] > 1，可以花费 B 的费用，将 a[i] 的值减少 1；
 *
 *   如果 a[i] < N，可以花费 C 的费用，将 a[i] 的值增加 1。
 *
 * 现在，西西想从城市 1 前往城市 N，那么他至少要花费多少费用？
 *
 * 输入
 * 第一行输入四个整数 N、A、B、C（1 < N <= 10000，1 <= A、B、C <= 100000）。
 *
 * 第二行输入 N 个整数 a[1] 到 a[N]（1 <= a[i] <= N）。
 *
 * 输出
 * 输出一个整数，表示从城市 1 前往城市 N 所花费的最少费用。
 *
 *
 * 样例输入
 * 7  1  1  1
 * 3  6  4  3  4  5  6
 * 样例输出
 * 4
 *
 * 提示
 * 样例解释
 * 西西可以按顺序执行以下操作：
 * 将 a[1] 减少 1，此时 a[1] = 2；
 * 从城市 1 前往城市 2；
 * 将 a[2] 增加 1，此时 a[2] = 7；
 * 从城市 2 前往城市 7。
 */

public class DXMD2 {

    @Test
    public void test() {
        DXMD2 t = new DXMD2();
        int[] nums = new int[]{3,6,4,3,4,5,6};
        System.out.println(t.func(7,1,1,1,nums));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N,A,B,C;
        N = scanner.nextInt();
        A = scanner.nextInt();
        B = scanner.nextInt();
        C = scanner.nextInt();
        int[] arr = new int[N];
        for(int i = 0;i<N;i++){
            arr[i]=scanner.nextInt();
        }
        System.out.println(func(N,A,B,C,arr));

    }
    public static int func(int N,int A,int B,int C,int[] num){


        int[] pre = new int[N+1];
        int[] dp = new int[N+1];
        int[] cost = new int[N+1];
        for(int i = 0;i<=N;i++){
            pre[i]=i;
            dp[i]=Integer.MAX_VALUE;
            cost[i]=Integer.MAX_VALUE;
        }


        int l,r;
        for(int i = 0;i<num.length;i++){
            l = i+1;
            r = Math.min(num[i],N);
            pre[r] = l;
            cost[r] = A;
            if(r>1) {
                pre[r-1] = Math.min(pre[r-1],l);
                cost[r-1] = Math.min(cost[r - 1], B + A);
            }
            if(r<N) {
                pre[r+1] = Math.min(pre[r+1],l);
                cost[r+1] = Math.min(cost[r + 1], C + A);
            }
        }
        dp[0]=0;
        dp[1]=0;
        for(int i = 2;i<=N;i++){
            for(int j = pre[i];j<i;j++){
                if(dp[j]!=Integer.MAX_VALUE){
                    dp[i] = Math.min(dp[i],dp[j]+cost[j]);
                }
            }
        }

        return dp[N];

    }

}
