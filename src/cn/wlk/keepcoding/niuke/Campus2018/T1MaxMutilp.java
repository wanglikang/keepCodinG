package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 最大乘积
 * 题目描述
 * 给定一个无序数组，包含正数、负数和0，要求从中找出3个数的乘积，使得乘积最大，要求时间复杂度：O(n)，空间复杂度：O(1)
 * 输入描述:
 *
 * 无序整数数组A[n]
 *
 * 输出描述:
 * 满足条件的最大乘积
 *
 * 示例1
 * 输入
 *
 * 3 4 1 2
 *
 * 输出
 *
 * 24
 */
public class T1MaxMutilp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Long> nums = new ArrayList<>();//注意要使用Long，否则可能溢出
        int n = scanner.nextInt();
        while (n>0){
            nums.add(scanner.nextLong());
            n--;
        }
        scanner.close();
        Collections.sort(nums);

        int len = nums.size();
        if(len<4){
            System.out.println(nums.get(0)*nums.get(1)*nums.get(2));
            return ;
        }
//        Long sum1 = 0;
//        Long sum2 = 0;
        System.out.println(Math.max(
                nums.get(len-1)*nums.get(len-2)*nums.get(len-3),
                nums.get(0)*nums.get(1)*nums.get(len-1)));
    }
}
