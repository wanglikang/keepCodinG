package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/4/1 10:34
 * author:WLK
 */

/**
 * 题目描述 序列补全
 * <p>
 * <p>
 * 在商城的某个位置有一个商品列表，该列表是由L1、L2两个子列表拼接而成。当用户浏览并翻页时，需要从列表L1、L2中获取商品进行展示。展示规则如下：
 * <p>
 * 1. 用户可以进行多次翻页，用offset表示用户在之前页面已经浏览的商品数量，比如offset为4，表示用户已经看了4个商品
 * <p>
 * 2. n表示当前页面需要展示的商品数量
 * <p>
 * 3. 展示商品时首先使用列表L1，如果列表L1长度不够，再从列表L2中选取商品
 * <p>
 * 4. 从列表L2中补全商品时，也可能存在数量不足的情况
 * <p>
 * 请根据上述规则，计算列表L1和L2中哪些商品在当前页面被展示了
 * 输入描述:
 * <p>
 * 每个测试输入包含1个测试用例，包含四个整数，分别表示偏移量offset、元素数量n，列表L1的长度l1，列表L2的长度l2。
 * <p>
 * 输出描述:
 * <p>
 * 在一行内输出四个整数分别表示L1和L2的区间start1，end1，start2，end2，每个数字之间有一个空格。
 * 注意，区间段使用半开半闭区间表示，即包含起点，不包含终点。如果某个列表的区间为空，使用[0, 0)表示，如果某个列表被跳过，使用[len, len)表示，len表示列表的长度。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 2 4 4 4
 * 1 2 4 4
 * 4 1 3 3
 * <p>
 * 输出
 * 复制
 * <p>
 * 2 4 0 2
 * 1 3 0 0
 * 3 3 1 2
 *
 * 解法：简单判断即可
 */
public class listCompletion {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int offset = scanner.nextInt(), n = scanner.nextInt(), L1 = scanner.nextInt(), L2 = scanner.nextInt();
        int start = offset;
        int end = offset + n;
        int ll, lr, rl, rr;
        ll = start > L1 ? L1 : start;
        lr = end > L1 ? L1 : end;
        rl = start > L1 + L2 ? L2 : start > L1 ? start - L1 : 0;
        rr = end > L1 + L2 ? L2 : end > L1 ? end - L1 : 0;
        System.out.println(ll + " " + lr + " " + rl + " " + rr);

    }
}
