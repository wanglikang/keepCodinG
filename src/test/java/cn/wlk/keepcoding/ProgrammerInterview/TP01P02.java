package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2020/2/25 15:20
 * author:WLK
 *
 * 面试题 01.02. 判定是否互为字符重排
 *
 * 给定两个字符串 s1 和 s2，请编写一个程序，确定其中一个字符串的字符重新排列后，能否变成另一个字符串。
 *
 * 示例 1：
 *
 * 输入: s1 = "abc", s2 = "bca"
 * 输出: true
 *
 * 示例 2：
 *
 * 输入: s1 = "abc", s2 = "bad"
 * 输出: false
 *
 * 说明：
 *
 *     0 <= len(s1) <= 100
 *     0 <= len(s2) <= 100
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/check-permutation-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：用的排序
 *          其它解法：
 *              用hash
 *              用异或
 *
 */

public class TP01P02 {

    @Test
    public void test() {
        TP01P02 t = new TP01P02();
    }

    public boolean CheckPermutation(String s1, String s2) {


        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        int n1 = arr1.length;
        int n2 = arr2.length;
        if(n1!=n2){
            return false;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for(int i = 0;i<n1;i++){
            if(arr1[i]!=arr2[i]){
                return false;
            }
        }
        return true;
    }


}
