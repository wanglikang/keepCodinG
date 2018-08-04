package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 17. 电话号码的字母组合
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/description/
 *
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 *
 *
 *
 * 示例:
 *
 * 输入："23"
 * 输出：["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 * 说明:
 * 尽管上面的答案是按字典序排列的，但是你可以任意选择答案输出的顺序。
 */
//done

/**
 * 解法：
 *      暴力回溯搜索
 *      注意，终止条件是回溯深度刚好达到字符长度即可
 */
public class n017 {
    String[] s ={"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder strsb = new StringBuilder();
        char chars[] = digits.toCharArray();
        int len = digits.length();
        if(len==0)
            return result;
        else dfs(0,strsb,result,chars);

        return result;
    }
    public void dfs(int depth,StringBuilder strsb,List<String> result,char[] chars){
        int maxDeepth = chars.length;
        if(depth==maxDeepth){
            result.add(strsb.toString());
            return ;
        }

        for(char ch :s[chars[depth]-'0'].toCharArray()){
            strsb.append(ch);
            dfs(depth+1,strsb,result,chars);
            strsb.delete(strsb.length()-1,strsb.length()    );
        }
    }
    @Test
    public void test() {

        n017 t = new n017();
        String s = "23";
        List<String> result = t.letterCombinations(s);
        for(String ss:result){
            System.out.print(ss+",");
        }
        result = t.letterCombinations("");
        for(String ss:result){
            System.out.print(ss+",");
        }
    }

}
