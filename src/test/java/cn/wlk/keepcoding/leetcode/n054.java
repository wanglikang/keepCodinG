package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 2019/4/13-9:37
 * author:WLK
 * 54. 螺旋矩阵
 * <p>
 * 给定一个包含 m x n 个元素的矩阵（m 行, n 列），请按照顺时针螺旋顺序，返回矩阵中的所有元素。
 * <p>
 * 示例 1:
 * <p>
 * 输入:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * 输出: [1,2,3,6,9,8,7,4,5]
 * <p>
 * 示例 2:
 * <p>
 * 输入:
 * [
 * [1, 2, 3, 4],
 * [5, 6, 7, 8],
 * [9,10,11,12]
 * ]
 * 输出: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * 解法：常规题
 */
public class n054 {
    @Test
    public void test() {
        n054 t = new n054();
        int[] arr1 = {1,1,2,3,4};
        int[][] arr = {arr1};
        t.spiralOrder(arr).stream().forEach(x -> System.out.print(x + " "));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        int m = matrix.length;
        if(m==0)
            return result;
        int n = matrix[0].length;

        int x = 0, y = 0;
        while (m > 0 && n > 0) {
            result.addAll(addSub(matrix, x++, y++, m, n));
            m -= 2;
            n -= 2;
        }
        return result;
    }

    public List<Integer> addSub(int[][] matrix, int x, int y, int m, int n) {
        List<Integer> result = new ArrayList<>();
        int i = x, j = y;
        if(m==1){
            while(j<y+n){
                result.add(matrix[i][j++]);
            }
            return result;
        }else if(n==1){
            while (i<x+m){
                result.add(matrix[i++][j]);
            }
            return result;
        }

        while (j < y + n-1) {
            result.add(matrix[i][j++]);
        }
        while (i < x + m-1) {
            result.add(matrix[i++][j]);
        }
        while (j > y) {
            result.add(matrix[i][j--]);
        }
        while (i > x) {
            result.add(matrix[i--][j]);
        }
        return result;
    }

}