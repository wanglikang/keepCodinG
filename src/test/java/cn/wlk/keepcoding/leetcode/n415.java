package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和并同样以字符串形式返回。
 *
 * 你不能使用任何內建的用于处理大整数的库（比如 BigInteger）， 也不能直接将输入的字符串转换为整数形式。
 *
 *
 *
 * 示例 1：
 *
 * 输入：num1 = "11", num2 = "123"
 * 输出："134"
 * 示例 2：
 *
 * 输入：num1 = "456", num2 = "77"
 * 输出："533"
 * 示例 3：
 *
 * 输入：num1 = "0", num2 = "0"
 * 输出："0"
 *
 *
 *
 *
 * 提示：
 *
 * 1 <= num1.length, num2.length <= 104
 * num1 和num2 都只包含数字 0-9
 * num1 和num2 都不包含任何前导零
 *
 * 2024/7/26 18:10
 * author:nx
 */

public class n415 {

    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        char[] n1 = num1.toCharArray();
        char[] n2 = num2.toCharArray();
        int add = 0;
        int last = 0;
        int indexN1 = n1.length - 1;
        int indexN2 = n2.length - 1;
        while(indexN1 >= 0 || indexN2 >= 0){
            int v1 = indexN1 >=0? n1[indexN1] - '0':0;
            int v2 = indexN2 >=0? n2[indexN2] - '0':0;
            int result = v1 + v2;
            result = result + add;
            sb.append(result%10);
            add = result/10;
            indexN1--;
            indexN2--;
        }
        if(add > 0){
            sb.append(add);
        }
        return sb.reverse().toString();
    }

    @Test
    public void test() {
        n415 t = new n415();
        System.out.println(t.addStrings("123","1231"));
        System.out.println(t.addStrings("1","1231"));
        System.out.println(t.addStrings("999","111"));
    }

}


