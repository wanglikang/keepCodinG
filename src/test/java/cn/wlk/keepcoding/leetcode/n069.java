package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 69. x 的平方根
 * <p>
 * 实现 int sqrt(int x) 函数。
 * <p>
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * <p>
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4
 * 输出: 2
 * 示例 2:
 * <p>
 * 输入: 8
 * 输出: 2
 * 说明: 8 的平方根是 2.82842...,
 * 由于返回类型是整数，小数部分将被舍去。
 */
public class n069 {

    /**
     * 使用二分查找的方法
     * 将x/2,判断大小，并不断缩小范围
     *  注意，int相乘需要强制转为long，避免结果溢出
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {//未完待续
        if (x == 0) {
            return 0;
        }
        int l = 0;
        int r = x;
        int result = 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            long Y =  (long)mid * mid;
            if (Y <= x) {
                result = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        n069 t = new n069();
//        System.out.println(t.mySqrt(0));
//        System.out.println(t.mySqrt(1));
//        System.out.println(t.mySqrt(2));
//        System.out.println(t.mySqrt(8));
//        System.out.println(t.mySqrt(16));
////        System.out.println(t.mySqrt(17));
////        System.out.println(t.mySqrt(18));
////
//        System.out.println(t.mySqrt(31));
//        System.out.println(t.mySqrt(32));
//        System.out.println(t.mySqrt(34));
//        System.out.println(t.mySqrt(35));
//        System.out.println(t.mySqrt(36));
//        System.out.println(t.mySqrt(37));
//        System.out.println(t.mySqrt(38));
        System.out.println(t.mySqrt(2147395599));
    }

}
