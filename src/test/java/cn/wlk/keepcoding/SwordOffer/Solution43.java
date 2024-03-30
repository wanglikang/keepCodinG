package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/4 10:08
 * author:WLK
 * 左旋转字符串
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。
 * 对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。
 * 例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。
 * 是不是很简单？OK，搞定它！
 * 解法：subString即可
 */
public class Solution43 {
    @Test
    public void test() {
        Solution43 t = new Solution43();
        System.out.println(t.LeftRotateString("abcdefg", 4));
        System.out.println(t.LeftRotateString("abcdefg", 12));
        System.out.println(t.LeftRotateString("abcdefg", 0));
        System.out.println(t.LeftRotateString("", 4));
        System.out.println(t.LeftRotateString("", 12));
        System.out.println(t.LeftRotateString("", 0));

    }

    public String LeftRotateString(String str,int n) {

        return str.length()>0? str.substring(n%str.length(),str.length())+str.substring(0,n%str.length()): str;
    }
}
