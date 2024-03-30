package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/3/17 9:31
 * author:WLK
 */

/**
 * 题目描述
 * 六一儿童节，老师带了很多好吃的巧克力到幼儿园。每块巧克力j的重量为w[j]，对于每个小朋友i，当他分到的巧克力大小达到h[i] (即w[j]>=h[i])，他才会上去表演节目。老师的目标是将巧克力分发给孩子们，使得最多的小孩上台表演。可以保证每个w[i]> 0且不能将多块巧克力分给一个孩子或将一块分给多个孩子。
 * 输入描述:
 *
 * 第一行：n，表示h数组元素个数
 *  第二行：n个h数组元素
 *  第三行：m，表示w数组元素个数
 *  第四行：m个w数组元素
 *
 * 输出描述:
 *
 * 上台表演学生人数
 *
 * 示例1
 * 输入
 *
 * 3
 *  2 2 3
 *  2
 *  3 1
 *
 * 输出
 *
 * 1
 */
public class T361ChildrenDay {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] h = new int[n];
        while(n>0){
            h[n-1] = scanner.nextInt();
            n--;
        }
        int m = scanner.nextInt();
        int[] w = new int[m];
        while (m>0){
            w[m-1] = scanner.nextInt();
            m--;
        }

        Arrays.sort(h);
        Arrays.sort(w);

//        for (int i : h) {
//            System.out.print(i+" ");
//        }
//        System.out.println();
//        for (int i : w) {
//            System.out.print(i+" ");
//        }
        //w[i]>h[j]

        int indexw = w.length-1;
        int indexh = h.length-1;
        int result = 0;
        while(indexh>=0 && indexw>=0){
            if(w[indexw]>=h[indexh]){
                result++;
                indexh--;
                indexw--;
            }else{
                indexh--;
            }
        }
        System.out.println(result);



    }
}
