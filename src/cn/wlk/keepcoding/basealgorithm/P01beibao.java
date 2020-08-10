package cn.wlk.keepcoding.basealgorithm;

/**
 * 2020/4/3 16:07
 * author:WLK
 */

/**
 * 01背包问题的解法，没有使用压缩算法
 */
public class P01beibao {
    /**
     *
     * @param w 重量数组.以1为下标起点
     * @param v 价值数组，以1为下标起点
     * @param T 最大容量
     * @return 可装的最大价值
     */
    public  static int do01(int[] w,int v[],int T){
        int n = w.length-1;
        int[][] dp = new int[n+1][T+1];
        for(int i = 1;i<=n;i++){
            for(int j = T;j>0;j--){
                if(j<w[i]){
                    dp[i][j]=dp[i-1][j];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i-1][j-w[i]]+v[i]);
                }
            }
        }
        return dp[n][T];
    }

    /**
     * 使用了压缩算法的01背包问题
     * @param w
     * @param v
     * @param T
     * @return
     */
    public  static int do01Comp(int[] w,int v[],int T){
        int n = w.length-1;
        int[] dp = new int[T+1];
        for(int i = 1;i<=n;i++){
            for(int j = T;j>0;j--){
                dp[j] = Math.max(dp[j],dp[j-w[i]]+v[i]);
            }
        }
        return dp[T];
    }
}
