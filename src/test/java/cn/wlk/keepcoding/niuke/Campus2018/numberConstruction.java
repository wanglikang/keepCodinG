package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/29 10:13
 * author:WLK
 */

/**
 * 题目描述 数字构造
 * <p>
 * <p>
 * <p>
 * 对于一个十进制数而言，它的数位和等于将它各位数字相加得到的和。比如 231 的数位和 是 6，3179 的数位和是 20。
 * 现在你知道某个十进制数的数位和等于 s，并且这个数不包含 0，且任意相邻的数位是不同 的，比如 112 或者 102 都是不满足条件的。现在你想知道满足这样的条件的最大的数是多少?
 * 输入描述:
 * <p>
 * 第一行包含一个整数𝑠，1 ≤ 𝑠 ≤ 42
 * <p>
 * 输出描述:
 * <p>
 * 输出满足条件的最大整数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 1
 * <p>
 * 输出
 * 复制
 * <p>
 * 1
 * <p>
 * 说明
 * <p>
 * 示例2
 * 输入
 * 复制
 * <p>
 * 2
 * <p>
 * 输出
 * 复制
 * <p>
 * 2
 * 解法：以3为周期；构造数字即可，全部由“1”，“2”组成的数字最大
 *      s%3==0:("21")* 即有若干个”12“组成
 *      s%3==1:("12")*"1" 即由若干个”12“后加一个”1”组成
 *      s%3==2:"2"("12")* 即由一个“2”加若干个"12"组成
 */
public class numberConstruction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int s = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        if (s % 3 == 0) {
            for (int i = 0; i < s / 3; i++) {
                sb.append("21");
            }
        } else if (s % 3 == 1) {
            sb.append("1");
            for (int i = 0; i < (s - 1) / 3; i++) {
                sb.insert(0, "12");
            }

        } else {
            sb.append("2");
            for (int i = 0; i < (s - 2) / 3; i++) {
                sb.append("12");
            }
        }
        System.out.println(sb.toString());
    }
}
