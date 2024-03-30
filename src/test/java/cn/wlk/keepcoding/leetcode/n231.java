package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 231. 2的幂
 *
 * 给定一个整数，编写一个函数来判断它是否是 2 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 1
 * 输出: true
 * 解释: 20 = 1
 * 示例 2:
 *
 * 输入: 16
 * 输出: true
 * 解释: 24 = 16
 * 示例 3:
 *
 * 输入: 218
 * 输出: false
 */

public class n231 {
    public boolean isPowerOfTwo(int n) {
        if (n == 0)
            return false;
        if (n == 1)
            return true;
        if (n < 0)
            return false;
        while (n > 2) {
            if (n %  2!= 0)
                break;
            n = n / 2;
        }

        if (n > 2)
            return false;

        if (n % 2 == 0)
            return true;
        else return false;
    }
    @Test
    public void test() {
        n231 n = new n231();
        System.out.println(n.isPowerOfTwo(1));
        System.out.println(n.isPowerOfTwo(2));
        System.out.println(n.isPowerOfTwo(3));
        System.out.println(n.isPowerOfTwo(4));
        System.out.println(n.isPowerOfTwo(5));
        System.out.println(n.isPowerOfTwo(8));
        System.out.println(n.isPowerOfTwo(16));
        System.out.println(n.isPowerOfTwo(17));

    }

}
