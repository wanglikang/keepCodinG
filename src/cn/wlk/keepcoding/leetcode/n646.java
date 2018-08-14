package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 646. 最长数对链
 * 给出 n 个数对。 在每一个数对中，第一个数字总是比第二个数字小。
 * <p>
 * 现在，我们定义一种跟随关系，当且仅当 b < c 时，数对(c, d) 才可以跟在 (a, b) 后面。我们用这种形式来构造一个数对链。
 * <p>
 * 给定一个对数集合，找出能够形成的最长数对链的长度。你不需要用到所有的数对，你可以以任何顺序选择其中的一些数对来构造。
 * <p>
 * 示例 :
 * <p>
 * 输入: [[1,2], [2,3], [3,4]]
 * 输出: 2
 * 解释: 最长的数对链是 [1,2] -> [3,4]
 * 注意：
 * <p>
 * 给出数对的个数在 [1, 1000] 范围内。
 */
//done

/**
 * 解法：
 *      自定义排序+最长上升子序列
 */
public class n646 {
    public int findLongestChain(int[][] pairs) {
        List<int[]> pas = new ArrayList<>();
        for (int[] p : pairs) {
            pas.add(p);
        }
        Comparator<int[]> com = new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] < o2[0])
                    return -1;
                else if (o1[0] == o2[0])
                    return 0;
                else return 1;
            }
        };
        //Collections.sort(pas, (a,b)->(a[0]-b[0]));
        Collections.sort(pas, com);
//        for(int[] i:pas){
//            System.out.println(i[0]+":"+i[1]);
//        }

        int[] dp = new int[pas.size()];
        dp[0]=1;
        for (int i = 1; i < pas.size(); i++) {
            for (int j = 0; j < i; j++) {
                if (pas.get(j)[1] < pas.get(i)[0]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } else {
                    dp[i] = Math.max(dp[i], dp[j]);
                }
            }
        }
     //   Utils.showArray(dp);
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        n646 t = new n646();
        int[][] paris = {
                {1, 2}, {2, 3}, {3, 4}
        };
        System.out.println(t.findLongestChain(paris));
        System.out.println();
    }

}
