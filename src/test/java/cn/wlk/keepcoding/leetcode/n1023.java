package cn.wlk.keepcoding.leetcode;

import org.junit.Test;
import sun.nio.cs.ext.ISCII91;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 2019/4/24-14:16
 * author:WLK
 * <p>
 * 1023. 驼峰式匹配
 * 如果我们可以将小写字母插入模式串 pattern 得到待查询项 query，那么待查询项与给定模式串匹配。（我们可以在任何位置插入每个字符，也可以插入 0 个字符。）
 * <p>
 * 给定待查询列表 queries，和模式串 pattern，返回由布尔值组成的答案列表 answer。只有在待查项 queries[i] 与模式串 pattern 匹配时， answer[i] 才为 true，否则为 false。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FB"
 * 输出：[true,false,true,true,false]
 * 示例：
 * "FooBar" 可以这样生成："F" + "oo" + "B" + "ar"。
 * "FootBall" 可以这样生成："F" + "oot" + "B" + "all".
 * "FrameBuffer" 可以这样生成："F" + "rame" + "B" + "uffer".
 * <p>
 * 示例 2：
 * <p>
 * 输入：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBa"
 * 输出：[true,false,true,false,false]
 * 解释：
 * "FooBar" 可以这样生成："Fo" + "o" + "Ba" + "r".
 * "FootBall" 可以这样生成："Fo" + "ot" + "Ba" + "ll".
 * <p>
 * 示例 3：
 * <p>
 * 输出：queries = ["FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"], pattern = "FoBaT"
 * 输入：[false,true,false,false,false]
 * 解释：
 * "FooBarTest" 可以这样生成："Fo" + "o" + "Ba" + "r" + "T" + "est".
 * <p>
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= queries.length <= 100
 * 1 <= queries[i].length <= 100
 * 1 <= pattern.length <= 100
 * 所有字符串都仅由大写和小写英文字母组成。
 *
 * 解法：使用前缀树，先将全部的字符串建树，然后拿pattern字符在树上进行DFS匹配，
 */
public class n1023 {

    @Test
    public void test() {
        n1023 t = new n1023();
//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};

//        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
        String[] queries = {"FooBar","FooBarTest","FootBall","FrameBuffer","ForceFeedBack"};
//        String[] queries = {"FooBarTest"};

//        String[] queries = {"FooBar"};
//        String pattern = "FoBaT";
        String pattern = "FB";
        t.camelMatch(queries, pattern).stream().forEach(x -> System.out.print(x + " "));
    }

    class PreTree {
        public char value = 0;
        public int number=-1;
        public HashMap<Character, PreTree> subTree = new HashMap<>();
        public PreTree(char ch) {
            this.value = ch;
        }
        public void buildTree(char[] strs, int index, PreTree root, int number) {
            if (strs.length == 0)
                return;
            if (index == strs.length) {
                root.number = number;
                return;
            }
            if (!root.subTree.containsKey(strs[index])) {
                root.subTree.put(strs[index], new PreTree(strs[index]));
            }
            buildTree(strs, index + 1, root.subTree.get(strs[index]), number);
        }
    }

    public List<Boolean> camelMatch(String[] queries, String pattern) {
        PreTree root = new PreTree(' ');
        List<char[]> strs = Arrays.stream(queries).map(x -> x.toCharArray()).collect(Collectors.toList());
        char[] patternstr = pattern.toCharArray();
        List<Boolean> result = new ArrayList<>(strs.size());
        for (int i = 0; i < strs.size(); i++) {
            root.buildTree(strs.get(i), 0, root, i);
            result.add(false);
        }
        dfs(root, patternstr, 0, result, false);//初始化默认无大写错误
        return result;
    }
    public void dfs(PreTree root, char[] strs, int index, List<Boolean> result, boolean hasCapital) {
        //将匹配root节点的子节点
        int subIndex = index;
        boolean subCapical = hasCapital;
        if (root.subTree.isEmpty() || root.number != -1) {//到了叶子节点上或到了某个单词末尾
            if (index >= strs.length && !hasCapital) {//pattern已经匹配完，并且没有大写异常
                result.set(root.number, true);
            } else {
                result.set(root.number, false);
            }
            if (root.number == -1) {//到了叶子节点，，dfs退出
                return;
            }
        }
        Iterator<Character> it = root.subTree.keySet().iterator();
        char key;
        while (it.hasNext()) {
            subIndex = index;
            subCapical = hasCapital;
            key = it.next();
            if (index < strs.length) {
                if (key == strs[index]) {//匹配上了
                    subIndex++;
                }else if (key >= 'A' && key <= 'Z') {//没匹配上，但是是大写
                    subCapical = true;
                }
            }else if (key >= 'A' && key <= 'Z') {//pattern已经匹配完了，但是还有大写
                subCapical = true;
            }
            PreTree tree = root.subTree.get(key);
            dfs(tree, strs, subIndex, result, subCapical);
        }


    }

}