package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 338. 比特位计数
 * <p>
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 2
 * 输出: [0,1,1]
 * 示例 2:
 * <p>
 * 输入: 5
 * 输出: [0,1,1,2,1,2]
 * 进阶:
 * <p>
 * 给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
 * 要求算法的空间复杂度为O(n)。
 * 你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 */
//done
public class n338 {
    public int[] countBits(int num) {
        int len = num + 1;
        int dp[] = new int[len];
        int interval = 1;

        while (interval < len) {
            dp[interval] = 1;//2的n次方的二进制位中1的个数都是1个
            //System.out.println(interval);
            for (int i = interval + 1; i < len && i < interval * 2; i++) {
                dp[i] = 1 + dp[i - interval];
            }
            interval = interval * 2;
        }
        return dp;
    }

    @Test
    public void test() {
        n338 t = new n338();
        int[] reuslt = t.countBits(0);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
        reuslt = t.countBits(1);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
        reuslt = t.countBits(2);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
        reuslt = t.countBits(3);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
        reuslt = t.countBits(4);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
        reuslt = t.countBits(5);
        for (int i : reuslt)
            System.out.print(i + " ");
        System.out.println();
    }
}
