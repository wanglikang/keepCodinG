package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 14:32
 * author:WLK
 * 不用加减乘除做加法
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 解法：二进制^:相当于不进位加
 *      二进制&再<<1:相当于求进位
 */
public class Solution48 {
    @Test
    public void test() {
        Solution48 t = new Solution48();
    }
    public int Add(int num1,int num2) {
        while (num2!=0) {
            int temp = num1^num2;
            num2 = (num1&num2)<<1;
            num1 = temp;
        }
        return num1;
    }
}
