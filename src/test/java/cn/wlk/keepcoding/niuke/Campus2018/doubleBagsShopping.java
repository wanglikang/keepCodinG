package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/31 10:28
 * author:WLK
 */

/**
 * 题目描述 双袋购物
 * 链接：https://www.nowcoder.com/practice/54bd1b269fee430cac0595a422cc6a5a?tpId=90&tqId=30857&tPage=2&rp=2&ru=/ta/2018test&qru=/ta/2018test/question-ranking
 *
 * 解法：01背包问题的变种
 *      设两个DP：BagA，BagB，分别从左向右、从右向左，计算最大的价值
 *      然后在以某个物品i为分割点，找出左右相加的最大值
 *          以及全部用A，和全部用B
 *          它们共同的最大值。
 */
public class doubleBagsShopping {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), A = scanner.nextInt(), B = scanner.nextInt();
        int weight[] = new int[n + 1];
        int value[] = new int[n + 1];
//        int[] BagA = new int[A + 1];
        int[][] BagA = new int[n+1][A + 1];
        int[][] BagB = new int[n+1+1][B + 1];
        for (int i = 1; i <= n; i++) {
            weight[i] = scanner.nextInt();
            value[i] = scanner.nextInt();
        }

//        for (int i = 1; i <= n; i++) {
//            for (int j = A; j >= weight[i]; j--) {
//                BagA[i][j] = Math.max(BagA[i-1][j], BagA[i-1][j - weight[i]] + value[i]);
//            }
//        }
        for(int i =1;i<=n;i++){
            for(int j  = 1;j<=A;j++){
                if(j<weight[i])
                    BagA[i][j]=BagA[i-1][j];
                else
                    BagA[i][j]=Math.max(BagA[i-1][j],BagA[i-1][j-weight[i]]+value[i]);
            }
        }

        for(int i =n;i>0;i--){
            for(int j  = 1;j<=B;j++){
                if(j<weight[i])
                    BagB[i][j]=BagB[i+1][j];
                else
                    BagB[i][j]=Math.max(BagB[i+1][j],BagB[i+1][j-weight[i]]+value[i]);
            }
        }
        int maxResult = 0;
        for(int i = 1;i<n;i++){
            maxResult=Math.max(maxResult,BagA[i][A]+BagB[i+1][B]);
        }
        maxResult=Math.max(maxResult,BagA[n][A]);
        maxResult=Math.max(maxResult, BagB[1][B]);
//        System.out.println("-----------------");
//        for(int i = 1;i<=n;i++) {
//            for (int j = 1; j <= A; j++) {
//                System.out.print(BagA[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------");
//        for(int i = 1;i<=n;i++) {
//            for (int j = 1; j <= B; j++) {
//                System.out.print(BagB[i][j] + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println("-----------------");
        System.out.println(maxResult);
    }

}
