package cn.wlk.keepcoding.SwordOffe2;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

/**
 * 2020/3/2 10:47
 * author:WLK
 *
 * 面试题04. 二维数组中的查找
 *
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 *
 *
 *
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 *
 * 解法：由矩阵的左下角、右上角开始比较即可，每次移动一行或一列
 */

public class TP004 {

    @Test
    public void test() {
        TP004 t = new TP004();
        int[][] matrix = Utils.createintInintFromString("" +
                "[[1,4,7,11,15]," +
                "[2,5,8,12,19]," +
                "[3,6,9,16,22]," +
                "[10,13,14,17,24]," +
                "[18,21,23,26,30]]");
        System.out.println(t.findNumberIn2DArray(matrix,5));
    }

    public boolean findNumberIn2DArray(int[][] matrix, int target) {


        int M  = matrix.length;
        if(M==0){
            return false;
        }
        int N = matrix[0].length;
        int a_x=M-1,a_y=0,b_x=0,b_y=N-1;
        while(a_y<=b_y && a_x>=b_x){
            System.out.println(matrix[a_x][a_y]+"\t"+matrix[b_x][b_y]);
            if(matrix[a_x][a_y]==target || matrix[b_x][b_y]==target){
                return  true;
            }

            if(matrix[a_x][a_y]>target){
                a_x--;
            }else {
                a_y++;
            }

            if(matrix[b_x][b_y]>target){
                b_y--;
            }else{
                b_x++;
            }
        }

        return false;
    }

}
