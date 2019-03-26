package cn.wlk.keepcoding.basealgorithm;

import org.junit.Test;

/**
 * 动态规划之
 *  最长公共子串
 */
public class LCST {

    @Test
    public  void test(){
        String str1 = "1AB2345CD";
        String str2 = "12345EF";
        getDP(str1, str2);
    }
    public  int[][] getDP(String str1,String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        char[] arr1 = str1.toCharArray();
        char[] arr2 = str2.toCharArray();
        int[][] dp = new int[len1][len2];
        for(int i = 0;i<len1;i++){
            if(arr2[0]==arr1[i]){
                dp[i][0]=1;
            }
        }
        for(int j = 0;j<len2;j++){
            if(arr1[0]==arr2[j]){
                dp[0][j]=1;
            }
        }
//        对于其他位置，则只有两种情况可以考虑：
//              arr1[i]和arr2[j]对应相等
//              arr1[i]和arr2[j]对应不等
        int indexi = 0;
        int maxCount = 0;
        for(int i = 1;i<len1;i++){
            for(int j = 1;j<len2;j++){
                if(arr1[i]==arr2[j]){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else dp[i][j]=0;
                if(maxCount<dp[i][j]){
                    maxCount=dp[i][j];
                    indexi=i;
                }
            }
        }
        showDP(dp);
        System.out.println(str1.substring(indexi-maxCount+1, indexi+1));
        return dp;
    }
    public void showDP(int[][] dp){
        for(int i = 0;i<dp.length;i++){
            for(int j = 0;j<dp[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

    }
}
