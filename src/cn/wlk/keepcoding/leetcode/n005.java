package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 5. 最长回文子串
 * <p>
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * <p>
 * 示例 1：
 * <p>
 * 输入: "babad"
 * 输出: "bab"
 * 注意: "aba"也是一个有效答案。
 * 示例 2：
 * <p>
 * 输入: "cbbd"
 * 输出: "bb"
 */
//done
public class n005 {

    /**
     * 使用动态规划方法
     *
     * @param s
     * @return
     */
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();

        int len = chars.length;
        if(len==0)
            return "";
        if(len==1)
            return s;
        boolean[][] dp = new boolean[len][len];
        int maxlen = 1;
        int start = 0;
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            if(i<len-1&&chars[i]==chars[i+1]){
                dp[i][i+1]=true;
                maxlen = 2;
                start = i;
            }
        }

        for (int strlen = 3; strlen <= len; strlen++) {
         //   System.out.println("strlen:"+strlen);
            for (int i = 0; i <= len - strlen; i++) {

                int j = i + strlen - 1;
               // System.out.println("\ti:j="+i+":"+j);
                if (dp[i + 1][j - 1] && chars[i] == chars[j]) {
                    dp[i][j] = true;
                    maxlen = strlen;
                    start = i;
                }
            }
        }
        return s.substring(start, maxlen + start);

    }


    @Test
    public void test() {
        n005 t = new n005();
//        System.out.println(t.longestPalindrome("babad"));
//        System.out.println(t.longestPalindrome("abcba"));
        System.out.println(t.longestPalindrome("a"));
        System.out.println(t.longestPalindrome("ab"));
        System.out.println(t.longestPalindrome("abcdcba"));
        System.out.println(t.longestPalindrome(""));
    }

}
