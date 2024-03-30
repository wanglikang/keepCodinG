package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 326. 3的幂
 *
 * 给定一个整数，写一个函数来判断它是否是 3 的幂次方。
 *
 * 示例 1:
 *
 * 输入: 27
 * 输出: true
 * 示例 2:
 *
 * 输入: 0
 * 输出: false
 * 示例 3:
 *
 * 输入: 9
 * 输出: true
 * 示例 4:
 *
 * 输入: 45
 * 输出: false
 *
 * 进阶：
 * 你能不使用循环或者递归来完成本题吗？
 */

//done
public class n326 {
    public boolean isPowerOfThree(int n) {
        if(n==0)
            return false;
        if(n==1)
            return true;
        if(n<0)
           return false;
        while(n>3){
            if(n%3!=0)
                break;
            n = n/3;
        }

        if(n>3)
            return false;

        if(n%3==0)
            return true;
        else return false;
    }
    @Test
    public void test() {
    n326 n = new n326();
        System.out.println(n.isPowerOfThree(3));
        System.out.println(n.isPowerOfThree(-3));


    }

}
