package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/28 9:49
 * author:WLK
 */

/**
 * 题目描述 内存条
 * <p>
 * 在很多存储模型中，内存池是使用循环队列来实现的。一个内存池可以看成一个环型的内存空间。现在有一个大小为L字节的内存池，用户会对它进行读和写两种操作。每次写会从当前存储位置的末尾向后空余的位置写入W比特的数据；每次读会从当前存储位置的开头读取R比特的数据，然后将这些位置的数据释放。所以任意时刻在内存中存储有数据的位置都是连续的一段。
 * <p>
 * 读和写操作是会被堵塞的，比如当剩余的内存空间不足W比特时，写操作就会被堵塞，等待读操作进行直到剩余空间不小于W比特；读操作也是类似。但是存在一种情况，系统会发生死锁，即当前剩余空间不足W比特写操作无法进行；但是当前存储的数据也不足R比特，读操作也无法进行。这时系统就陷入了死锁。现在你需要帮助判断一下某个系统是否有可能发生死锁，初始时内存池是空的。
 * 输入描述:
 * <p>
 * 第一行包含三个整数L，R，W。1≤L，R，W≤1018，R,W≤L
 * <p>
 * 输出描述:
 * <p>
 * 若会发生死锁，输出DEADLOCK；否则输出OK。
 * <p>
 * 示例1
 * 输入
 * <p>
 * 5 3 4
 * <p>
 * 输出
 * <p>
 * DEADLOCK
 * <p>
 * 说明
 * <p>
 * 示例2
 * 输入
 * <p>
 * 5 2 3
 * <p>
 * 输出
 * <p>
 * OK
 * 解法：当R+W大于L的时候，，就会发生死锁。
 */
public class memoryBank {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int L= scanner.nextInt(),R = scanner.nextInt(),W = scanner.nextInt();
        if (R + W > L) {

            System.out.println("DEADLOCK");
        }else System.out.println("OK");
    }
}
