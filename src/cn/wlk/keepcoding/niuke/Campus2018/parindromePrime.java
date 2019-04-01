package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 10:51
 * author:WLK
 */

/**
 * 题目描述 回文素数
 * <p>
 * 如果一个整数只能被1和自己整除,就称这个数是素数。
 * 如果一个数正着反着都是一样,就称为这个数是回文数。例如:6, 66, 606, 6666
 * 如果一个数字既是素数也是回文数,就称这个数是回文素数
 * 牛牛现在给定一个区间[L, R],希望你能求出在这个区间内有多少个回文素数。
 * 输入描述:
 * <p>
 * 输入包括一行,一行中有两个整数(1 ≤ L ≤ R ≤ 1000)
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数,表示区间内回文素数个数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 100 150
 * <p>
 * 输出
 * 复制
 * <p>
 * 2
 *
 *
 * 解法：简单判断即可
 */
public class parindromePrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int l = scanner.nextInt(), r = scanner.nextInt();
        l = l == 1 ? 2 : l;
        int result = 0;
        for (int i = l; i <= r; i++) {
            if (isPrime1(i) && isParindrome(i)) {
                result++;

            }
        }
        System.out.println(result);

    }

    public static boolean isPrime1(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean isParindrome(int n) {
        int[] arr = new int[20];
        int index = 0;
        int t = n;
        while (t != 0) {
            arr[index++] = t % 10;
            t = t / 10;
        }
        t = n;
        index--;
        while (index >= 0) {
            if (arr[index--] != t % 10) {
                return false;
            }
            t = t / 10;
        }
        return true;
    }

}
