package cn.wlk.keepcoding.leetcode;

import org.junit.Test;
import sun.dc.pr.PRError;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Stack;

/**
 * 2019/4/24-10:41
 * author:WLK
 * <p>
 * 745. 前缀和后缀搜索
 * <p>
 * 给定多个 words，words[i] 的权重为 i 。
 * <p>
 * 设计一个类 WordFilter 实现函数WordFilter.f(String prefix, String suffix)。这个函数将返回具有前缀 prefix 和后缀suffix 的词的最大权重。如果没有这样的词，返回 -1。
 * <p>
 * 例子:
 * <p>
 * 输入:
 * WordFilter(["apple"])
 * WordFilter.f("a", "e") // 返回 0
 * WordFilter.f("b", "") // 返回 -1
 * <p>
 * 注意:
 * <p>
 * words的长度在[1, 15000]之间。
 * 对于每个测试用例，最多会有words.length次对WordFilter.f的调用。
 * words[i]的长度在[1, 10]之间。
 * prefix, suffix的长度在[0, 10]之前。
 * words[i]和prefix, suffix只包含小写字母。
 */
public class n745 {
    @Test
    public void test() {
        n745 t = new n745();
        String[] words = {"abbbababbb","baaabbabbb","abababbaaa","abbbbbbbba","bbbaabbbaa","ababbaabaa","baaaaabbbb","babbabbabb","ababaababb","bbabbababa"};
//["WordFilter","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f","f"]
//[[["pop"]],["",""],["","p"],["","op"],["","pop"],["p",""],["p","p"],["p","op"],["p","pop"],["po",""],["po","p"],["po","op"],["po","pop"],["pop",""],["pop","p"],["pop","op"],["pop","pop"],["",""],["","p"],["","gp"],["","pgp"],["p",""],["p","p"],["p","gp"],["p","pgp"],["pg",""],["pg","p"],["pg","gp"],["pg","pgp"],["pgp",""],["pgp","p"],["pgp","gp"],["pgp","pgp"]]

//        ["","abaa"],["babbab",""],["ab","baaa"],["baaabba","b"],["abab","abbaabaa"],["","aa"],["","bba"],["","baaaaabbbb"],["ba","aabbbb"],["baaa","aabbabbb"]


        WordFilter obj = new WordFilter(words);
        System.out.println(obj.f("abab","abbaabaa"));


    }

    class PreTree {
        public boolean isVisited;
        public char value;
        public int weight;
        public HashMap<Character, PreTree> subTree;

        public PreTree(char ch) {
            this.isVisited = false;
            this.value = ch;
            this.weight = 0;
            this.subTree = new HashMap<>();
        }

        public void buildTree(char[] str, int index, int weight, PreTree root) {
            if (str.length == 0) {
                return;
            }
            if (index == str.length) {
                root.weight = weight;
                return;
            }
            if (!root.subTree.containsKey(str[index])) {
                root.subTree.put(str[index], new PreTree(str[index]));
            }
            buildTree(str, index + 1, weight, root.subTree.get(str[index]));
        }
    }

    class WordFilter {
        PreTree root = new PreTree(' ');

        public WordFilter(String[] words) {
            for (int i = 0; i < words.length; i++) {
                root.buildTree(words[i].toCharArray(), 0, i, root);
            }
        }


