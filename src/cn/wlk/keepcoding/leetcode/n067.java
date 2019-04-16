package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.nio.CharBuffer;

/**
 * 2019/4/16-10:23
 * author:WLK
 * <p>
 * 67. 二进制求和
 * <p>
 * 给定两个二进制字符串，返回他们的和（用二进制表示）。
 * <p>
 * 输入为非空字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * <p>
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * <p>
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 *
 * 解法：简单题，，，但，据说python代码就一行？？？？？：return bin(int(a,2)+int(b,2))[2:]
 */
public class n067 {
    @Test
    public void test() {
        n067 t = new n067();
        String result = t.addBinary("1010", "0");
        //   1010
        //  10111
        // 100001
        System.out.println(result);
    }

    public String addBinary(String a, String b) {
        if (a.equals("0")) return b;
        if (b.equals("0")) return a;

        char[] chara = a.toCharArray();
        char[] charb = b.toCharArray();
        int len1 = chara.length;
        int len2 = charb.length;
        int jinwei = 0;
        int sum = 0;
        int i = len1 - 1, j = len2 - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {

            if (chara[i] == '0' && charb[j] == '0') {
                sum = 0+jinwei;
            } else if (chara[i] == '1' && charb[j] == '0') {
                sum = 1+jinwei;
            } else if (chara[i] == '0' && charb[j] == '1') {
                sum = 1+jinwei;
            } else if (chara[i] == '1' && charb[j] == '1') {
                sum = 0+jinwei;
                sum+=2;
            }
            i--;
            j--;
            jinwei = sum/2;
            sum = sum%2;
            sb.insert(0,sum+"");

        }
        while(i>=0){
            if(chara[i]=='0'){
                sum = 0+jinwei;
            }else {
                sum = 1+jinwei;
            }
            jinwei = sum/2;
            sum = sum%2;
            sb.insert(0,sum+"");
            i--;
        }
        while(j>=0){
            if(charb[j]=='0'){
                sum = 0+jinwei;
            }else {
                sum = 1+jinwei;
            }
            jinwei = sum/2;
            sum = sum%2;
            sb.insert(0,sum+"");
            j--;
        }
        if(jinwei>0){
            sb.insert(0,jinwei%2+"");
        }

        return sb.toString();
    }


}