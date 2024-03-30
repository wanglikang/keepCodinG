package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 647. 回文子串
 * 给定一个字符串，你的任务是计算这个字符串中有多少个回文子串。
 *
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被计为是不同的子串。
 *
 * 示例 1:
 *
 * 输入: "abc"
 * 输出: 3
 * 解释: 三个回文子串: "a", "b", "c".
 * 示例 2:
 *
 * 输入: "aaa"
 * 输出: 6
 * 说明: 6个回文子串: "a", "a", "a", "aa", "aa", "aaa".
 * 注意:
 *
 * 输入的字符串长度不会超过1000。
 */
//done

/**
 * 解题方法：
 *      暴力解决即可
 */
public class n647 {
    public int countSubstrings(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int result = 0;
        for(int i = 0;i<len;i++){
            result+=count(chars,i,i);
            result+=count(chars,i,i+1);
        }
        return result;

    }
    public int count(char[]  chars ,int left,int right){
        int result = 0;
        int len = chars.length;
        while(left>=0&&right<len && chars[left]==chars[right]){
            result++;
            left--;
            right++;
        }
        return result;
    }
    @Test
    public void test() {
        n647 t = new n647();
        System.out.println(t.countSubstrings("aaa"));
        System.out.println();
    }

}
