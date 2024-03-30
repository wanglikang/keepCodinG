package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 13:00
 * author:WLK
 */

/**
 * 题目描述 循环数比较
 * <p>
 * 对于任意两个正整数x和k,我们定义repeat(x, k)为将x重复写k次形成的数,例如repeat(1234, 3) = 123412341234,repeat(20,2) = 2020.
 * 牛牛现在给出4个整数x1, k1, x2, k2, 其中v1 = (x1, k1), v2 = (x2, k2),请你来比较v1和v2的大小。
 * 输入描述:
 * <p>
 * 输入包括一行,一行中有4个正整数x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),以空格分割
 * <p>
 * 输出描述:
 * <p>
 * 如果v1小于v2输出"Less",v1等于v2输出"Equal",v1大于v2输出"Greater".
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 1010 3 101010 2
 * <p>
 * 输出
 * 复制
 * <p>
 * Equal
 *
 * 解法：组成char数字判断即可
 */
public class repeatCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] strs = scanner.nextLine().split(" ");
        char[] num1 = repeat(strs[0], strs[1]);
        char[] num2 = repeat(strs[2], strs[3]);
        if (num1.length != num2.length) {
            System.out.println(num1.length > num2.length ? "Greater" : "Less");
        } else {
            for (int i = 0; i < num1.length; i++) {
                if (num1[i] != num2[i]) {
                    System.out.println(num1[i] > num2[i] ? "Greater" : "Less");
                    return;
                }
            }
            System.out.println("Equal");
        }

    }

    public static char[] repeat(String x, String n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Integer.parseInt(n); i++) {
            sb.append(x);
        }
        return sb.toString().toCharArray();
    }

}
