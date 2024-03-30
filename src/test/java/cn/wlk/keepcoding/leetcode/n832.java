package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;


/**
 * 给定一个二进制矩阵 A，我们想先水平翻转图像，然后反转图像并返回结果。
 * 水平翻转图片就是将图片的每一行都进行翻转，即逆序。例如，水平翻转 [1, 1, 0] 的结果是 [0, 1, 1]。
 * 反转图片的意思是图片中的 0 全部被 1 替换， 1 全部被 0 替换。例如，反转 [0, 1, 1] 的结果是 [1, 0, 0]。
 * 示例 1:
 * 输入: [[1,1,0],[1,0,1],[0,0,0]]
 * 输出: [[1,0,0],[0,1,0],[1,1,1]]
 * 解释: 首先翻转每一行: [[0,1,1],[1,0,1],[0,0,0]]；
 *      然后反转图片: [[1,0,0],[0,1,0],[1,1,1]]

 * 示例 2:
 * 输入: [[1,1,0,0],
 *      [1,0,0,1],
 *      [0,1,1,1],
 *      [1,0,1,0]]
 * 输出: [[1,1,0,0],
 *       [0,1,1,0],
 *       [0,0,0,1],
 *       [1,0,1,0]]
 * 解释: 首先翻转每一行: [
 * [0,0,1,1],
 * [1,0,0,1],
 * [1,1,1,0],
 * [0,1,0,1]]；
 *      然后反转图片: [
 *      [1,1,0,0],
 *      [0,1,1,0],
 *      [0,0,0,1],
 *      [1,0,1,0]]
 * 说明:
 *
 * 1 <= A.length = A[0].length <= 20
 * 0 <= A[i][j] <= 1
 */
//done
public class n832 {
    public int[][] flipAndInvertImage(int[][] A) {
        int i = A.length;
        int j = 0;
        if(i>0){
            j = A[0].length;
        }else return A;
        int[][] result = new int[i][j];//Arrays.copyOf(A,i);

        for(int a = 0;a<i;a++){
            for(int b = 0;b<j;b++){
                result[a][b] = A[a][j-b-1]==1?0:1;
            }
        }
        return result;
    }

    @Test
    public void test() {
        n832 n = new n832();
        int[][] A = {
                {1,1,0,0},
                {1,0,0,1},
                {0,1,1,1},
                {1,0,1,0}};
        int[][] re = n.flipAndInvertImage(A);
        for(int i = 0;i<re.length;i++){
            for(int j = 0;j<re[0].length;j++){
                System.out.print(re[i][j]+" ");
            }
            System.out.println();
        }

    }

}
