package cn.wlk.keepcoding.basealgorithm;

import org.junit.Test;

/**
 * 动态规划之
 * 最长公共子序列问题：LCSE
 *  解法：对于str1和str2
 *      dp[i][j]的含义是： str1[0....i]和str2[0......j]的最长公共子序列的长度
 *          dp第一行dp[0][j]：若str1【0】和str2的某个字符相等，，则置为1 ，且只会的所有dp[0][j]都为1
 *          dp第一列同理
 *          dp[i][j]的取值可能来自以下三种情况中的最大值：
 *              dp[i-1][j]
 *              dp[i][j-1]
 *              dp[i-1][j-1]:如果str1[i]==str2[j]的话
 *
 *
 *       利用dp数组反向求最长公共子序列的过程：
 *           从dp[len1-1][len2-1]开始移动，反向还原求dp数组的过程，即可
 *              就是向右向上找到第一个dp数组内不同的下标对应的字符，添加进结果集即可
 */
public class LCSE {
    @Test
    public void test() {
        String str1 = "1A2C3D4B56";
        String str2 = "B1D23CA45B6A";
        int[][] dp = getDP(str1, str2);
        for (int i = 0; i < str1.length(); i++) {
            for (int j = 0; j < str2.length(); j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        String result = getLCSE(str1, str2, dp);
        System.out.println(result);

    }

    public int[][] getDP(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[][] dp = new int[len1][len2];
        dp[0][0] = arr1[0] == arr2[0] ? 1 : 0;
        for (int i = 1; i < len1; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], arr1[i] == arr2[0] ? 1 : 0);
        }
        for (int i = 1; i < len2; i++) {
            dp[0][i] = Math.max(dp[0][i - 1], arr2[i] == arr1[0] ? 1 : 0);
        }
        for (int i = 1; i < len1; i++) {
            for (int j = 1; j < len2; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (arr1[i] == arr2[j])
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + 1);
            }
        }
        return dp;
    }

    public String getLCSE(String str1, String str2, int[][] dp) {
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int len1 = arr1.length;
        int len2 = arr2.length;
        StringBuilder sb = new StringBuilder();
        int i = len1 - 1, j = len2 - 1;
        int resultindex = dp[len1 - 1][len2 - 1]-1;
        System.out.println(resultindex);
        while (resultindex > 0) {
            if (i > 0 && dp[i][j] == dp[i - 1][j]) {
                i--;
            } else if (j > 0 && dp[i][j] == dp[i][j - 1]) {
                j--;
            } else {
                sb.insert(0, arr2[j]);
                i--;
                j--;
                resultindex--;
            }
        }
        sb.insert(0, i == 0 ? arr1[0] : arr2[0]);
        return sb.toString();
    }
}
