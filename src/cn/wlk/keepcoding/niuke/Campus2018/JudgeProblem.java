package cn.wlk.keepcoding.niuke.Campus2018;

import java.util.Scanner;

/**
 * 2019/3/26 11:37
 * author:WLK
 */

/**
 * 题目描述 判断题
 * <p>
 * 牛牛参加了一场考试,考试包括n道判断题,每做对一道题获得1分,牛牛考试前完全没有准备,所以考试只能看缘分了,
 * 牛牛在考试中一共猜测了t道题目的答案是"正确",其他的牛牛猜为"错误"。
 * 考试结束后牛牛知道实际上n道题中有a个题目的答案应该是"正确",
 * 但是牛牛不知道具体是哪些题目,牛牛希望你能帮助他计算可能获得的最高的考试分数是多少。
 * 输入描述:
 * <p>
 * 输入包括一行,一行中有三个正整数n, t, a(1 ≤ n, t, a ≤ 50), 以空格分割
 * <p>
 * 输出描述:
 * <p>
 * 输出一个整数,表示牛牛可能获得的最高分是多少。
 * <p>
 * 示例1
 * 输入
 * 复制
 * <p>
 * 3 1 2
 * <p>
 * 输出
 * 复制
 * <p>
 * 2
 *
 * 解法：
 *      最好的情况是：
 *          t>a:猜的a个全部都是正确饿的，加上本来就是错误的；一共a+(n-t)分
 *          t<=a:猜的a个部分正确(即本来是正确的全部猜对了，但是多猜了），加上部分猜F猜对的，共t+(n-a)分
 */
public class JudgeProblem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(),t = scanner.nextInt(),a = scanner.nextInt();
        int result  = 0;
        if(t>=a) {
            result = a + (n - t);
        }else {
            result = t+(n-a);
        }
        System.out.println(result);
    }
}
