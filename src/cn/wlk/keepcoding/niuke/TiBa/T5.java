package cn.wlk.keepcoding.niuke.TiBa;

import org.junit.Test;

/**
 * 2020/4/3 17:39
 * author:WLK
 *
 * 取球放球
 *
 * 题目描述
 * 有n个箱子，第i个箱子一开始有aia_iai​个球，你可以进行最多k次操作，每次操作可以从一个箱子拿走一个球或者放入一个球。第i个箱子最多能装wiw_iwi​个球，装满了之后不能再往这个箱子里面放球。如果一个箱子为空，就不能从里面拿球。
 * 设相邻箱子的球的数量的差的平方中的最大值为x，求进行最多k次操作之后x最小可以是多少。
 *
 *
 * 示例1
 * 输入
 * 复制
 *
 * 5,4,[12,4,7,9,1],[15,15,15,15,15]
 *
 * 输出
 * 复制
 *
 * 36
 *
 * 说明
 *
 * 往第2个箱子放2个球，往第4个箱子放2个球得到[12,6,7,9,3],此时相邻箱子的球数差值为[-6,1,2,-6],平方后为[36,1,4,36]，其中最大值为36
 *
 * 备注:
 *
 * 2≤n≤100,1≤ai≤wi≤5002\le n\le100,1\le a_i \le w_i\le 5002≤n≤100,1≤ai​≤wi​≤500，1≤k≤∑i=1nwi1\le k\le\sum_{i=1}^n w_i1≤k≤∑i=1n​wi​
 *
 *
 * 没思路
 */

public class T5 {

    @Test
    public void test() {
        T5 t = new T5();
    }

    /**
     * 取球放球
     * @param n int整型 箱子个数
     * @param k int整型 最多操作次数
     * @param a int整型一维数组 箱子内的球的个数
     * @param w int整型一维数组 箱子容量
     * @return int整型
     */
    public int solve (int n, int k, int[] a, int[] w) {
        int[] diff = new  int[n-1];
        for(int i = 0;i<n-1;i++){
            diff[i] = a[i]-a[i+1];
        }
        for(int i = 0;i<k;i++){
            //开始k次操作
            //1找diff最大的值
            int maxindex = 0;
            int maxdiff = 0;
            for(int d = 0;d<n-1;d++){
                if(Math.abs(diff[d])>Math.abs(maxdiff)){
                    maxdiff = diff[d];
                    maxindex = d;
                }
            }


        }


        return 0;
    }





}
