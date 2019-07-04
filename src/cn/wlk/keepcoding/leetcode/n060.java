package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/7/4 10:51
 * author:WLK
 * <p>
 * 60. 第k个排列
 * <p>
 * 给出集合 [1,2,3,…,n]，其所有元素共有 n! 种排列。
 * <p>
 * 按大小顺序列出所有排列情况，并一一标记，当 n = 3 时, 所有排列如下：
 * <p>
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * <p>
 * 给定 n 和 k，返回第 k 个排列。
 * <p>
 * 说明：
 * <p>
 * 给定 n 的范围是 [1, 9]。
 * 给定 k 的范围是[1,  n!]。
 * <p>
 * 示例 1:
 * <p>
 * 输入: n = 3, k = 3
 * 输出: "213"
 * <p>
 * 示例 2:
 * <p>
 * 输入: n = 4, k = 9
 * 输出: "2314"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutation-sequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：直接一步一步的计算每一位的数字应该是什么，（最开始k的下标是从1开始的，将其转换为从0开始（k--），，相当方便了）
 *              从结果的最高位开始推算：每次选取[1,n]区间内没用过的数字，当作当前位的结果
 */
public class n060 {
    @Test
    public void test() {
        n060 t = new n060();
//        String re = t.getPermutation(4, 9);
//        String re = t.getPermutation(2,2);
        String re = t.getPermutation(3,3);
        System.out.println(re);
    }


    public String getPermutation(int n, int k) {
        StringBuilder sb = new StringBuilder();
        k --;
        boolean[] isvisited = new boolean[10];
        choose(n, k, sb, isvisited);
        return sb.toString();

    }

    public void choose(int n, int k, StringBuilder sb, boolean[] isvisited) {
        int nn_1 = nn(n - 1);
        int pick = -1;
        pick = pickOne(isvisited, k / nn_1);
        sb.append(pick + "");

        isvisited[pick] = true;

        if (n > 1) {
            choose(n - 1, k%nn_1, sb, isvisited);
        }
    }

    public int pickOne(boolean[] isvisited, int k) {
        for (int i = 1; i <= 9; i++) {
            if (!isvisited[i]) {
                if (k == 0)
                    return i;
                k--;
            }
        }
        return -1;
    }

    public int nn(int n) {
        int result = 1;
        for (int i = 2; i <= n; i++) {
            result = result * i;
        }
        return result;
    }

}