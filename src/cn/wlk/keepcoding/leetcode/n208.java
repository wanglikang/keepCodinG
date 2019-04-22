package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;

/**
 * 2019/4/22-13:11
 * author:WLK
 * <p>
 * 208. 实现 Trie (前缀树)
 * <p>
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * <p>
 * 示例:
 * <p>
 * Trie trie = new Trie();
 * <p>
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * <p>
 * 说明:
 * <p>
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串。
 *
 * 解法：前缀树，简单题目
 */
public class n208 {
    @Test
    public void test() {
        n208 t = new n208();
//         Your Trie object will be instantiated and called as such:
        Trie obj = new Trie();
        obj.insert("hello");
        obj.insert("abdeffef");
        obj.insert("d");
        obj.insert("f32");



        System.out.println(obj.startsWith("he"));
        System.out.println(obj.startsWith("ab"));
        System.out.println(obj.startsWith("f"));
        System.out.println(obj.startsWith("fsd"));
        System.out.println(obj.startsWith("f"));



    }

}

class PTree {
    public char value;
    public int count;
    public HashMap<Character, PTree> subTree;

    public PTree(char ch) {
        this.value = ch;
        this.count = 0;
        this.subTree = new HashMap<>();
    }

    public void buildTree(char[] str, int index, PTree root) {
        if (str.length == 0) {
            return;
        }
        if(index==str.length){
            root.count++;
            return;
        }
        if(!root.subTree.containsKey(str[index])){
            root.subTree.put(str[index],new PTree(str[index]));
        }
        buildTree(str, index+1, root.subTree.get(str[index]));
    }

}

class Trie {
    PTree root ;
    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new PTree(' ');
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        root.buildTree(word.toCharArray(),0,root);
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        char[] strs = word.toCharArray();
        int index = 0;
        int len = strs.length;
        PTree node = root;
        while(index<len){
            node = node.subTree.get(strs[index]);
            if(node==null){
                return false;
            }
            index++;
        }
        if(node.count>0){
            return true;
        }else return false;

    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        char[] strs = prefix.toCharArray();
        int index = 0;
        int len = strs.length;
        PTree node = root;
        while(index<len){
            node = node.subTree.get(strs[index]);
            if(node==null){
                return false;
            }
            index++;
        }
        if(node!=null){
            return true;
        }else return false;
    }
}
