package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/4/1 11:18
 * author:WLK
 */

/**
 * 题目描述 奶牛编号
 * <p>
 * 牛牛养了n只奶牛,牛牛想给每只奶牛编号,这样就可以轻而易举地分辨它们了。 每个奶牛对于数字都有自己的喜好,第i只奶牛想要一个1和x[i]之间的整数(其中包含1和x[i])。
 * 牛牛需要满足所有奶牛的喜好,请帮助牛牛计算牛牛有多少种给奶牛编号的方法,输出符合要求的编号方法总数。
 * 输入描述:
 * <p>
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),表示奶牛的数量 第二行为n个整数x[i](1 ≤ x[i] ≤ 1000)
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数,表示牛牛在满足所有奶牛的喜好上编号的方法数。因为答案可能很大,输出方法数对1,000,000,007的模。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 4
 * 4 4 4 4
 * <p>
 * 输出
 * 复制
 * <p>
 * 24
 *
 * 解法：对数组中的数字排序，，计算arr[i]-i的累乘即可，还有取余
 */
public class cowNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i  =0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        long result = 1;
        for(int i = 0;i<n;i++){
            result=((result*(arr[i]-i))%1000000007);
        }
        System.out.println(result);
    }
}
