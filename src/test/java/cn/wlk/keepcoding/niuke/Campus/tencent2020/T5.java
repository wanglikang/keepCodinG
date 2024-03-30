package cn.wlk.keepcoding.niuke.Campus.tencent2020;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 2020/3/8 12:26
 * author:WLK
 */

public class T5 {

    @Test
    public void test() {
        T5 t = new T5();
    }


    public static void main(String[] a){
        int n = 4;
        int L = 6;
        int[][] nums = new int[][]{
                {3,6},
                {2,4},
                {0,2},
                {4,7}};
        System.out.println(func(n,L,nums));

    }

    public static int func(int n,int L ,int[][] nums){
        Arrays.sort(nums, 0, nums.length, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0]!=o2[0]){
                    return o1[0]-o2[0];
                }else{
                    return o1[1]-o2[1];
                }
            }
        });

        if(nums[0][0]!=0){
            return -1;
        }

        int coverLeft = nums[0][0];
        int coverRight = nums[0][1];
        int currIndex = 0;
        int nextIndex = 1;
        int result = 1;
        int maxRight = -1;
        int maxindex = 0;


        for(int i = 1;i<n;i++) {
            if (nums[i][0] <= coverRight) {
                if (nums[i][1] > maxRight) {
                    maxRight = nums[i][1];
                    maxindex = i;
                }
            }else{


            }



        }
        return -1;
    }

}
