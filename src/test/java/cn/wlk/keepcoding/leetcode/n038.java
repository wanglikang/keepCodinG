package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 38. 报数
 * <p>
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * <p>
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * <p>
 * 注意：整数顺序将表示为一个字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1
 * 输出: "1"
 * 示例 2:
 * <p>
 * 输入: 4
 * 输出: "1211"
 */

//看评价是个智障题，不做了
    //done,还是做了
public class n038 {
    public String count(String s) {
//        System.out.println(s);
        String result = "";
        int countnum = 0, num;
        int index;
        char[] chars = s.toCharArray();
        int len = s.length();
        char lastch = chars[0];
        for (int i = 0; i < len; i++) {

            if (chars[i] == lastch) {
                countnum++;
            } else {
                result += (countnum + "") + lastch;
                countnum = 1;
                lastch = chars[i];
            }
        }
        if (countnum != 0) {
            result += (countnum + "") + lastch;
        }
        return result;
    }

    public String countAndSay(int n) {
        String result = "1";
        for (int i = 1; i < n; i++) {
            result = count(result);
        }
        return result;
    }

    @Test
    public void test() {
        n038 t = new n038();
        System.out.println(t.countAndSay(1));
        System.out.println(t.countAndSay(2));
        System.out.println(t.countAndSay(3));
        System.out.println(t.countAndSay(4));
        System.out.println(t.countAndSay(5));
    }

}
