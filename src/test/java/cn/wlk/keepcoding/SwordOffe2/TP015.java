package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/3/3 10:53
 * author:WLK
 *
 * 面试题15. 二进制中1的个数
 *
 * 请实现一个函数，输入一个整数，输出该数二进制表示中 1 的个数。例如，把 9 表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 *
 * 示例 1：
 *
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011 中，共有三位为 '1'。
 *
 * 示例 2：
 *
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000 中，共有一位为 '1'。
 *
 * 示例 3：
 *
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 *
 *
 *
 * 注意：本题与主站 191 题相同：https://leetcode-cn.com/problems/number-of-1-bits/
 *
 * 解法：使用二进制n&(n-1)的方式求1的个数
 *
 */

public class TP015 {

    @Test
    public void test() {
        TP015 t = new TP015();
        System.out.println(t.hammingWeight(Integer.MAX_VALUE-2));
        System.out.println(t.hammingWeight(-3));
        System.out.println(t.hammingWeight(-2147483648));
        System.out.println(t.hammingWeight(0xfffffffe));
        System.out.println(t.hammingWeight(0x9ffffffe));

    }

    /**
     * you need to treat n as an unsigned value
     *
     * 朴素解法，通过了
     * @param n
     * @return
     */
    public int hammingWeight2(int n) {
        int result = 0;
        while(n!=0){
            if((n&0x1)==1){
                result++;
            }
            n = n>>>1;//注意是：>>> 无符号右移，，左端补0
        }

        return result;
    }


    /**
     * 这个理论上应该更快的，，但是提交上去后超时了;
     * 又不超时了，，，
     * @param n
     * @return
     */
    public int hammingWeight(int n) {
        int result = 0;
        while(n!=0){
            n = n&(n-1);
            result++;
        }

        return result;

    }

    /**
     * 这个不超时
     * @param n
     * @return
     */
    public int hammingWeight_pass(int n) {
        int result = 0;
        int i= 0;
        for(;i<32;i++){
            if((n&0x00000001)==1)
                result++;

            n=n>>1;
        }
        return result;

    }

}
