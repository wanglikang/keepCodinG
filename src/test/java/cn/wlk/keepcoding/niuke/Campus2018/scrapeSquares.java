package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 2019/4/1 9:50
 * author:WLK
 */

/**题目描述 拼凑正方形
 *
 * 解法：根据数据推到，，最长和最短一组，剩下的两根一组，各自求差在求和即可
 * 根据数学推导：
 *     最长的那根木棍和最短的那根，最终要达到相同的长度，那么中间要进行len(max) - len(min)次操作。
 *     第二长的那根木棍和第二短的那根，最终要达到相同的长度，中间要进行len(max2) - len(min2) 次操作。
 *
 * 所以总共要进行len(max) + len(max2) - len(min2)- len(min)次操作
 *
 */
public class scrapeSquares {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[4];
        for(int i = 0;i<4;i++){
            arr[i] = scanner.nextInt();
        }
        Arrays.sort(arr);
       int result = arr[3]-arr[0]+arr[2]-arr[1];
        System.out.println(result);
    }
}
