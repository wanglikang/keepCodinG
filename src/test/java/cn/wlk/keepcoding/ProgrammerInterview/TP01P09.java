package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/2/29 15:03
 * author:WLK
 *
 * 面试题 01.09. 字符串轮转
 *
 * 字符串轮转。给定两个字符串s1和s2，请编写代码检查s2是否为s1旋转而成（比如，waterbottle是erbottlewat旋转后的字符串）。
 *
 * 示例1:
 *
 *  输入：s1 = "waterbottle", s2 = "erbottlewat"
 *  输出：True
 *
 * 示例2:
 *
 *  输入：s1 = "aa", "aba"
 *  输出：False
 *
 * 提示：
 *
 *     字符串长度在[0, 100000]范围内。
 *
 * 说明:
 *
 *     你能只调用一次检查子串的方法吗？
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/flipped-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 *
 * 解法：如果s1是s2的旋转字符串，则s1+s1 一定包含s2
 *
 */

public class TP01P09 {

    @Test
    public void test() {
        TP01P09 t = new TP01P09();
    }

    /**
     * 可以用一次搜索
     * @param s1
     * @param s2
     * @return
     */
    public boolean isFlipedString(String s1, String s2) {

        int n1 = s1.length();
        int n2 = s2.length();
        if(n1!=n2){
            return false;
        }

        String s = s1+s2;
        return s.contains(s2);
    }


}
