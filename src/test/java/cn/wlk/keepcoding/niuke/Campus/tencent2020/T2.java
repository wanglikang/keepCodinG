package cn.wlk.keepcoding.niuke.Campus.tencent2020;

import org.junit.Test;

/**
 * 2020/4/11 10:54
 * author:WLK
 */

public class T2 {

    @Test
    public void test() {
        T2 t = new T2();
//        int[][] matrix =new int[][]{
//                {1,3,5,7},
//                {10,11,16,20},
//                {23,30,34,50}
//        };

//        int[][] matrix =new int[][]{
//                {1,3,5,7}
//        };

//        int[][] matrix =new int[][]{
//                {1},
//                {10},
//                {23}
//        };
//
        int[][] matrix =null;
        for(int i = 0;i<30;i++) {

            System.out.println(i+":"+t.find(matrix, i));
        }

    }

    public boolean find(int[][] mat,int k){
        if(mat==null){
            return false;
        }
        int n = mat.length;
        if( n==0){
            return false;
        }
        int m= mat[0].length;
        if(m==0){
            return false;
        }


        int i = 0;
        int j = m-1;
        //右上角
        while(i<n && j>=0){
            if(mat[i][j]==k){
                return true;
            }
            if(mat[i][j]<k){
                i++;
            }else{
                j--;
            }
        }
        return false;
    }


}
