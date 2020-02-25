package cn.wlk.keepcoding.SwordOffe2;

import org.junit.Test;

/**
 * 2020/2/25 16:03
 * author:WLK
 *
 * 面试题 01.03. URL化
 *
 * URL化。编写一种方法，将字符串中的空格全部替换为%20。假定该字符串尾部有足够的空间存放新增字符，并且知道字符串的“真实”长度。（注：用Java实现的话，请使用字符数组实现，以便直接在数组上操作。）
 *
 * 示例1:
 *
 *  输入："Mr John Smith    ", 13
 *  输出："Mr%20John%20Smith"
 *
 * 示例2:
 *
 *  输入："               ", 5
 *  输出："%20%20%20%20%20"
 *
 * 提示：
 *
 *     字符串长度在[0, 500000]范围内。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/string-to-url-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：  倒序进行替换，然后构建new String(chars,start ,end)
 *
 */

public class TP01P03 {

    @Test
    public void test() {
        TP01P03 t = new TP01P03();
//        System.out.println(t.replaceSpaces("Mr John Smith    ",13));
        System.out.println(t.replaceSpaces("               ",5));

        System.out.println(t.replaceSpaces("ds sdfs afs sdfa dfssf asdf                ",27));

    }

    public String replaceSpaces(String S, int length) {
        char[] chars = S.toCharArray();
        int capacity = chars.length;
        int i = capacity-1;
        int j = length-1;
//        System.out.println(capacity);
//        System.out.println(S.substring(0,length));

        for(;j>=0;){
            if(chars[j]==' '){
                chars[i]='0';
                chars[i-1]='2';
                chars[i-2]='%';
                i-=3;
            }else{
                chars[i] = chars[j];
                i--;
            }
            j--;
        }

        return new String(chars,i+1,capacity-i-1);
    }


}