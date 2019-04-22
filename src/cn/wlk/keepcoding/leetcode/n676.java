package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 2019/4/21-9:45
 * author:WLK
 * <p>
 * 676. 实现一个魔法字典
 * 实现一个带有buildDict, 以及 search方法的魔法字典。
 * <p>
 * 对于buildDict方法，你将被给定一串不重复的单词来构建一个字典。
 * <p>
 * 对于search方法，你将被给定一个单词，并且判定能否只将这个单词中一个字母换成另一个字母，使得所形成的新单词存在于你构建的字典中。
 * <p>
 * 示例 1:
 * <p>
 * Input: buildDict(["hello", "leetcode"]), Output: Null
 * Input: search("hello"), Output: False
 * Input: search("hhllo"), Output: True
 * Input: search("hell"), Output: False
 * Input: search("leetcoded"), Output: False
 * <p>
 * 注意:
 * <p>
 * 你可以假设所有输入都是小写字母 a-z。
 * 为了便于竞赛，测试所用的数据量很小。你可以在竞赛结束后，考虑更高效的算法。
 * 请记住重置MagicDictionary类中声明的类变量，因为静态/类变量会在多个测试用例中保留。 请参阅这里了解更多详情。
 * <p>
 *
 * 执行用时 : 101 ms, 在Implement Magic Dictionary的Java提交中击败了75.00% 的用户
 * 内存消耗 : 34.7 MB, 在Implement Magic Dictionary的Java提交中击败了100.00% 的用户
 *
 * 解法:使用前缀字典树，深度遍历搜索即可,一旦找到一个符合要求的，就返回。注意需要设置一个代表是否该改变过某字符的变量，
 */
public class n676 {
    @Test
    public void test() {
        n676 t = new n676();
        MagicDictionary obj = new MagicDictionary();
        String[] dict = {"hello", "world"};
//        String[] dict = {"hello"};
        obj.buildDict(dict);
//        System.out.println(obj.search("eello"));
//        System.out.println(obj.search("hello"));
//        System.out.println(obj.search("ee"));
//        System.out.println(obj.search("qorld"));
//        System.out.println(obj.search("world"));
//        System.out.println(obj.search("worls"));
        System.out.println(obj.search("worlde"));
        System.out.println(obj.search(""));

    }

}



/**
 * 使用前缀树
 */
class MagicDictionary {

    class PreTree {
        public char value;//当前前缀树的节点内容---字符
        public int count;//以当前前缀树节点结尾的字符串的计数
        public HashMap<Character, PreTree> subTree;//当前前缀树的子节点

        public PreTree(char v) {
            this.value = v;
            this.count = 0;
            this.subTree = new HashMap<>();
        }

        public void buildTree(char[] strs, int index, PreTree root) {
            int len = strs.length;
            if (len == 0) {
                return;
            }
            if (index == len) {
                root.count++;
                return;
            }
            if (!root.subTree.containsKey(strs[index])) {
                PreTree node = new PreTree(strs[index]);
                root.subTree.put(strs[index], node);
            }
            buildTree(strs, index + 1, root.subTree.get(strs[index]));
        }
    }

    public PreTree root = null;

    /**
     * Initialize your data structure here.
     */
    public MagicDictionary() {
        root = new PreTree(' ');
    }

    /**
     * Build a dictionary through a list of words
     */
    public void buildDict(String[] dict) {
        int len = dict.length;
        for (int i = 0; i < len; i++) {
            root.buildTree(dict[i].toCharArray(), 0, root);
        }
    }

    /**
     * Returns if there is any word in the trie that equals to the given word after modifying exactly one character
     */
    public boolean search(String word) {

        if (subSearch(root, word.toCharArray(), 0, 0) == 1)
            return true;
        else
            return false;
    }

    /**
     * @param root
     * @param str
     * @param index
     * @param flag  当前状态是不是已经又字符改变过了，0：没变过，1：已经有一个字符改变过了
     * @return 是否找到正确解，，1：找到，0：没找到
     */
    public int subSearch(PreTree root, char[] str, int index, int flag) {
        if (str.length == 0)
            return 0;
        char currChar = str[index];
        if (index == str.length - 1) {
            if (flag == 0) {//之前没有更换过字符
                for (char i = 'a'; i <= 'z'; i++) {
                    if (i != currChar) {
                        if (root.subTree.containsKey(i) && root.subTree.get(i).count > 0) return 1;
                    } else continue;
                }
                return 0;
            } else {//之前更换过
                if (root.subTree.containsKey(currChar) && root.subTree.get(currChar).count > 0) return 1;
                else return 0;
            }
        }


        if (flag == 0) {//之前没有换过字符
            //更换个当前字符试试（虽然是“更换”了当前字符，，但是并没有字符数组中改变任何值）
            for (char i = 'a'; i <= 'z'; i++) {
                if (currChar != i) {
                    if (root.subTree.containsKey(i)
                            && subSearch(root.subTree.get(i), str, index + 1, 1) == 1)
                        return 1;
                } else continue;
            }
            //保持当前字符不变
            if (root.subTree.containsKey(currChar)) {
                if (subSearch(root.subTree.get(currChar), str, index + 1, 0) == 1)  return 1;

            }

        } else {//之前换过字符
            if (!root.subTree.containsKey(currChar)) {
                return 0;
            } else {
                return subSearch(root.subTree.get(currChar), str, index + 1, 1);
            }
        }
        return 0;
    }

}
