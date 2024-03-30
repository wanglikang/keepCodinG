package cn.wlk.keepcoding.SwordOffe2;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.HashMap;

/**
 * 2020/3/3 13:30
 * author:WLK
 *
 * 面试题16. 数值的整数次方
 *
 * 实现函数double Power(double base, int exponent)，求base的exponent次方。不得使用库函数，同时不需要考虑大数问题。
 *
 *
 *
 * 示例 1:
 *
 * 输入: 2.00000, 10
 * 输出: 1024.00000
 *
 * 示例 2:
 *
 * 输入: 2.10000, 3
 * 输出: 9.26100
 *
 * 示例 3:
 *
 * 输入: 2.00000, -2
 * 输出: 0.25000
 * 解释: 2-2 = 1/22 = 1/4 = 0.25
 *
 *
 *
 * 说明:
 *
 *     -100.0 < x < 100.0
 *     n 是 32 位有符号整数，其数值范围是 [−231, 231 − 1] 。
 *
 * 解法：快速幂解法
 *
 */

public class TP016 {

    @Test
    public void test() {
        TP016 t = new TP016();
        double re = t.myPow(1.0 , -2147483648);
        System.out.println(re);
    }


    public double myPow(double x, int n) {
        if(n==0){
            return 1.0;
        }

        if(Math.abs(x-1.0)<0.00000000001){
            return 1.0;
        }
        double factor = x;
        long nn = n;
        if(n<0){
            factor = 1/x;
            nn =0-nn;
        }

        double t = factor;
        double reuslt = 1;
        int c = 0;
        while(nn!=0){
            if((nn&0x1)==1){
                reuslt = reuslt * t;
            }
            t = t*t;
            nn = nn>>>1;
//            System.out.println(nn+"\t"+t+"\t"+reuslt);
//            Utils.showBinary(nn);
        }

        return reuslt;
    }



}
