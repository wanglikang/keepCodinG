package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 2019/4/21-9:58
 * author:WLK
 * <p>
 * 677. 键值映射
 * <p>
 * 实现一个 MapSum 类里的两个方法，insert 和 sum。
 * <p>
 * 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。
 * <p>
 * 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。
 * <p>
 * 示例 1:
 * <p>
 * 输入: insert("apple", 3), 输出: Null
 * 输入: sum("ap"), 输出: 3
 * 输入: insert("app", 2), 输出: Null
 * 输入: sum("ap"), 输出: 5
 *
 * 解法：使用前缀树即可，，
 */
public class n677 {
    @Test
    public void test() {
        n677 t = new n677();
        MapSum obj = new MapSum();
//        obj.insert("apple", 3);
//        obj.insert("appcce", 3);
//        obj.insert("app", 1);
//        int param_2 = obj.sum("app");
        obj.insert("a", 3);
        System.out.println(obj.sum("app"));
        obj.insert("b", 2);
        System.out.println(obj.sum("a"));

    }

}

class PreTree {
    public int value;
    public char key;
    HashMap<Character, PreTree> subTrees;

    PreTree(char k) {
        this.key = k;
        this.value = 0;
        subTrees = new HashMap<>();
    }

    /**
     * 递归构建前缀树
     * @param strs
     * @param index
     * @param value
     * @param root
     */
    public void buildTree(char[] strs, int index, int value, PreTree root) {

        if (index == strs.length) {
            root.value = value;
            return;
        }
        if (!root.subTrees.containsKey(strs[index])) {
            root.subTrees.put(strs[index], new PreTree(strs[index]));
        }
        buildTree(strs, index + 1, value, root.subTrees.get(strs[index]));

    }


}

class MapSum {
    PreTree root = new PreTree(' ');

    /**
     * Initialize your data structure here.
     */
    public MapSum() {

    }

    public void insert(String key, int val) {
        root.buildTree(key.toCharArray(), 0, val, root);
    }

    public int sum(String prefix) {
        char[] chars = prefix.toCharArray();
        int len = chars.length;
        if (len == 0) {
            return 0;
        }
        int index = 0;
        PreTree tempnode = root;
        while (index < len) {
            tempnode = tempnode.subTrees.get(chars[index]);
            if(tempnode==null){
                return 0;
            }
            index++;
        }
        return tempnode.value + countSum(tempnode);
    }

    public int countSum(PreTree startroot) {
        int sum = 0;
        Iterator<Character> it = startroot.subTrees.keySet().iterator();

        /**
         * 递归累加所有字符的和
         */
        while (it.hasNext()) {
            char key = it.next();
            PreTree subNode = startroot.subTrees.get(key);
            sum += subNode.value;
            sum += countSum(subNode);
        }
        return sum;
    }
}
