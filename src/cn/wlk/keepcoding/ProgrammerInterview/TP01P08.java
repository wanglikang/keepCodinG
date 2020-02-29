package cn.wlk.keepcoding.ProgrammerInterview;

import cn.wlk.keepcoding.leetcode.Utils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 2020/2/29 13:05
 * author:WLK
 *
 * 面试题 01.08. 零矩阵
 *
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 *
 *
 *
 * 示例 1：
 *
 * 输入：
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * 输出：
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * 示例 2：
 *
 * 输入：
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * 输出：
 * [
 *   [0,0,0,0],
 *   [0,4,5,0],
 *   [0,3,1,0]
 * ]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zero-matrix-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：不适用额外空间的办法，将第一行用作存储信息，表示对应列是否应该被清零，
 *
 */

public class TP01P08 {

    @Test
    public void test() {
        TP01P08 t = new TP01P08();

        int[][]  marix = new int[][]{
                {3, 3, 1,3},
                {4, 0, 1,1},
                {1, 1, 0,2}
        };
        String str = "[[3,5,5,6,9,1,4,5,0,5],[2,7,9,5,9,5,4,9,6,8],[6,0,7,8,1,0,1,6,8,1],[7,2,6,5,8,5,6,5,0,6],[2,3,3,1,0,4,6,5,3,5],[5,9,7,3,8,8,5,1,4,3],[2,4,7,9,9,8,4,7,3,7],[3,5,2,8,8,2,2,4,9,8]]";
        int[][] marix2 = Utils.createintInintFromString(str);
        Arrays.stream(marix2).forEach(v->{
            Arrays.stream(v).forEach(vv->{
                System.out.print(vv+ " ");
            });
            System.out.println();
        });
        System.out.println("---------");
        t.setZeroes(marix2);
        Arrays.stream(marix2).forEach(v->{
            Arrays.stream(v).forEach(vv->{
                System.out.print(vv+ " ");
            });
            System.out.println();
        });
    }


    /**
     * 使用了额外的空间
     * @param matrix
     */
    public void setZeroes2(int[][] matrix) {
        int M = matrix.length;
        if(M==0){
            return ;
        }
        int N= matrix[0].length;
        List<Integer> zeros = new ArrayList<>();

        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(matrix[i][j] == 0){
                    zeros.add(i);
                    zeros.add(j);
                }
            }
        }

        int n = zeros.size()/2;
        for(int k = 0;k<n;k++){
            int i = zeros.get(2*k);
            int j = zeros.get(2*k+1);
            for(int jj = 0;jj<N;jj++){
                matrix[i][jj]=0;
            }
            for(int ii = 0;ii<M;ii++){
                matrix[ii][j]=0;
            }
        }
    }


    /**
     * 不适用额外的空间
     * 将第一行、第一列用作存储是否清零的标志位
     * @param matrix
     */
    public void setZeroes(int[][] matrix){
        int M = matrix.length;
        if(M==0){
            return ;
        }
        int N = matrix[0].length;


        boolean delFirstRow = false;
        boolean deleRow = false;
        for(int i = 0;i<M;i++){
            for(int j = 0;j<N;j++){
                if(matrix[i][j]==0){
                    matrix[0][j] = 0;
                    //标记清空此行
                    if(i!=0) {
                        deleRow= true;
                    }else{
                        delFirstRow=true;
                    }
                }
            }
            if(deleRow){
                for (int jj = 0; jj < N; jj++) {
                    matrix[i][jj] = 0;
                }
                deleRow = false;
            }
        }

        //根据第一行的信息，，清零每一列
        for(int j = 0;j<N;j++){
            if(matrix[0][j]==0){
                for(int i = 0;i<M;i++){
                    matrix[i][j]=0;
                }
            }
        }

        //清零第一行
        if(delFirstRow){
            for(int jj = 0;jj<N;jj++){
                matrix[0][jj]=0;
            }
        }

    }


}


