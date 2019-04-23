package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 2019/4/23-10:05
 * author:WLK
 *
 * 692. 前K个高频单词
 *
 *
 * 给一非空的单词列表，返回前 k 个出现次数最多的单词。
 *
 * 返回的答案应该按单词出现频率由高到低排序。如果不同的单词有相同出现频率，按字母顺序排序。
 *
 * 示例 1：
 *
 * 输入: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
 * 输出: ["i", "love"]
 * 解析: "i" 和 "love" 为出现次数最多的两个单词，均为2次。
 *     注意，按字母顺序 "i" 在 "love" 之前。
 *
 *
 *
 * 示例 2：
 *
 * 输入: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
 * 输出: ["the", "is", "sunny", "day"]
 * 解析: "the", "is", "sunny" 和 "day" 是出现次数最多的四个单词，
 *     出现次数依次为 4, 3, 2 和 1 次。
 *
 *
 *
 * 注意：
 *
 *     假定 k 总为有效值， 1 ≤ k ≤ 集合元素数。
 *     输入的单词均由小写字母组成。
 *
 *
 *
 * 扩展练习：
 *
 *     尝试以 O(n log k) 时间复杂度和 O(n) 空间复杂度解决。
 *
 *
 * 解法：使用hash表存单词出现的次数，用优先队列PriorityQueue存最大的次数
 *      map的getOrDefault方法
 */
public class n692 {
    @Test
    public void test() {
        n692 t = new n692();
        String[] words = {"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        t.topKFrequent(words,2).stream().forEach(x-> System.out.println(x));
    }
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        PriorityQueue<Map.Entry<String, Integer>> heap  = new PriorityQueue<>(k, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                if(o1.getValue()>o2.getValue()){
                    return -1;
                }else if(o1.getValue()<o2.getValue()){
                    return 1;
                }else return o1.getKey().compareTo(o2.getKey());
            }
        });
        for(int i= 0;i<words.length;i++){
            map.put(words[i],map.getOrDefault(words[i],0)+1);
//            if(map.containsKey(words[i])){
//                map.put(words[i],map.get(words[i])+1);
//            }else {
//                map.put(words[i],1);
//            }
        }

        Iterator<Map.Entry<String, Integer>> it = map.entrySet().iterator();
        while(it.hasNext()){
            heap.add(it.next());
        }
        for(int i = 0;i<k;i++){
            result.add(heap.poll().getKey());
        }
        return result;
    }

}