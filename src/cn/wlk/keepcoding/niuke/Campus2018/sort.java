package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/4/1 9:42
 * author:WLK
 */

/**题目描述 排序
 * 链接：https://www.nowcoder.com/questionTerminal/e496d8e885a949d18476b2dea1e594a9
 * 来源：牛客网
 *
 * 牛牛有一个长度为n的整数序列,牛牛想对这个序列进行重排为一个非严格升序序列。牛牛比较懒惰,他想移动尽量少的数就完成重排,请你帮他计算一下他最少需要移动多少个序列中的元素。(当一个元素不在它原来所在的位置,这个元素就是被移动了的)
 * 输入描述:
 *
 * 输入包括两行,第一行一个整数n(1 ≤ n ≤ 50),即序列的长度
 * 第二行n个整数x[i](1 ≤ x[i] ≤ 100),即序列中的每个数
 *
 *
 *
 * 输出描述:
 *
 * 输出一个整数,即最少需要移动的元素个数
 *
 * 示例1
 * 输入
 *
 * 3
 * 3 2 1
 *
 * 输出
 *
 * 2
 * 解法：比较排序之后每个位置元素不同的个数
 *
 */
public class sort {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int[] arrb = Arrays.copyOf(arr, arr.length);
        Arrays.sort(arr);
        int result = 0;
        for(int i =0;i<n;i++){
            if(arr[i]!=arrb[i]){
                result++;
            }
        }
        System.out.println(result);
    }
}
