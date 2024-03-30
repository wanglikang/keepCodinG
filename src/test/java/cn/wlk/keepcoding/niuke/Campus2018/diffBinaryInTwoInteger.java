package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/31 12:23
 * author:WLK
 */

/**题目描述 两个整数二进制位不同个数
 *
 * 输入两个整数，求两个整数二进制格式有多少个位不同
 * 输入描述:
 *
 * 两个整数
 *
 * 输出描述:
 *
 * 二进制不同位的个数
 *
 * 示例1
 * 输入
 * 复制
 *
 * 22 33
 *
 * 输出
 * 复制
 *
 * 5
 * 解法：二进制运算
 *
 */
public class diffBinaryInTwoInteger {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m=scanner.nextInt(),n = scanner.nextInt();
        int t = m^n;
        int result = 0;
        while(t!=0){
            result+=t&1;
            t=t>>1;
        }
        System.out.println(result);
    }
}
