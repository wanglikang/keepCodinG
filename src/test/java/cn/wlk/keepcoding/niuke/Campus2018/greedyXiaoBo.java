package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/31 19:28
 * author:WLK
 */

/**
 * 题目描述 贪心的小博
 * <p>
 * 小博沉迷收集卡片，购买干脆面是他收集卡片的主要方式。他总共渴望的有N类卡片，均可通过购买干脆面获得，一包干脆面中有且仅有一张卡片，并且卡片类型对应N类卡片中的一种。且每 种类型的卡片出现在一包干脆面中的概率是相等的。
 * <p>
 * 小博非常的贪心，他有N个愿望，第i个愿望即为:拥有至少pi张i类卡片，其中1 ≤ i ≤ N。
 * <p>
 * 然而，小博又极其贫困，他想知道最少需要买多少干脆面，使得在最坏情况下，至少能够满足他 N个愿望的其中一个。
 * 输入描述:
 * <p>
 * 第一行包含一个整数N， 1 ≤ N ≤ 105。
 * 第二行包含N个整数pi，pi表示小博希望至少拥有的i类卡片数量。1 ≤ pi ≤ 105。
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数ANS，小博可以完成至少一个愿望需要购买的最少的干脆面的数量。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 3
 * 8 6 9
 * <p>
 * 输出
 * 复制
 * <p>
 * 21
 * <p>
 * 说明
 * <p>
 * 示例2
 * 输入
 * 复制
 * <p>
 * 2
 * 3 5
 * <p>
 * 输出
 * 复制
 * <p>
 * 7
 *
 * 解法：累加，在减去n-1即可。等价于即满足每个愿望都差一个的的状态，再+1
 */
public class greedyXiaoBo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += scanner.nextInt();
        }
        System.out.println(sum - (n - 1));
    }
}
