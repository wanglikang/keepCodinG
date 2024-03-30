package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

/**
 * 2020/2/29 11:32
 * author:WLK
 *
 * 面试题 01.06. 字符串压缩
 *
 * 字符串压缩。利用字符重复出现的次数，编写一种方法，实现基本的字符串压缩功能。比如，字符串aabcccccaaa会变为a2b1c5a3。若“压缩”后的字符串没有变短，则返回原先的字符串。你可以假设字符串中只包含大小写英文字母（a至z）。
 *
 * 示例1:
 *
 *  输入："aabcccccaaa"
 *  输出："a2b1c5a3"
 *
 * 示例2:
 *
 *  输入："abbccd"
 *  输出："abbccd"
 *  解释："abbccd"压缩后为"a1b2c2d1"，比原字符串长度更长。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/compress-string-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：一次遍历即可
 */

public class TP01P06 {

    @Test
    public void test() {
        TP01P06 t = new TP01P06();
        System.out.println(t.compressString("aabcccccaaa"));
        System.out.println(t.compressString("abbccd"));
        System.out.println(t.compressString(""));
        System.out.println(t.compressString("a"));
        System.out.println(t.compressString("ab"));
        System.out.println(t.compressString("abb"));
        System.out.println(t.compressString("aab"));
    }


    public String compressString(String S) {
        int n = S.length();
        if(n<3){{
            return S;
        }}
        char[] arrs = S.toCharArray();
        char lastChar = arrs[0];
        int lastCount = 1;

        StringBuilder sb = new StringBuilder();
        for(int i = 1;i<n;i++){
            if(lastChar!=arrs[i]){
                sb.append(lastChar);
                sb.append(lastCount);
                lastCount = 1;
                lastChar=arrs[i];
            }else{
                lastCount++;
            }
        }
        sb.append(lastChar);
        sb.append(lastCount);
        if(sb.toString().length()>n){
            return S;
        }else{
            return sb.toString();
        }
    }



}
