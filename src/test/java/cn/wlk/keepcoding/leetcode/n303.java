package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

public class n303 {


    /**
     * 考察三角形矩阵的操作方法，要求不能使用二维数组，否则内存占用太大。
     */
    static class NumArray {

        int[] dp ;
        int size;
        public NumArray(int[] nums) {
            int len = nums.length;
            size = len;
            System.out.println(len);
            dp = new int[size*(size+1)/2];
            System.out.println(dp.length);
            for(int i = 0;i<len;i++)
                setArrayEle(dp,i,i,nums[i]);
                //dp[i][i] = nums[i];


            for(int i = 0;i<len;i++){
                for(int j = i+1;j<len;j++){
//                    dp[i][j] = dp[i][j-1]+nums[j];
                    setArrayEle(dp,i,j,dp[getIndex(i,j-1)]+nums[j]);
                }
            }
        }

        public void setArrayEle(int[] arr,int i,int j,int value){
                arr[getIndex(i,j)]=value;
        }
        public int getIndex(int i,int j){
            return i*size-(i*(i+1)/2)+j;

        }

        public int sumRange(int i, int j) {
            if(i>j){
                int t = i;
                i = j;
                j = t;
            }
            return dp[getIndex(i,j)];
        }
    }

    @Test
    public void test(){
        int[] arr = {-2,0,3,-5,2,-1};
        NumArray n = new n303.NumArray(arr);
        System.out.println(n.sumRange(0,2));
        String s = "sdfdfsfsdgdggbERFBBBA";
        s.toLowerCase();

    }
/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */
}
