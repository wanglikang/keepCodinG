package cn.wlk.keepcoding.ProgrammerInterview;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 2020/4/22 11:43
 * author:WLK
 *
 * 面试题 17.11. 单词距离
 *
 * 有个内含单词的超大文本文件，给定任意两个单词，找出在这个文件中这两个单词的最短距离(相隔单词数)。如果寻找过程在这个文件中会重复多次，而每次寻找的单词不同，你能对此优化吗?
 *
 * 示例：
 *
 * 输入：words = ["I","am","a","student","from","a","university","in","a","city"], word1 = "a", word2 = "student"
 * 输出：1
 *
 * 提示：
 *
 *     words.length <= 100000
 *
 * 解法：哈希表存字符串出现的下标们，使用双指针，指向两个查询字符串的下标们，然后依次移动，找最小距离即可
 */

public class TP17P11 {

    @Test
    public void test() {
        TP17P11 t = new TP17P11();
    }

    public int findClosest(String[] words, String word1, String word2) {
        int n = words.length;
        HashMap<String , List<Integer>> wordMap = new HashMap<>();
        for(int i = 0;i<n;i++){
            String w = words[i];
            if(!wordMap.containsKey(w)){
                List<Integer> list = new ArrayList<>();
                list.add(i);
                wordMap.put(w,list);
            }else{
                wordMap.get(w).add(i);
            }
        }
        int len1 = wordMap.get(word1).size();
        int len2 = wordMap.get(word2).size();
        int p1 = 0,p2 = 0;
        int minDistance = Integer.MAX_VALUE;
        while(p1<len1 && p2<len2){
            int index1 = wordMap.get(word1).get(p1);
            int index2 = wordMap.get(word2).get(p2);
            int d = Math.abs(index1-index2);
            if(d<minDistance){
                minDistance = d;
            }
            if(index1<index2){
                p1++;
            }else{
                p2++;
            }
        }

        return minDistance;




    }
}
