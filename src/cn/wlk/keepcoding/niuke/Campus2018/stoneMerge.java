package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/3/28 12:02
 * author:WLK
 */

/**题目描述 石子合并
 *  小Q和牛博士在玩一个石子合并的游戏，初始一共有n堆石子，每堆石子有w[i]个石子。小Q和牛博士他们需要对石子堆进行合并，每次他们可以任意选择两堆石子进行合并。一堆有x个石子的石子堆和一堆有y个石子的石子堆合并将得到一堆x+y个石子的石子堆，这次合并得分为x*y，当只剩下一堆石子的时候游戏结束。
 *
 * 、小Q和牛博士希望采取优秀的策略获得最大得分，希望你能来帮他们算算最大得分多少。
 * 输入描述:
 *
 * 输入包括两行，第一行一个正整数n(2≤n≤100)。
 *
 * 第二行包括n个正整数w[i](1≤w[i]≤100)，即每堆石子的个数。
 *
 * 输出描述:
 *
 * 输出一个正整数，即小Q和牛博士最大得分是多少。
 *
 * 示例1
 * 输入
 * 复制
 *
 * 3
 * 1 2 3
 *
 * 输出
 * 复制
 *
 * 11
 *
 * 解法：先排个序，在依次进行合并即可
 *
 */
public class stoneMerge {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
        int result = 0;
        for(int i = 1;i<n;i++){
            result+=arr[i]*arr[i-1];
            arr[i] = arr[i]+arr[i-1];
        }
        System.out.println(result);
    }
}
