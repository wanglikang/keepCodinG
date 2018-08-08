package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 168. Excel表列名称
 *
 * 给定一个正整数，返回它在 Excel 表中相对应的列名称。
 *
 * 例如，
 *
 *     1 -> A
 *     2 -> B
 *     3 -> C
 *     ...
 *     26 -> Z
 *     27 -> AA
 *     28 -> AB
 *     ...
 * 示例 1:
 *
 * 输入: 1
 * 输出: "A"
 * 示例 2:
 *
 * 输入: 28
 * 输出: "AB"
 * 示例 3:
 *
 * 输入: 701
 * 输出: "ZY"
 */
//done

public class n168 {

    /**
     * 解法：
     *       就是把A-Z当做0-25，，是一个26进制的表示，
     *       不用考虑从Z到AA的感觉上的奇怪，只用类比从9到10的变化即可
     *       同时A作为0考虑，Z作为25考虑，那么需要在每一轮将n-1，即可将A-Z映射到0-25上
     *
     */
    public String convertToTitle(int n) {
        String temp = "";
        while (n > 0) {
            char s = (char) ((n - 1) % 26 + 'A');
            temp = s + temp;
            n = (n - 1) / 26;
        }
        return temp;
    }

    public String n_168_convertToTitle_my(int n) {
        int a, b;
        a = n;
        String result = "";
        char c = 'A';
        char newchar;
        b = a % 26;
        while (a > 26) {
            b = a % 26;
            if (b == 0)
                newchar = 'Z';
            else newchar = (char) (c + b - 1);
            result = (newchar) + result;
            a = (a - b) / 26;
        }
        newchar = (char) (c + a - 1);
        result = (newchar) + result;
        return result;
    }

    @Test
    public void test() {
        n168 t = new n168();
        System.out.println(t.convertToTitle(1));
        System.out.println(t.convertToTitle(1));
        System.out.println(t.convertToTitle(26));
        System.out.println(t.convertToTitle(27));
        System.out.println(t.convertToTitle(28));
        System.out.println(t.convertToTitle(701));
        System.out.println(t.convertToTitle(702));
        System.out.println(t.convertToTitle(703));
        System.out.println();
    }

}
