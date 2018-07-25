package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 7. 反转整数/颠倒整数
 * 给定一个 32 位有符号整数，将整数中的数字进行反转。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 123
 * 输出: 321
 * 示例 2:
 * <p>
 * 输入: -123
 * 输出: -321
 * 示例 3:
 * <p>
 * 输入: 120
 * 输出: 21
 * 注意:
 * <p>
 * 假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−231,  231 − 1]。根据这个假设，如果反转后的整数溢出，则返回 0。
 */
//done
public class n007 {
    public int reverse(int x) {

        long result = 0;
        if (x > 0) {
            while (x > 0) {
                result = result * 10 + x % 10;
                x = x / 10;
            }
            if (result >Integer.MAX_VALUE)
                return 0;
        }else {
            while(x<0){
                result = result*10+x%10;
                x=x/10;
            }
            if(result<Integer.MIN_VALUE)
                return 0;
        }
        return (int)result;
    }

    @Test
    public void test() {
        n007 t = new n007();
//        System.out.println(t.reverse(-123));
//        System.out.println(t.reverse(-123));
//        System.out.println(t.reverse(-123));
//        System.out.println(t.reverse(-1));
//        System.out.println(t.reverse(1));
//        System.out.println(t.reverse(0));
//        System.out.println(t.reverse(2147483647));
        System.out.println(t.reverse(1534236469));
        System.out.println(Integer.MAX_VALUE);

    }

}
