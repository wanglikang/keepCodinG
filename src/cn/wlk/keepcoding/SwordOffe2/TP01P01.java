package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/2/25 13:07
 * author:WLK
 * 面试题 01.01. 判定字符是否唯一
 *
 * 实现一个算法，确定一个字符串 s 的所有字符是否全都不同。
 *
 * 示例 1：
 *
 * 输入: s = "leetcode"
 * 输出: false
 *
 * 示例 2：
 *
 * 输入: s = "abc"
 * 输出: true
 *
 * 限制：
 *
 *     0 <= len(s) <= 100
 *     如果你不使用额外的数据结构，会很加分。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/is-unique-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：用数组做set
 */

public class TP01P01 {

    @Test
    public void test() {
        TP01P01 t = new TP01P01();
        System.out.println(t.isUnique("abcdefg"));
    }


    public boolean isUnique(String astr) {
        int[] set = new int[128];
        char[] chars = astr.toCharArray();
        int n = chars.length;
        for(int i = 0;i<n;i++){
            if(set[chars[i]-'a']!=0){
                return false;
            }else{
                set[chars[i]-'a']=1;
            }
        }
        return true;
    }


}