        public int f(String prefix, String suffix) {
            char[] prestr = prefix.toCharArray();
            char[] sufstr = suffix.toCharArray();
            int preindex = 0;
            ArrayList<PreTree> stack = new ArrayList<>();
            int stackIndex = 0;//栈顶的下一个下标

            PreTree preNode = root;
            stack.add(preNode);
            stackIndex++;
            while (preindex < prestr.length && preNode != null) {
                if (preNode.subTree.containsKey(prestr[preindex])) {
                    preNode = preNode.subTree.get(prestr[preindex]);
                    stack.add(preNode);
                    stackIndex++;
                    preindex++;
                } else {
                    clearStack(root);
                    return -1;
                }
            }

            preNode.isVisited = true;
            PreTree tempTree;
            int maxWeight = -1;
            while (stackIndex > prestr.length) {
                tempTree = stack.get(stackIndex - 1);//取栈顶元素
                if (tempTree.subTree.isEmpty()) {//是叶子节点了，，开始判断是否符合后缀
                    int lastIndex = suffix.length() - 1;
                    int tempstackindex = stackIndex - 1;
                    while (lastIndex >= 0) {
                        if (tempstackindex >= 1 && stack.get(tempstackindex).value == sufstr[lastIndex]) {
                            tempstackindex--;
                            lastIndex--;
                        } else {//不符合条件，不匹配
                            break;
                        }
                    }
                    //至此应该已经匹配上了
                    if (lastIndex < 0) {
                        maxWeight = Math.max(maxWeight, tempTree.weight);
                    }
                    stack.remove(stackIndex - 1);
                    stackIndex--;

                } else {
                    Iterator<Character> it = tempTree.subTree.keySet().iterator();
                    boolean hasVisited = true;
                    while (it.hasNext()) {
                        PreTree tree = tempTree.subTree.get(it.next());
                        if (!tree.isVisited) {
                            stack.add(tree);
                            tree.isVisited = true;
                            stackIndex++;
                            hasVisited = false;
                        }
                    }
                    if (hasVisited) {
                        stack.remove(stackIndex - 1);
                        stackIndex--;
                    }
                }
            }
            clearStack(root);
            return maxWeight;
        }

        public void clearStack(PreTree root) {
            root.isVisited = false;
            root.subTree.keySet().stream().forEach(x -> {
                clearStack(root.subTree.get(x));
            });

        }

        public int f_old(String prefix, String suffix) {
            char[] prestr = prefix.toCharArray();
            char[] sufstr = suffix.toCharArray();
            int preindex = 0;
            ArrayList<PreTree> stack = new ArrayList<>();
            int stackIndex = 0;//栈顶的下一个下标

            PreTree preNode = root;
            stack.add(preNode);
            stackIndex++;
            while (preindex < prestr.length && preNode != null) {
                if (preNode.subTree.containsKey(prestr[preindex])) {
                    preNode = preNode.subTree.get(prestr[preindex]);
                    stack.add(preNode);
                    stackIndex++;
                    preindex++;
                } else {
                    clearStack(root);
                    return -1;
                }
            }

            preNode.isVisited = true;
            PreTree tempTree;
            int maxWeight = -1;
            while (stackIndex > prestr.length) {
                tempTree = stack.get(stackIndex - 1);//取栈顶元素
                if (tempTree.subTree.isEmpty()) {//是叶子节点了，，开始判断是否符合后缀
                    int lastIndex = suffix.length() - 1;
                    int tempstackindex = stackIndex - 1;
                    while (lastIndex >= 0) {
                        if (tempstackindex >= 1 && stack.get(tempstackindex).value == sufstr[lastIndex]) {
                            tempstackindex--;
                            lastIndex--;
                        } else {//不符合条件，不匹配
                            break;
                        }
                    }
                    //至此应该已经匹配上了
                    if (lastIndex < 0) {
                        maxWeight = Math.max(maxWeight, tempTree.weight);
                    }
                    stack.remove(stackIndex - 1);
                    stackIndex--;

                } else {
                    Iterator<Character> it = tempTree.subTree.keySet().iterator();
                    boolean hasVisited = true;
                    while (it.hasNext()) {
                        PreTree tree = tempTree.subTree.get(it.next());
                        if (!tree.isVisited) {
                            stack.add(tree);
                            tree.isVisited = true;
                            stackIndex++;
                            hasVisited = false;
                        }
                    }
                    if (hasVisited) {
                        stack.remove(stackIndex - 1);
                        stackIndex--;
                    }
                }
            }
            clearStack(root);
            return maxWeight;
        }


    }

}