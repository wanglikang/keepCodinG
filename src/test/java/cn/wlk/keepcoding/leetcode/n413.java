package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 413. 等差数列划分
 * <p>
 * 如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。
 * <p>
 * 例如，以下数列为等差数列:
 * <p>
 * 1, 3, 5, 7, 9
 * 7, 7, 7, 7
 * 3, -1, -5, -9
 * 以下数列不是等差数列。
 * <p>
 * 1, 1, 2, 5, 7
 * <p>
 * <p>
 * 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。
 * <p>
 * 如果满足以下条件，则称子数组(P, Q)为等差数组：
 * <p>
 * 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。
 * <p>
 * 函数要返回数组 A 中所有为等差数组的子数组个数。
 * <p>
 * <p>
 * <p>
 * 示例:
 * <p>
 * A = [1, 2, 3, 4]
 * <p>
 * 返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
 */
//done

/**
 * 解法：
 *      参考：https://blog.csdn.net/xiangwanpeng/article/details/53097771
 */
public class n413 {
    public int numberOfArithmeticSlices(int[] A) {
        int len = A.length;
        if (len < 3)
            return 0;
        int i;
        int dif = A[1] - A[0];
        int res = 0, num = 1;
        for (i = 2; i < len; i++) {
            if (A[i] - A[i - 1] == dif) {
                res += num++;
            } else {
                dif = A[i] - A[i - 1];
                num = 1;
            }
        }

        return res;
    }

    @Test
    public void test() {
        n413 t = new n413();
        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(t.numberOfArithmeticSlices(nums));
        System.out.println();
    }

}
