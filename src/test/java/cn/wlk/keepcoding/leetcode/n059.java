package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/13-9:14
 * author:WLK
 * 59. 螺旋矩阵 II
 * 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 *
 * 示例:
 *
 * 输入: 3
 * 输出:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * 解法：常规题
 */
public class n059 {
    @Test
    public void test() {
        n059 t = new n059();
        int n = 5;
        int[][] result = t.generateMatrix(n);
        t.show(result,n);

    }
    public void show(int[][] result ,int n){
        for(int i = 0 ;i<n;i++){
            for(int j = 0;j<n;j++){
                System.out.print(result[i][j]+"\t");
            }
            System.out.println();
        }
    }
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int x = 0,y = 0;
        int startnumber  =1;
        for(int k = n-1;k>0;k=k-2){
            fillNumber(result, x++, y++, k, startnumber);
//            show(result, n);
//            System.out.println("------------");
            startnumber+=4*k;
        }
        if(n%2==1){
            result[n/2][n/2]=n*n;
        }
        return result;

    }
    public void fillNumber(int[][] matrx,int x,int y,int k,int startNumber){
        int i = x,j = y;
        while(j<y+k){
            matrx[i][j++] = startNumber++;
        }
        while(i<x+k){
            matrx[i++][j]= startNumber++;
        }
        while(j>y){
            matrx[i][j--] = startNumber++;
        }
        while(i>x){
            matrx[i--][j] = startNumber++;
        }
    }

}