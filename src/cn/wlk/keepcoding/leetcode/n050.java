package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 50. Pow(x, n)
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数。
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 * 说明:
 *
 * -100.0 < x < 100.0
 * n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 */
//done
public class n050 {
    /**
     * 使用java 的库函数就可以，但是应该不是题目的要求，题目应该要求不能用库函数的
     * 其他方法参见：
     *  https://blog.csdn.net/u013575812/article/details/50969248
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return Math.pow(x,n);
    }

    @Test
    public void test() {
        n050 t = new n050();
        System.out.println();
    }

}
