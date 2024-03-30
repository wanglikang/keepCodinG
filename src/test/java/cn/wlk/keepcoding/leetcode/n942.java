package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/10-11:27
 * author:WLK
 * 简单题
 * 942. 增减字符串匹配
 * 给定只含 "I"（增大）或 "D"（减小）的字符串 S ，令 N = S.length。
 *
 * 返回 [0, 1, ..., N] 的任意排列 A 使得对于所有 i = 0, ..., N-1，都有：
 *
 *     如果 S[i] == "I"，那么 A[i] < A[i+1]
 *     如果 S[i] == "D"，那么 A[i] > A[i+1]
 *
 *
 *
 * 示例 1：
 *
 * 输出："IDID"
 * 输出：[0,4,1,3,2]
 *
 * 示例 2：
 *
 * 输出："III"
 * 输出：[0,1,2,3]
 *
 * 示例 3：
 *
 * 输出："DDI"
 * 输出：[3,2,0,1]
 *
 *
 *
 * 提示：
 *
 *     1 <= S.length <= 1000
 *     S 只包含字符 "I" 或 "D"。
 *
 * 解法：对I或D，，分开求，I从0开始增，D从N开始减，最后一个数组置为D减到的当前值即可
 *      思路清奇
 */
public class n942 {
    @Test
    public void test() {
        n942 t = new n942();
        Arrays.stream(t.diStringMatch("IID")).forEach(x-> System.out.print(x+" "));
    }
    public int[] diStringMatch(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        int leftnum = 0;
        int rightnum = len;
        int[] result = new int[len+1];
        int index = 0;
        for(int i  =  0;i<len;i++) {
            if (chars[i] == 'I') {
                result[index++] = leftnum++;
            } else {
                result[index++] = rightnum--;
            }
        }
        result[index++]=rightnum;
        return result;
    }

}