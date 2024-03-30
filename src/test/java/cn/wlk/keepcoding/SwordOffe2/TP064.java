package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/6 22:43
 * author:WLK
 *
 * 面试题64. 求1+2+…+n
 *
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 *
 *
 *
 * 示例 1：
 *
 * 输入: n = 3
 * 输出: 6
 *
 * 示例 2：
 *
 * 输入: n = 9
 * 输出: 45
 *
 *
 *
 * 限制：
 *
 *     1 <= n <= 10000
 *
 *
 * 解法：使用&& 来代替if判断
 */

public class TP064 {

    @Test
    public void test() {
        TP064 t = new TP064();
        int result = t.sumNums(3);
        System.out.println(result);
    }

    public int sumNums(int n) {
        boolean t = n!=0 && (n += sumNums(n-1))==0;
        return n;

    }



}
