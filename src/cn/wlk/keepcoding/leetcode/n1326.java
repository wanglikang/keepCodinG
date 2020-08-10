package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/4/20 11:45
 * author:WLK
 *
 * 1326. 灌溉花园的最少水龙头数目
 *
 * 在 x 轴上有一个一维的花园。花园长度为 n，从点 0 开始，到点 n 结束。
 *
 * 花园里总共有 n + 1 个水龙头，分别位于 [0, 1, ..., n] 。
 *
 * 给你一个整数 n 和一个长度为 n + 1 的整数数组 ranges ，其中 ranges[i] （下标从 0 开始）表示：如果打开点 i 处的水龙头，可以灌溉的区域为 [i -  ranges[i], i + ranges[i]] 。
 *
 * 请你返回可以灌溉整个花园的 最少水龙头数目 。如果花园始终存在无法灌溉到的地方，请你返回 -1 。
 *
 *
 *
 * 示例 1：
 *
 * 输入：n = 5, ranges = [3,4,1,1,0,0]
 * 输出：1
 * 解释：
 * 点 0 处的水龙头可以灌溉区间 [-3,3]
 * 点 1 处的水龙头可以灌溉区间 [-3,5]
 * 点 2 处的水龙头可以灌溉区间 [1,3]
 * 点 3 处的水龙头可以灌溉区间 [2,4]
 * 点 4 处的水龙头可以灌溉区间 [4,4]
 * 点 5 处的水龙头可以灌溉区间 [5,5]
 * 只需要打开点 1 处的水龙头即可灌溉整个花园 [0,5] 。
 *
 * 示例 2：
 *
 * 输入：n = 3, ranges = [0,0,0,0]
 * 输出：-1
 * 解释：即使打开所有水龙头，你也无法灌溉整个花园。
 *
 * 示例 3：
 *
 * 输入：n = 7, ranges = [1,2,1,0,2,1,0,1]
 * 输出：3
 *
 * 示例 4：
 *
 * 输入：n = 8, ranges = [4,0,0,0,0,0,0,0,4]
 * 输出：2
 *
 * 示例 5：
 *
 * 输入：n = 8, ranges = [4,0,0,0,4,0,0,0,4]
 * 输出：1
 *
 *
 *
 * 提示：
 *
 *     1 <= n <= 10^4
 *     ranges.length == n + 1
 *     0 <= ranges[i] <= 100
 *
 *
 * 解法：使用动态规划dp[i]:覆盖到第i个位置的时候，使用的最少水龙头个数
 *      并使用额外的空间pre记录区间信息：pre[r]=l,即覆盖的区间[l,r]，即以右端点作为基准记录区间信息
 *      然后在动态规划求解的时候，遍历每一个位置i
 *          计算从[pre[i],i-1]区间内各个位置上的点，所代表的区间，
 *              使用dp[i]=min(dp[i],dp[j]+1)进行求解
 */

public class n1326 {

    @Test
    public void test() {
        n1326 t = new n1326();
//        int n = 3;
//        int[] ranges = new int[]{0,0,0,0};//-1

        int n = 5;
        int[] ranges = new int[]{3,4,1,1,0,0};
        System.out.println(t.minTaps(n,ranges));
    }


    public int minTaps(int n, int[] ranges) {

        //使用动态规划
        int[] pre = new int[n+1];

        for(int i = 0;i<=n;i++){
            pre[i]=i;//赋初始值，为自身，即区间长度为0
        }
        for(int i = 0;i<=n;i++){
            int l = Math.max(i-ranges[i],0);
            int r = Math.min(i+ranges[i],n);
            pre[r] = Math.min(pre[r],l);
        }

        int[] dp = new int[n+1];//dp[i]的意思是到第i个位置所使用的最小水龙头个数
        for(int i = 0;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
        }

        dp[0]=0;
        for(int i = 1;i<=n;i++){
            for(int j = pre[i];j<i;j++){//使用dp遍历区间在[pre[r],r)之间的区间
                if(dp[j]!=Integer.MAX_VALUE){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }

        Utils.showArray(pre);
        System.out.println();
        Utils.showArray(dp);
        System.out.println();
        return dp[n]==Integer.MAX_VALUE?-1:dp[n];

    }




}

