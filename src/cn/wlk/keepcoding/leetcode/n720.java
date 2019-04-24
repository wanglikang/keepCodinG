package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;

/**
 * 2019/4/24-9:30
 * author:WLK
 *
 * 720. 词典中最长的单词
 *
 * 给出一个字符串数组words组成的一本英语词典。从中找出最长的一个单词，该单词是由words词典中其他单词逐步添加一个字母组成。若其中有多个可行的答案，则返回答案中字典序最小的单词。
 *
 * 若无答案，则返回空字符串。
 *
 * 示例 1:
 *
 * 输入:
 * words = ["w","wo","wor","worl", "world"]
 * 输出: "world"
 * 解释:
 * 单词"world"可由"w", "wo", "wor", 和 "worl"添加一个字母组成。
 *
 * 示例 2:
 *
 * 输入:
 * words = ["a", "banana", "app", "appl", "ap", "apply", "apple"]
 * 输出: "apple"
 * 解释:
 * "apply"和"apple"都能由词典中的单词组成。但是"apple"得字典序小于"apply"。
 *
 * 注意:
 *
 *     所有输入的字符串都只包含小写字母。
 *     words数组长度范围为[1,1000]。
 *     words[i]的长度范围为[1,30]。
 *
 * 解法：建前缀树，每个节点有以其结尾的单词师，count++，然后对root开始对每个节点进行DFS，只有节点的count>0时候，才考虑是不是候选的单词
 *
 */
public class n720 {
    class PreTree{
        public char value;
        public int count;
        private HashMap<Character,PreTree> subTree ;
        public PreTree(char ch) {
            this.value = ch;
            this.count = 0;
            this.subTree = new HashMap<>();
        }
        public void buildTree(char[] strs,int index,PreTree root){
            if(strs.length==0)
                return;
            if(index==strs.length){
                root.count++;
                return ;
            }
            if(!root.subTree.containsKey(strs[index])){
                root.subTree.put(strs[index],new PreTree(strs[index]));
            }
            buildTree(strs,index+1,root.subTree.get(strs[index]));
//            root.subTree.get(strs[index]).count++;
        }

    }

    @Test
    public void test() {
        n720 t = new n720();
        String[] words = {"a", "banana", "app", "appl", "ap", "apply", "apple"};
//        String[] words = {"w","wo","wor","worl", "world"};

//        String[] words = {"ogz","eyj","e","ey","hmn","v","hm","ogznkb","ogzn","hmnm","eyjuo","vuq","ogznk","og","eyjuoi","d"};

        System.out.println(t.longestWord(words));
    }


    public String longestWord(String[] words) {
        PreTree root = new PreTree(' ');
        for(int i = 0;i<words.length;i++){
            root.buildTree(words[i].toCharArray(),0,root);
        }//建立前缀树

        String[] result = new String[]{""};
        Iterator<Character> it = root.subTree.keySet().iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            Character key = it.next();
            DFS(root,sb, result);
        }
        return result[0];

    }
    public void DFS(PreTree root,StringBuilder sb,String[] longestStr){
        if(root.subTree.isEmpty()){//到达了叶子节点
            return ;
        }

        Iterator<Character> it = root.subTree.keySet().iterator();
        Character key;
        while(it.hasNext()){
             key = it.next();
             if(root.subTree.get(key).count>0){



                 sb.append(root.subTree.get(key).value);

                 if(sb.length()>longestStr[0].length()){
                     longestStr[0]=sb.toString();
                 }else if(sb.length()==longestStr[0].length()){
                     if(longestStr[0].compareTo(sb.toString())>0){
                         longestStr[0] = sb.toString();
                     }
                 }

                 DFS(root.subTree.get(key), sb,longestStr);
                 sb.delete(sb.length()-1,sb.length());
             }
        }

    }

}