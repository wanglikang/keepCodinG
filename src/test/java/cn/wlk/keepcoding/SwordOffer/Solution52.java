package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-9:56
 * author:WLK
 * 正则表达式匹配
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。
 * 模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。
 * 例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 *
 * 解法：参考论坛的解法 ，使用递归，对*的情况进行判断
 */
public class Solution52 {
    @Test
    public void test() {
        Solution52 t = new Solution52();
        char[] str = "abbcddedfgsdgg".toCharArray();
        char[] pattern = "a*b*d*.*".toCharArray();
        System.out.println(t.match(str, pattern));

    }

    /**
     * 第一个字符串为str，第二个字符串为pattern
     * 1/两个字符串都为空，返回true
     * 2/第一个字符串不空，第二个字符串空，返回false
     * 3/第一个字符串空，第二个字符串不空，可能为true（a*a*a*a*）
     * 4/对每一个字符进行匹配：
     * 4.1/pattern下一个字符不为*，直接匹配当前字符，是则下一个，否则false
     * 4.2/pattern下一个字符为*，递归：
     * *匹配0个，递归（pattern后移两位）
     * *匹配一个或多个，递归（str后移一位）
     *
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern) {
        return isMatch(str, pattern, 0, 0);
//        return matchCore(str,0,pattern,0);
    }

    public boolean isMatch(char[] str, char[] pattern, int index1, int index2) {
        int len1 = str.length;
        int len2 = pattern.length;
        if (index1 == len1 && index2 == len2) {//两个都匹配到了末尾，则返回true
            return true;
        }
        //pattern匹配到了末尾，但str还没有，则证明没有匹配完，false
        if (index1 != len1 && index2 == len2) {
            return false;
        }

        if (index2 + 1 < len2 && pattern[index2 + 1] == '*') {
            if (index1 < len1 && (str[index1] == pattern[index2] || pattern[index2] == '.')) {
                return isMatch(str, pattern, index1, index2 + 2)//匹配了0 个字符
                        || isMatch(str, pattern, index1 + 1, index2 + 2)//只匹配了一个字符
                        || isMatch(str, pattern, index1 + 1, index2);//匹配不止一个
            } else {
                return isMatch(str, pattern, index1, index2 + 2);//没有匹配到，pattern后移两位
            }
        }
        if (index1 < len1 && (pattern[index2] == str[index1]
                || pattern[index2] == '.')) {
            return isMatch(str, pattern, index1 + 1, index2 + 1);
        }
        return false;
    }

    /**
     * 别人的代码
     * @param str
     * @param index1
     * @param pattern
     * @param index2
     * @return
     */
    public boolean matchCore(char[] str, int index1, char[] pattern, int index2) {
        if (index1 == str.length && index2 == pattern.length) {//有效性检验：str到尾，pattern到尾，匹配成功
            return true;
        }
        if (index1 != str.length && index2 == pattern.length) {//pattern先到尾，匹配失败
            return false;
        }
        //模式第2个是*，且字符串第1个跟模式第1个匹配,分3种匹配模式；如不匹配，模式后移2位
        if (index2 + 1 < pattern.length && pattern[index2 + 1] == '*') {
            if ((index1 != str.length && pattern[index2] == str[index1])
                    || (pattern[index2] == '.' && index1 != str.length)) {
                return matchCore(str, index1, pattern, index2 + 2)//模式后移2，视为x*匹配0个字符
                        || matchCore(str, index1 + 1, pattern, index2 + 2)//视为模式匹配1个字符
                        || matchCore(str, index1 + 1, pattern, index2);//*匹配1个，再匹配str中的下一个
            } else {
                return matchCore(str, index1, pattern, index2 + 2);
            }
        }
        //模式第2个不是*，且字符串第1个跟模式第1个匹配，则都后移1位，否则直接返回false
        if ((index1 != str.length && pattern[index2] == str[index1])
                || (pattern[index2] == '.' && index1 != str.length)) {
            return matchCore(str, index1 + 1, pattern, index2 + 1);
        }
        return false;
    }

}