package cn.wlk.keepcoding.leetcode;


/**
 * 对于一个 正整数，如果它和除了它自身以外的所有正因子之和相等，我们称它为“完美数”。
 * 给定一个 正整数 n， 如果他是完美数，返回 True，否则返回 False
 * <p>
 * 示例：
 * 输入: 28
 * 输出: True
 * 解释: 28 = 1 + 2 + 4 + 7 + 14
 * 注意:
 * 输入的数字 n 不会超过 100,000,000. (1e8)
 */

import org.junit.Test;

/**
 * 507. 完美数
 */
public class n507 {

    public boolean checkPerfectNumber(int num) {
        if (num == 1)
            return false;
        if (num == 2)
            return false;

        int i = 2;
        int sum = 1;
        for (; i <= num/2; i++) {
            if (num % i == 0) {
                sum += i;
//                System.out.println("add :" + i);
            }
        }
        if (sum == num)
            return true;
        else return false;
    }


    @Test
    public void test() {
        n507 n = new n507();
//        System.out.println(new Date().getSeconds());
        System.out.println(n.checkPerfectNumber(100000000));
//        System.out.println(new Date().getSeconds());
    }
}
