package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 712. 两个字符串的最小ASCII删除和
 * <p>
 * 给定两个字符串s1, s2，找到使两个字符串相等所需删除字符的ASCII值的最小和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: s1 = "sea", s2 = "eat"
 * 输出: 231
 * 解释: 在 "sea" 中删除 "s" 并将 "s" 的值(115)加入总和。
 * 在 "eat" 中删除 "t" 并将 116 加入总和。
 * 结束时，两个字符串相等，115 + 116 = 231 就是符合条件的最小和。
 * 示例 2:
 * <p>
 * 输入: s1 = "delete", s2 = "leet"
 * 输出: 403
 * 解释: 在 "delete" 中删除 "dee" 字符串变成 "let"，
 * 将 100[d]+101[e]+101[e] 加入总和。在 "leet" 中删除 "e" 将 101[e] 加入总和。
 * 结束时，两个字符串都等于 "let"，结果即为 100+101+101+101 = 403 。
 * 如果改为将两个字符串转换为 "lee" 或 "eet"，我们会得到 433 或 417 的结果，比答案更大。
 * 注意:
 * <p>
 * 0 < s1.length, s2.length <= 1000。
 * 所有字符串中的字符ASCII值在[97, 122]之间。
 */
//done

/**
 * 解法：
 *      参考：https://blog.csdn.net/obrcnh/article/details/78378773
 */
public class n712 {
    public int minimumDeleteSum(String s1, String s2) {
        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        dp[0][0] = 0;
        for (int i = 1; i < len1; i++)
            dp[i][0] = dp[i - 1][0] + chars1[i - 1];

        for (int i = 1; i < len2; i++)
            dp[0][i] = dp[0][i - 1] + chars2[i - 1];

        int cost;
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                cost = 0;
                if (chars1[i-1] != chars2[j-1])
                    cost = chars1[i - 1] + chars2[j - 1];
                dp[i][j] = Math.min(
                        Math.min(
                                dp[i - 1][j] + chars1[i - 1],
                                dp[i][j - 1] + chars2[j - 1]
                        ),
                        cost + dp[i - 1][j - 1]);
            }
        }

        for(int i = 0;i<=len1;i++) {
            for (int j = 0; j <= len2; j++)
                System.out.print(dp[i][j] + " ");
            System.out.println();
        }
        return dp[len1][len2];

    }

    @Test
    public void test() {
        n712 t = new n712();
        System.out.println(t.minimumDeleteSum("delete", "leet"));
        System.out.println();
    }

}
