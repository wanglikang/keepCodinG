package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 22. 括号生成
 * <p>
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * <p>
 * 例如，给出 n = 3，生成结果为：
 * <p>
 * [
 * "((()))",
 * "(()())",
 * "(())()",
 * "()(())",
 * "()()()"
 * ]
 */


/**
 * 中等题
 *  用栈
 * 解法参考：https://blog.csdn.net/gatieme/article/details/51095236
 * 神奇的解法，据说有卡特兰数
 */
public class n022 {

    /**
     * 
     * @param result
     * @param str   当前栈中已经存在的字符串
     * @param l     当前剩余的左括号个数
     * @param r     当前剩余的右括号个数
     */
    public void dfs(List<String> result,String str,int l,int r){
        if (l == 0 && r == 0) {
            result.add(str);
        }
        if (l > 0) {
            dfs(result, str + "(", l - 1, r);
        }
        if (r > 0 && l < r) {
            dfs(result, str + ")", l, r - 1);
        }
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(result,"",n,n);
        return result;
    }

    @Test
    public void test() {
        n022 t = new n022();

        List<String> result = t.generateParenthesis(3);
        for(String s:result)
            System.out.println(s);
    }

}
