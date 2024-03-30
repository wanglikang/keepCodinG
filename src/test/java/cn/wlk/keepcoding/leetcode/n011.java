package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/1 15:31
 * author:WLK
 * 11.盛最多水的容器
 * https://leetcode-cn.com/problems/container-with-most-water/
 *
 * 给定 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, ai) 和 (i, 0)。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 *
 * 说明：你不能倾斜容器，且 n 的值至少为 2。
 *
 * 图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。
 *
 *
 *
 * 示例:
 *
 * 输入: [1,8,6,2,5,4,8,3,7]
 * 输出: 49
 * done
 * 解法：1、暴力
 *       2、使用左右两个指针，将两个指针的短的那个像对向移动，每次求面积进行比较即可
 */
public class n011 {
    public int maxArea2(int[] height) {
        int n = height.length;
        int max =-1;
        for(int i = 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                max = Math.max(max,
                        Math.min(height[i],height[j])*(j-i));

            }
        }
        return  max;

    }
    public int maxArea(int[] height) {
        int n = height.length;
        int max =-1;
        int left = 0,right = n-1;
        while(left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]>height[right]){
                right--;
            }else left++;
        }
        return  max;

    }
    @Test
    public void test() {
        n011 t = new n011();
        int[] arr = {1,8,6,2,5,4,8,3,7};
//        int[] arr = {1,8};
        System.out.println(t.maxArea(arr));
    }

}
