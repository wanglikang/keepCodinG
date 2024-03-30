package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/26 12:15
 * author:WLK
 */

/**
 * 题目描述 区间表达
 * <p>
 * 牛牛的老师给出了一个区间的定义:对于x ≤ y,[x, y]表示x到y之间(包括x和y)的所有连续整数集合。例如[3,3] = {3}, [4,7] = {4,5,6,7}.牛牛现在有一个长度为n的递增序列,牛牛想知道需要多少个区间并起来等于这个序列。
 * 例如:
 * {1,2,3,4,5,6,7,8,9,10}最少只需要[1,10]这一个区间
 * {1,3,5,6,7}最少只需要[1,1],[3,3],[5,7]这三个区间
 * 输入描述:
 * <p>
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),
 * 第二行n个整数a[i](1 ≤ a[i] ≤ 50),表示牛牛的序列,保证序列是递增的。
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数,表示最少区间个数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 5
 * 1 3 5 6 7
 * <p>
 * 输出
 * 复制
 * <p>
 * 3
 * 解法：判断不连续的个数即可
 */
public class rangeExpression {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int count = 1;
        for(int i = 1;i<n;i++){
            if(arr[i]!=arr[i-1]+1){
                count++;
            }
        }
        System.out.println(count);

    }
}
