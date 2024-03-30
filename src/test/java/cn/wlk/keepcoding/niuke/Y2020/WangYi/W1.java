package cn.wlk.keepcoding.niuke.Y2020.WangYi;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * 2020/4/5 10:40
 * author:WLK
 *
 * [编程题]完美的序列
 *
 * 时间限制：C/C++ 2秒，其他语言4秒
 *
 * 空间限制：C/C++ 256M，其他语言512M
 * 小易定义一个数字序列是完美的，当且仅当对于任意，都满足，即每个数字都要大于等于前面所有数字的和。
 * 现在给定数字序列，小易想请你从中找出最长的一段连续子序列，满足它是完美的。
 *
 * 输入描述:
 *
 * 第一行数据组数。对于每组数据，第一行一个整数，接下来一行个整数表示序列。
 *
 *
 * 输出描述:
 *
 * 对于每组数据，一行一个数字表示最长完美的连续子序列的长度。
 *
 *
 * 输入例子1:
 *
 * 2
 * 5
 * 1 3 9 2 6
 * 5
 * 4 2 9 16 7
 *
 *
 * 输出例子1:
 *
 * 3
 * 3
 *
 * 解法：注意审题，，是求连续的子序列，也就是子串
 *
 *
 *
 */

public class W1 {

    @Test
    public void test() {
        W1 t = new W1();
//        int[] arr = new int[]{1, 3 ,9 ,2 ,6};
//        int[] arr = new int[]{4,2,9,16,7};

        String str = "19623467 184294447 3321 224453 15849 180779121 15192 62879 2960375 41041 9446629 586425 57 1388210 494576 61 3876545 461945 649 881525 207279459 45561 43 27238905 1 15755768 11751789 5 14 59289361 920951 79784 840519428 7 53135 861985 593087 411309521 2 3176 17 8432576 381 128681 2785277 1053593 112815 14 229805 1 5 42 27 103117604 7325178 1 444859377 2473537 816131202 560074254 74501665 83 5 1 231041809 371800121 819 13447819 213 4 2823777 104936 3 308669 2 357 56971434 3389 5 2037 15 3 796110 17844443 587078809 28704640 276801105 227 43 2642 25 1676592 64227482 3 379 22 579 11 425 857";
//        String str = "1 3 5 30 9 20";
        String[] strs = str.split(" ");
        long[] arr = new long[strs.length];
        List<Long> list = Arrays.stream(strs).map(Long::parseLong).collect(Collectors.toList());
        for(int i = 0;i<list.size();i++){
            arr[i] = list.get(i);
        }
        Utils.showArray(arr);System.out.println();
        System.out.println(W1.func(arr));
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int k= scanner.nextInt();
        while(k-->0){
            int n = scanner.nextInt();
            long[] arr = new long[n];
            for(int i = 0;i<n;i++){
                arr[i] = scanner.nextInt();
            }
            Utils.showArray(arr);
            System.out.println();

            System.out.println(func(arr));
        }
    }

    public static long func(long[] A) {
        int n = A.length;
        if (n == 0) {
            return 0;

        }

        long[] sum = new long[n];//sum[i]以i结尾的子序列和，包括自己
        long[] dp = new long[n];//dp[i]以i结尾的子序列的最长长度

        dp[0]=1;
        sum[0]=A[0];
        long maxT= -1;
        for(int i = 0;i<n;i++){
            dp[i]=1;
            sum[i]=A[i];
            for(int j = i-1;j>=0;j--){
                if(sum[j]<=A[i]  && dp[i]<dp[j]+1){
                    //可以组成子序列
                    dp[i]=Math.max(dp[i],dp[j]+1);
                    sum[i] = sum[j]+A[i];
                }
            }
            maxT = Math.max(maxT,dp[i]);
        }

        Utils.showArray(dp);System.out.println();
        Utils.showArray(sum);System.out.println();

        return maxT;
    }
}
