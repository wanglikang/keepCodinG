package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 96. 不同的二叉搜索树
 * <p>
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * <p>
 * 示例:
 * <p>
 * 输入: 3
 * 输出: 5
 * 解释:
 * 给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
 * <p>
 * 1         3     3      2      1
 * \       /     /      / \      \
 * 3     2     1      1   3      2
 * /     /       \                 \
 * 2     1         2                 3
 */

//done
public class n096 {
    public int numTrees(int n) {
        if (n < 3)
            return n;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            for (int j = 0; j < i; j++) {//对不同左右子树的组合进行分步相乘并相加
                dp[i] += dp[j] * dp[i-1 - j];
            }
        }
        return dp[n];
    }

    @Test
    public void test() {
        n096 t = new n096();
        System.out.println(t.numTrees(3));
        System.out.println();
    }

}
