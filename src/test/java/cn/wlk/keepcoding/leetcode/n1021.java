package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2019/4/26-10:43
 * author:WLK
 *
 * 1021. 删除最外层的括号
 *
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 *
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 *
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 *
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 *
 *
 *
 * 示例 1：
 *
 * 输入："(()())(())"
 * 输出："()()()"
 * 解释：
 * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
 * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
 *
 * 示例 2：
 *
 * 输入："(()())(())(()(()))"
 * 输出："()()()()(())"
 * 解释：
 * 输入字符串为 "(()())(())(()(()))"，原语化分解得到 "(()())" + "(())" + "(()(()))"，
 * 删除每隔部分中的最外层括号后得到 "()()" + "()" + "()(())" = "()()()()(())"。
 *
 * 示例 3：
 *
 * 输入："()()"
 * 输出：""
 * 解释：
 * 输入字符串为 "()()"，原语化分解得到 "()" + "()"，
 * 删除每个部分中的最外层括号后得到 "" + "" = ""。
 *
 *
 *
 * 提示：
 *
 *     S.length <= 10000
 *     S[i] 为 "(" 或 ")"
 *     S 是一个有效括号字符串
 *
 * 解法：使用栈即可
 */
public class n1021 {
    @Test
    public void test() {
        n1021 t = new n1021();
        System.out.println(t.removeOuterParentheses("(()())((())())"));
    }

    public String removeOuterParentheses(String S) {
        Stack<Character> stack = new Stack<>();
        int start = 0,end = 0;
        char[] strs = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<strs.length;i++){
            if(stack.isEmpty()){
                stack.push(strs[i]);
                start = i;
            }else {
                if(strs[i]=='(') {
                    stack.push('(');
                }else {
                    if(stack.peek()=='('){
                        stack.pop();
                    }
                }

            }
            if(stack.isEmpty()){
                end = i;
                sb.append(new String(strs,start+1,end-start-1));
            }
        }
        return sb.toString();
    }

}