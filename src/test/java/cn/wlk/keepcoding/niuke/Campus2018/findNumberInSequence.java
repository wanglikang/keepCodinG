package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/3/31 14:12
 * author:WLK
 */

/**题目描述 序列找数
 * 输入为n+1个非负整数，用空格分开。
 * 其中：首个数字为非负整数序列的最大值n，后面n个数字为子序列中包含的数字。
 *
 * 输出描述:
 *
 * 输出为1个数字，即未出现在子序列中的那个数。
 *
 * 示例1
 * 输入
 *
 * 3 3 0 1
 *
 * 输出
 *
 * 2
 *
 * 解法：简单排序在判断为止是否对应即可
 *          其他的方法，在不溢出的情况下，，通过n可以得知前n项的和，然后减去每个数即可，剩下的树即为所求
 *
 */
public class findNumberInSequence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);

//        for(int i = 0 ;i<n;i++){
//            System.out.println(i+":"+arr[i]);
//        }
        for(int i = 0;i<n;i++){
            if(arr[i]!=i) {
                System.out.println(i);
                return;
            }
        }


    }
}
