package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/2/25 18:11
 * author:WLK
 *
 * 面试题 01.05. 一次编辑
 *
 * 字符串有三种编辑操作:插入一个字符、删除一个字符或者替换一个字符。 给定两个字符串，编写一个函数判定它们是否只需要一次(或者零次)编辑。
 *
 *
 *
 * 示例 1:
 *
 * 输入:
 * first = "pale"
 * second = "ple"
 * 输出: True
 *
 *
 *
 * 示例 2:
 *
 * 输入:
 * first = "pales"
 * second = "pal"
 * 输出: False
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/one-away-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：双指针判断即可，，因为只是一次的插入、删除、编辑
 */

public class TP01P05 {

    @Test
    public void test() {
        TP01P05 t = new TP01P05();

//        System.out.println(t.oneEditAway("pale","ple"));
//        System.out.println(t.oneEditAway("pale","plea"));
//        System.out.println(t.oneEditAway("pale","psle"));
//        System.out.println(t.oneEditAway("pale","pald"));
        System.out.println(t.oneEditAway("","p"));
    }

    public boolean oneEditAway(String first, String second) {
        int n1 = first.length();
        int n2 = second.length();
        if (Math.abs(n1 - n2) > 1) {
            return false;
        }

        char[] arr1 = n1 > n2 ? first.toCharArray() : second.toCharArray();
        char[] arr2 = n1 > n2 ? second.toCharArray() : first.toCharArray();

        if(n2>n1){
            int t = n1;
            n1 = n2;
            n2 = t;
        }
        //替换
        if (n1 == n2) {
            int i = 0;

            while (i < n1 && arr1[i] == arr2[i]) {
                i++;
            }
            i++;
            if (i < n1) {

                while (i < n1 && arr1[i] == arr2[i]) {
                    i++;
                }
                if (i != n1) {
                    return false;
                }
            }
        } else {
            ///插入或删除
            int i = 0;
            while (i < n2 && arr1[i] == arr2[i]) {
                i++;
            }
            if (i < n2) {
                while (i < n2 && arr1[i + 1] == arr2[i]) {
                    i++;
                }
                if (i != n2) {
                    return false;
                }
            }

        }

        return true;


    }


}
