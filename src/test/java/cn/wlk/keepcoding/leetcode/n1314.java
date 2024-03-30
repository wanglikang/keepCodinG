package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/3/29 17:57
 * author:WLK
 *
 * 1314. 矩阵区域和
 *
 * 给你一个 m * n 的矩阵 mat 和一个整数 K ，请你返回一个矩阵 answer ，其中每个 answer[i][j] 是所有满足下述条件的元素 mat[r][c] 的和：
 *
 *     i - K <= r <= i + K, j - K <= c <= j + K
 *     (r, c) 在矩阵内。
 *
 *
 *
 * 示例 1：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 1
 * 输出：[[12,21,16],[27,45,33],[24,39,28]]
 *
 * 示例 2：
 *
 * 输入：mat = [[1,2,3],[4,5,6],[7,8,9]], K = 2
 * 输出：[[45,45,45],[45,45,45],[45,45,45]]
 *
 *
 *
 * 提示：
 *
 *     m == mat.length
 *     n == mat[i].length
 *     1 <= m, n, K <= 100
 *     1 <= mat[i][j] <= 100
 *
 *
 *
 * 解法：直接求就好了
 */

public class n1314 {

    @Test
    public void test() {
        n1314 t = new n1314();
        int[][] mat = Utils.createintInintFromString("[[67,64,78],[99,98,38],[82,46,46],[6,52,55],[55,99,45]]");
        int[][] re = t.matrixBlockSum(mat, 3);
        Utils.showArray(re);
    }

    public int[][] matrixBlockSum(int[][] mat, int K) {
        if(K==0){
            return mat;
        }

        int m = mat.length;
        int n = mat[0].length;
        int[][] result = new int[m][n];


        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){

                int sum = 0;
                for(int ii = i-K;ii<=i+K;ii++){
                    for(int jj = j-K;jj<=j+K;jj++){
                        if(ii>=0 && ii<m && jj>=0 && jj<n){
                            sum+=mat[ii][jj];
                        }

                    }
                }

                result[i][j] = sum;
            }
        }


        return result;


    }
}
