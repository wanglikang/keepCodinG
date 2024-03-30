package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 10:02
 * author:WLK
 */

/**题目描述 数据分页说明
 *
 *  数据分页,对于指定的页数和每页的元素个数，返回该页应该显示的数据。
 * 输入描述:
 *
 * 第一行输入数据个数，第二行全部数据，第三行输入页数，第四行输入每页最大数据个数
 *
 * 输出描述:
 *
 * 输出该页应该显示的数据，超出范围请输出'超过分页范围'
 *
 * 示例1
 * 输入
 * 复制
 *
 * 6
 * 1 2 3 4 5 6
 * 1
 * 2
 *
 * 输出
 * 复制
 *
 * 3
 * 4
 *
 * 解法：水题
 */
public class dataPage {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for(int i = 0;i<n;i++){
            arr[i] = scanner.nextInt();
        }
        int page = scanner.nextInt();
        int max = scanner.nextInt();
        int start = page*max;
        if(page>=n/max){
            System.out.println("超过分页范围");
        }else {
            for (int i = start; i < start + max; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
