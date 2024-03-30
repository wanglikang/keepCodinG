package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 * 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *
 * 说明：
 *
 * 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。
 */
//done

/**
 * 解题方法：
 *      参考了：https://blog.csdn.net/smile_watermelon/article/details/46741303
 *      因为需要使用O(n)的空间复杂度，所以可以倒过来算，算从最后一行到第一行的最小路径即可，
 *      也即从最左下开始总左往右、从下往上开始计算即可
 */
public class n120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        int i = triangle.size();
        int n = triangle.get(triangle.size()-1).size();
        int[] dp = new int[i];//dp[i]记录在第i-1行为止最小的路径和
        for(int j = 0;j<n;j++){
            dp[j] =triangle.get(triangle.size()-1).get(j);
            //System.out.print(dp[j]+" ");
        }
        for (int a = i - 2; a >= 0; a--) {
            for (int b = 0; b < triangle.get(a ).size(); b++) {
                dp[b] = Math.min(dp[b], dp[b+1]) + triangle.get(a).get(b);
              //  System.out.print(dp[b]+" ");
            }
//            System.out.println();
        }

        return dp[0];
    }
    @Test
    public void test() {
        n120 t = new n120();
        List<List<Integer>> traingle = new ArrayList<>();
        List<Integer> l1 = new ArrayList<>();
        l1.add(2);
        List<Integer> l2 = new ArrayList<>();
        l2.add(3);
        l2.add(4);
        List<Integer> l3 = new ArrayList<>();
        l3.add(6);
        l3.add(5);
        l3.add(7);
        List<Integer> l4 = new ArrayList<>();
        l4.add(4);
        l4.add(1);
        l4.add(8);
        l4.add(3);
        traingle.add(l1);
        traingle.add(l2);
        traingle.add(l3);
        traingle.add(l4);
        System.out.println(t.minimumTotal(traingle));
    }

}
