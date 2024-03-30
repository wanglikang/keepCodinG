package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2020/2/29 12:07
 * author:WLK
 *
 * 面试题 01.07. 旋转矩阵
 *
 * 给定一幅由N × N矩阵表示的图像，其中每个像素的大小为4字节，编写一种方法，将图像旋转90度。
 *
 * 不占用额外内存空间能否做到？
 *
 *
 *
 * 示例 1:
 *
 * 给定 matrix =
 * [
 *   [1,2,3],
 *   [4,5,6],
 *   [7,8,9]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [7,4,1],
 *   [8,5,2],
 *   [9,6,3]
 * ]
 *
 * 示例 2:
 *
 * 给定 matrix =
 * [
 *   [ 5, 1, 9,11],
 *   [ 2, 4, 8,10],
 *   [13, 3, 6, 7],
 *   [15,14,12,16]
 * ],
 *
 * 原地旋转输入矩阵，使其变为:
 * [
 *   [15,13, 2, 5],
 *   [14, 3, 4, 1],
 *   [12, 6, 8, 9],
 *   [16, 7,10,11]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/rotate-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：数组操作
 */

public class TP01P07 {

    @Test
    public void test() {
        TP01P07 t = new TP01P07();

        int[][] matrix = new int[][]
                {
                        {5, 1, 9, 11},
                        {2, 4, 8, 10},
                        {13, 3, 6, 7},
                        {15, 14, 12, 16}
                };
        t.rotate(matrix);
        Arrays.stream(matrix).forEach(v->{
            Arrays.stream(v).forEach(vv->{
                System.out.print(vv+" ");
            });
            System.out.println();
        });
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int length = n;

        for(int i = 0;i<n/2;i++){
            move(matrix,i,i,length-1);
            length-=2;
        }

    }



    public void move(int[][] matrix,int x,int y,int length){
        for(int offset = 0;offset<length;offset++){

            int t= matrix[x][y+offset];
            matrix[x][y+offset]=matrix[x+length-offset][y];
            matrix[x+length-offset][y] = matrix[x+length][y+length-offset];
            matrix[x+length][y+length-offset]=matrix[x+offset][y+length];
            matrix[x+offset][y+length] = t;
        }
    }



}





