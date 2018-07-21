package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

public class n566 {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int i= nums.length;
        int j =0;;
        if(i>0)
            j = nums[0].length;
        else return  nums;
//        System.out.println(i+":"+j);
        int[][] result ;
        int count = 0;
        if(r*c==i*j){
            boolean isok = true;
            result = new int[r][c];
            for(int a = 0;a<r&&isok;a++){
                for(int b = 0;b<c&&isok;b++){
                    if(count<i*j) {
//                        System.out.println(count);
                        result[a][b] = nums[count / j][count % j];
                    }
                    else {
                        isok = false;
                        break;
                    }
                    count++;
                }
            }
            return result;
        }else return nums;
    }

    @Test
    public void test(){
        n566 n = new n566();
        int[][] nums = {{1,2,3,4,5},{6,7,8,9,10}};

        int[][] result  = n.matrixReshape(nums,3,2);
        for(int i = 0;i<result.length;i++){
            for(int j = 0;j<result[0].length;j++){
                System.out.print(result[i][j]+" ");
            }
            System.out.println();
        }


    }
}
