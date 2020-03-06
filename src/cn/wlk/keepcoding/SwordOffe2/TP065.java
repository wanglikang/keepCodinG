package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/6 22:51
 * author:WLK
 *
 * 面试题65. 不用加减乘除做加法
 *
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 *
 *
 * 示例:
 *
 * 输入: a = 1, b = 1
 * 输出: 2
 *
 *
 *
 * 提示：
 *
 *     a, b 均可能是负数或 0
 *     结果不会溢出 32 位整数
 *
 * 解法：就二进制的加法：&求无进位相加，^求相加的进位
 */

public class TP065 {

    @Test
    public void test() {
        TP065 t = new TP065();
        int re = t.add(13, 9);
        System.out.println(re);
    }

    public int add(int a, int b) {
        int up = a&b;
        int tempSum = a^b;

        int t;
        while(up!=0){
            up = up<<1;
            t = tempSum;
            tempSum = up ^ tempSum;
            up = t & up;
        }

        return tempSum;

    }


}
