package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 20. 有效的括号
 * <p>
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 */
//done
public class n020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int len = chars.length;
        char ch;

        for (int i = 0; i < len; i++) {
            if (stack.isEmpty()) {
                stack.push(chars[i]);
            } else {
                ch = stack.peek();
                if (chars[i] == '[' || chars[i] == '{' || chars[i] == '(') {
                    stack.push(chars[i]);
                } else {
                    if (chars[i] == ']' && ch == '[') {
                        stack.pop();
                    } else if (chars[i] == ')' && ch == '(') {
                        stack.pop();
                    } else if (chars[i] == '}' && ch == '{') {
                        stack.pop();
                    }else return false;
                }
            }
        }
        if(stack.isEmpty())
            return true;
        else return false;
    }

    @Test
    public void test() {
        n020 t = new n020();
        System.out.println(t.isValid("{}{}{}((){(})[]"));
        System.out.println(t.isValid(""));

    }

}
