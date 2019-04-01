package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 11:08
 * author:WLK
 */

/**
 * 题目描述
 * <p>
 * 牛牛有羊羊有了属于他们自己的飞机。于是他们进行几次连续的飞行。f[i]表示第i次飞行所需的燃油的升数。飞行只能按照f数组所描述的顺序进行。
 * 起初飞机里有s升燃油,为了正常飞行,每次飞行前飞机内燃油量应大于等于此处飞行所需要的燃油量。请帮助他们计算在不进行加油的情况下他们能进行的飞行次数。
 * 输入描述:
 * <p>
 * 输入包括两行,第一行包括两个整数n和s(1 ≤ n ≤ 50, 1 ≤ s ≤ 1000),分别表示计划飞行的次数和飞起初始状态下有的燃油量。
 * 第二行包括n个整数f[i], (1 ≤ f[i] ≤ 1000), 表示每次计划飞行所需要的燃油量。
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数,表示他们能进行的飞行次数。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 7 10
 * 1 2 3 4 5 6 7
 * <p>
 * 输出
 * 复制
 * <p>
 * 4
 * 解法:用燃油数减去数组中的每一个数，看结果是不是大于0即可
 *              但是感觉这题的本意没那么简单
 */
public class airTravel {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt(), b = scanner.nextInt();
        int result = 0;
        int t = 0;
        for (int i = 0; i < a; i++) {
            t = scanner.nextInt();
            b -= t;
            if (b >= 0) {
                result++;
            }
        }
        System.out.println(result);
    }
}
