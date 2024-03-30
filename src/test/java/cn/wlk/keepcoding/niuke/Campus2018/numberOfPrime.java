package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/29 10:49
 * author:WLK
 */

/**
 * 题目描述 返回小于N的质数的个数
 *
 * 请考虑性能
 * 输入描述:
 * <p>
 * 一个整数N
 * <p>
 * 输出描述:
 * <p>
 * 小于N的质数数量
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 10
 * <p>
 * 输出
 * 复制
 * <p>
 * 4
 * <p>
 * 说明
 * <p>
 * N=10，质数有 [2, 3, 5, 7]
 * <p>
 * 备注:
 * <p>
 * 0、1 不属于质数。
 * 解法：构造数组arr[i],代表小于i的质数的个数，，每次只需要判断一下数字i是不是质数就可以了，只需要判断n次
 */
public class numberOfPrime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n <= 3) {
            System.out.println(1);
            return;
        }
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 0;
        arr[2] = 1;
        for (int i = 3; i <= n; i++) {
            if (isPrime(i)) {
                arr[i] = arr[i - 1] + 1;
            } else arr[i] = arr[i - 1];
        }

        System.out.println(arr[n]);
    }

    public static boolean isPrime(int n) {
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
