package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.nio.charset.Charset;
import java.util.Stack;

/**
 * 2019/4/26 11:29
 * author:WLK
 *
 * 394. 字符串解码
 *
 * 给定一个经过编码的字符串，返回它解码后的字符串。
 *
 * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
 *
 * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
 *
 * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
 *
 * 示例:
 *
 * s = "3[a]2[bc]", 返回 "aaabcbc".
 * s = "3[a2[c]]", 返回 "accaccacc".
 * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 *
 * 解法：使用栈，分两个栈：数字栈numStack，字串栈sbStack，
 *      遇到']'就将字串栈顶出栈，并将其重复(numStack.pop()-1)次，并加入字串栈顶
 */
public class n394 {
    @Test
    public void test() {
        n394 t = new n394();
        System.out.println(t.decodeString("3[a]2[bc]"));
        System.out.println(t.decodeString("3[a2[c]]"));
        System.out.println(t.decodeString("2[abc]3[cd]ef"));
        System.out.println(t.decodeString("100[leetcode]"));
    }

    public String decodeString(String s) {
//        char[] strs = ("1["+s+"]").toCharArray();
        char[] strs = s.toCharArray();
        StringBuilder result = new StringBuilder();
        Stack<Integer> numStack = new Stack<>();
        Stack<StringBuilder> sbStack = new Stack<>();
        sbStack.add(result);

        numStack.add(1);
        StringBuilder sb=null;
        for(int i = 0;i<strs.length;i++){
            if(Character.isDigit(strs[i])){
                if(i>0 && Character.isDigit(strs[i-1])){
                    numStack.add(numStack.pop()*10+Integer.parseInt(strs[i]+""));
                }else numStack.add(Integer.parseInt(strs[i]+""));
            }else if(strs[i]=='['){
                 sb = new StringBuilder();
                 sbStack.add(sb);
            }else if(strs[i]==']'){
                StringBuilder tsb  =sbStack.pop();
                StringBuilder parentSb = sbStack.peek();
                for(int k = numStack.pop();k>0;k--){
                    parentSb.append(tsb);
                }
            }else {
                sbStack.peek().append(strs[i]);
            }
        }
        return sbStack.peek().toString();
    }


}