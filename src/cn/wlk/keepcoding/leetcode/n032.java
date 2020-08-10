package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2020/8/10 23:24
 * author:WLK
 */

public class n032 {

    @Test
    public void test() {
        n032 t = new n032();
        System.out.println(t.longestValidParentheses(""));
        System.out.println(t.longestValidParentheses("(()()())()"));

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
