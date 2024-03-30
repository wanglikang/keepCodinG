package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/31 14:32
 * author:WLK
 */

/**题目描述 抽牌
 * url：
 * https://www.nowcoder.com/practice/8b8c4fc44b614862b2a4f53771577995?tpId=90&tqId=30855&tPage=2&rp=2&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 *
 * 解法：使用递归模拟计算过程即可
 *        但是若使用暴力模拟，，则会超时，可以将中间结构存储起来。就能通过了。
 *
 */
public class chooseCard {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),P = scanner.nextInt(),Q = scanner.nextInt();
        double p = P*1.0/100,q = Q*1.0/100;
        int[] arr = new int[n];
        double[][] dp=new double[n][n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        double result = xiaoming(arr, 0, n - 1, p, q,dp);
        System.out.printf("%.3f",result);
    }
    public static double xiaoming(int[] arr,int left,int right,double p,double q,double[][] dp){
        if(left==right){
            return arr[left];
        }
        if(left>right)
            return 0;
        if((Math.abs(dp[left][right]-0.0)<0.00000000001)) {
            double expL = arr[left] * p;
            double expR = arr[right] * (1 - p);
            expL +=
                    p * (xiaoming(arr, left + 1 + 1, right, p, q, dp) * q +
                            xiaoming(arr, left + 1, right - 1, p, q, dp) * (1 - q));
            expR +=
                    (1 - p) * (xiaoming(arr, left + 1, right - 1, p, q, dp) * q +
                            xiaoming(arr, left, right - 1 - 1, p, q, dp) * (1 - q));
            dp[left][right] = expL + expR;
            return expL+expR;
        }else return dp[left][right];


    }
}
