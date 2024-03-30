package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2019/4/1 13:53
 * author:WLK
 * 题目描述：回文数
 * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 *
 * 示例 1:
 *
 * 输入: 121
 * 输出: true
 *
 * 示例 2:
 *
 * 输入: -121
 * 输出: false
 * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 *
 * 示例 3:
 *
 * 输入: 10
 * 输出: false
 * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
 *
 * 进阶:
 *
 * 你能不将整数转为字符串来解决这个问题吗？
 * done ，很久以前就做过了？？？
 */
public class n009 {
    public boolean isPalindrome(int x) {
        if(x<0)
            return false;
        Stack<Integer> stack1 = new Stack<>();

        int xx = x;
        while(x!=0){
            stack1.push(x%10);
            x = x/10;
        }
        boolean result = true;
        while(!stack1.empty()){
            if(stack1.pop()!=xx%10){
                result = false;
            }
            xx = xx/10;
        }
        return result;
    }
    @Test
    public void test() {
        n009 t = new n009();
        System.out.println(t.isPalindrome(23423));

    }

}
