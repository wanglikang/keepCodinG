package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/28 10:58
 * author:WLK
 */

/**题目描述 关灯游戏
 *  在Alice生日的那天，Bob送给了她n个灯泡。他们决定用这些灯泡玩一个游戏：他们把这些灯泡从左往右排成一行，在初始时，有些灯泡是点亮的，有些灯泡是熄灭的。接下来，他们轮流进行操作，Alice首先操作。在每一次操作中，轮到操作的人需要选择一个点亮的灯泡，然后把它以及它右边的所有灯泡的状态进行一次改变，即把点亮的灯泡熄灭，把熄灭的灯泡点亮。如果在某一个人操作完之后，所有的灯泡都变成了熄灭状态，那么那个人就赢得了游戏。Alice和Bob都想赢得游戏，在他们都足够聪明的情况下，最后谁会赢呢？
 * 输入描述:
 *
 * 第一行包含一个整数 ，表示灯泡的个数。1 ≤ n ≤ 105
 *
 * 第二行包含 个 0 或 1，表示初始时灯泡的状态，0 表示熄灭，1 表示点亮。
 *
 * 输出描述:
 *
 * 如果最后Alice能赢，输出Alice，或则输出Bob。
 *
 * 示例1
 * 输入
 * 复制
 *
 * 3
 * 0 1 1
 *
 * 输出
 * 复制
 *
 * Alice
 *
 * 说明
 *
 * 示例2
 * 输入
 * 复制
 *
 * 5
 * 1 1 1 0 0
 *
 * 输出
 * 复制
 *
 * Bob
 *
 * 解法：很投机的方法，，看最后一位的灯是亮还是灭，，如果是灭，，则一定是Bob；否则一定是Alice赢
 *          分析：因为题目中说的每次操作都会改变某灯以及右边的所有灯，那么最右边的那个灯一定是最后轮到alice操作的，
 *              Alice最后要想赢，则一定是操作的亮灯，即最右边的必须是亮的，否则，她一定会输
 *
 */
public class shutdownLightGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int last = 0;
        for (int i = 0; i < n; i++) {
            last = scanner.nextInt();
        }

        if(last==1)
            System.out.println("Alice");
        else System.out.println("Bob");

    }
}
