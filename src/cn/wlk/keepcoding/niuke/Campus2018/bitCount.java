package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/26 12:21
 * author:WLK
 */

/**题目描述 bit位数
 *  两个int32整数m和n的二进制表达，计算有多少个位(bit)不同？
 * 输入描述:
 *
 * 一行中给定两个数字
 *
 * 输出描述:
 *
 * 输出这两个数字中bit不同的个数
 *
 * 示例1
 * 输入
 *
 * 15 8
 *
 * 输出
 *
 * 3
 *
 * 解法：二进制操作而已
 */
public class bitCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt(),n = scanner.nextInt();
        int k = m^n;
        int count = 0;
        while(k!=0){
            count+=k&1;
            k = k>>1;
        }
        System.out.println(count);
    }
}
