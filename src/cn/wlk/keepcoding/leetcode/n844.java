package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2019/4/26 11:19
 * author:WLK
 * <p>
 * 844. 比较含退格的字符串
 * <p>
 * 给定 S 和 T 两个字符串，当它们分别被输入到空白的文本编辑器后，判断二者是否相等，并返回结果。 # 代表退格字符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：S = "ab#c", T = "ad#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “ac”。
 * <p>
 * 示例 2：
 * <p>
 * 输入：S = "ab##", T = "c#d#"
 * 输出：true
 * 解释：S 和 T 都会变成 “”。
 * <p>
 * 示例 3：
 * <p>
 * 输入：S = "a##c", T = "#a#c"
 * 输出：true
 * 解释：S 和 T 都会变成 “c”。
 * <p>
 * 示例 4：
 * <p>
 * 输入：S = "a#c", T = "b"
 * 输出：false
 * 解释：S 会变成 “c”，但 T 仍然是 “b”。
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= S.length <= 200
 * 1 <= T.length <= 200
 * S 和 T 只含有小写字母以及字符 '#'。
 *
 * 解法：使用栈
 */
public class n844 {
    @Test
    public void test() {
        n844 t = new n844();


        System.out.println(t.backspaceCompare("y#fo##f", "y#f#o##f"));
    }

    public boolean backspaceCompare(String S, String T) {
        Stack<Character> stack = new Stack<>();
        char[] strs = S.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '#' ) {
                if( !stack.isEmpty())
                    stack.pop();
            } else {
                stack.add(strs[i]);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }

        String SS, TT;

        SS = sb.toString();
        sb.delete(0, sb.length());
        strs = T.toCharArray();
        for (int i = 0; i < strs.length; i++) {
            if (strs[i] == '#' ) {
                if( !stack.isEmpty())
                    stack.pop();
            } else {
                stack.add(strs[i]);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        TT = sb.toString();
        System.out.println(SS);
        System.out.println(TT);
        return SS.equals(TT);

    }


}