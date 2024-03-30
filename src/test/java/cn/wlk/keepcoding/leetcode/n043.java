package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/12-10:57
 * author:WLK
 * 43. 字符串相乘
 * <p>
 * 给定两个以字符串形式表示的非负整数 num1 和 num2，返回 num1 和 num2 的乘积，它们的乘积也表示为字符串形式。
 * <p>
 * 示例 1:
 * <p>
 * 输入: num1 = "2", num2 = "3"
 * 输出: "6"
 * <p>
 * 示例 2:
 * <p>
 * 输入: num1 = "123", num2 = "456"
 * 输出: "56088"
 * <p>
 * 说明：
 * <p>
 * num1 和 num2 的长度小于110。
 * num1 和 num2 只包含数字 0-9。
 * num1 和 num2 均不以零开头，除非是数字 0 本身。
 * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 * 解法：模拟小学的乘法运算即可
 */
public class n043 {
    @Test
    public void test() {
        n043 t = new n043();
        System.out.println(t.multiply("1", "0"));
    }

    public String multiply(String num1, String num2) {
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        if (n1[0] == '0' || n2[0] == '0') {
            return "0";
        }
        int len1 = n1.length;
        int len2 = n2.length;
        int newlen = len1 + len2 + 1;
        int[] result = new int[newlen];
        int k = newlen - 1;
        int SUP = 0;
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int x = (n1[i] - '0') * (n2[j] - '0');
                add(result, k--, x);
            }
            k = k + (len2 - 1);
        }
        StringBuilder sb = new StringBuilder();
        boolean flag = false;
        for (int i = 0; i < newlen; i++) {
            if(result[i]!=0){
                flag = true;
            }
            if(flag)
                sb.append(result[i] + "");
        }
//        System.out.println(sb.toString());
        return sb.toString();

    }

    /**
     * 实现进位相加的功能
     * @param result
     * @param k
     * @param n
     */
    public void add(int[] result, int k, int n) {
        int sup = (result[k] + n) / 10;
        result[k] = (result[k] + n) % 10;
        k--;
        int temp = 0;
        while (k < result.length && sup > 0) {
            temp = result[k] + sup;
            result[k] = temp % 10;
            sup = temp / 10;
            k--;
        }

    }


}