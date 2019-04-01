package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Scanner;

/**
 * 2019/4/1 13:50
 * author:WLK
 */

/**题目描述
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 *
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 *
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 *
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 *
 * 请你实现这个将字符串进行指定行数变换的函数：
 *
 * string convert(string s, int numRows);
 *
 * 示例 1:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 *
 * 示例 2:
 *
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 *
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 *
 * done
 * 解法：以之字的一般作为周期，，判断即可
 *
 */
public class n006 {
    public String convert(String s, int n) {
        StringBuilder[] sbs = new StringBuilder[n];
        for(int i = 0;i<n;i++){
            sbs[i] = new StringBuilder();
        }
        char[] chars = s.toCharArray();
        int x;
        for(int i = 0;i<chars.length;i++){

            x = n>1?i%(2*n-2):0;
            if(x<n){
                sbs[x].append(chars[i]);
            }else {
                sbs[2*n-x-2].append(chars[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i<n;i++){
            sb.append(sbs[i].toString());
        }
        return sb.toString();
    }

    @Test
    public void test(){
        n006 t = new n006();
        System.out.println(t.convert("abcdefg", 2));
    }

}
