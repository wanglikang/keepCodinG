package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 32. 最长有效括号
 *
 * 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号
 * 子串
 * 的长度。
 *
 *
 *
 * 示例 1：
 *
 * 输入：s = "(()"
 * 输出：2
 * 解释：最长有效括号子串是 "()"
 * 示例 2：
 *
 * 输入：s = ")()())"
 * 输出：4
 * 解释：最长有效括号子串是 "()()"
 * 示例 3：
 *
 * 输入：s = ""
 * 输出：0
 *
 *
 * 提示：
 *
 * 0 <= s.length <= 3 * 104
 * s[i] 为 '(' 或 ')'
 *
 *
 * 2020/8/10 23:24
 * author:WLK
 */

/**
 * 解法1：
 *  使用动态规划，比较复杂点
 * 解法2：
 *  使用栈，栈中保存遍历过程中，未匹配上的）的下标
 */

public class n032 {

    @Test
    public void test() {
        n032 t = new n032();
        System.out.println(t.longestValidParentheses(""));
        System.out.println(t.longestValidParentheses("(()()())()"));

    }

    /**
     * 解法2： 使用栈的方式
     * @param s
     * @return
     */
    public int longestValidParenthesesV2(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<Integer>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }



    public int longestValidParentheses(String s) {
        char[] chars = s.toCharArray();
        int size  = chars.length;
        Stack<Integer> stack = new Stack<>();
        Map<Integer,Integer> stack_result = new HashMap<>();
        for(int i = 0;i<chars.length;i++){
            if(stack.isEmpty()){
                stack.add(i);
            }else{
                if(chars[stack.peek()]=='(' && chars[i]==')'){
                    stack_result.put(stack.pop(),i);
                }else{
                    stack.add(i);
                }
            }
        }

        HashSet<Integer> starts = new HashSet<>(stack_result.keySet());
        for (Integer start : starts) {
            if(stack_result.containsKey(start)) {
                int tmp_start = stack_result.get(start)+1;
                while (stack_result.containsKey(tmp_start)) {
                    final Integer end = stack_result.get(tmp_start);
                    stack_result.remove(tmp_start);
                    stack_result.put(start, end);
                    tmp_start = end+1;

                }
            }
        }
        final int result = stack_result.entrySet().stream().map((entry) -> {
            return entry.getValue() - entry.getKey() + 1;
        }).max(Integer::compareTo).orElseGet(() -> 0).intValue();

        return  result;

    }

}
