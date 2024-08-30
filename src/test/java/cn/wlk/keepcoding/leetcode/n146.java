package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

/**
 * 2019/4/15-9:17
 * author:WLK
 * <p>
 * 146. LRU缓存机制
 * <p>
 * 运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
 * <p>
 * 获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
 * 写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
 * <p>
 * 进阶:
 * <p>
 * 你是否可以在 O(1) 时间复杂度内完成这两种操作？
 * <p>
 * 示例:
 * <p>
 * LRUCache cache = new LRUCache( 2 );// 缓存容量
 * <p>
 * cache.put(1,1);
 * cache.put(2,2);
 * cache.get(1);       // 返回  1
 * cache.put(3,3);    // 该操作会使得密钥 2 作废
 * cache.get(2);       // 返回 -1 (未找到)
 * cache.put(4,4);    // 该操作会使得密钥 1 作废
 * cache.get(1);       // 返回 -1 (未找到)
 * cache.get(3);       // 返回  3
 * cache.get(4);       // 返回  4
 * <p>
 * 解法：1.使用jdk中的LinkedHashMap，自定义其中的removeEldestEntry方法即可
 *      2.使用hashmap+Deque的方法，模拟LRU即可
 */


public class n146 {
    class LRUCache_LinkedHashMap {
        private LinkedHashMap<Integer, Integer> map;
        private int size;
        private int oldestKey = 0;

        //public LRUCache(int capacity) {
        public LRUCache_LinkedHashMap(int capacity) {
            this.size = capacity;
            // accessOrder: true：   按照访问顺序排序，即最不经常访问的为最老的
            //              false：  按照插入顺序排序，即最早插入的为最老的
            map = new LinkedHashMap<Integer, Integer>(capacity, 1, true) {
                /**
                 * @param eldest 最早被添加进去的元素entry
                 * @return  是否应该被删除
                 */
                @Override
                protected boolean removeEldestEntry(Map.Entry<Integer, Integer> eldest) {
                    boolean isRemove = false;
                    if (this.size() > size) {
                        isRemove = true;
                        //每次记录最旧的key
                        oldestKey = eldest.getKey();
                    }
                    return isRemove;
                }
            };
        }

        public int get(int key) {
            if (map.get(key) != null) {
                return map.get(key);
            } else return -1;

        }

        public void put(int key, int value) {
            if (map.size() > size) {
                map.remove(oldestKey);
            }
            map.put(key, value);

        }
    }


    /**
     * 执行用时 : 415 ms, 在LRU Cache的Java提交中击败了13.14% 的用户
     * 内存消耗 : 67.4 MB, 在LRU Cache的Java提交中击败了41.45% 的用户
     */
    class LRUCache {
        private int size;
        private HashMap<Integer,Integer> map  = new HashMap<>();
        private Deque<Integer> dequeKeys = new ArrayDeque<>();
        private int removeKey = -1;

        public LRUCache(int capacity) {
            this.size = capacity;
        }

        public void adjustDeque(int key){
            Integer last = dequeKeys.peekLast();
            if(last==key){
                return;
            }
            int temp ;

            while(dequeKeys.size()>0 && (temp = dequeKeys.peekLast())!=key){
                dequeKeys.addFirst(dequeKeys.pollLast());
            }
            dequeKeys.pollLast();
            while(dequeKeys.size()>0 && (temp=dequeKeys.peekFirst())!=last){
                dequeKeys.addLast(dequeKeys.pollFirst());
            }
            dequeKeys.addLast(dequeKeys.pollFirst());
            dequeKeys.addLast(key);
        }
        public int get(int key) {

            if(map.containsKey(key)){
                adjustDeque(key);
                return map.get(key);
            }else return -1;
        }

        public void put(int key, int value) {
            if(map.containsKey(key)){
                map.put(key,value);
                adjustDeque(key);
            }else {
                if (dequeKeys.size() + 1 > size) {
                    removeKey = dequeKeys.pollFirst();
                    map.remove(removeKey);
                }
                dequeKeys.addLast(key);
                map.put(key, value);
            }
        }
    }

    @Test
    public void test() {
        n146 t = new n146();
//        LRUCache cache = new LRUCache(2);// 缓存容量
//        cache.put(1, 1);
//        cache.put(2, 2);
//        System.out.println(cache.get(1));       // 返回  1
//        cache.put(3, 3);                        // 该操作会使得密钥 2 作废
//        System.out.println(cache.get(2));       // 返回 -1 (未找到)
//        cache.put(4, 4);                        // 该操作会使得密钥 1 作废
//        System.out.println(cache.get(1));       // 返回 -1 (未找到)
//        System.out.println(cache.get(3));       // 返回  3
//        System.out.println(cache.get(4));       // 返回  4
//
//        LRUCache cache = new LRUCache(1);// 缓存容量
//        cache.put(2,1);
//        System.out.println(cache.get(2));
//        cache.put(3,2);
//        System.out.println(cache.get(2));
//        System.out.println(cache.get(3));


//        LRUCache cache = new LRUCache(2);
//        System.out.println(cache.get(2));
//        cache.put(2,6);
//        System.out.println(cache.get(1));
//        cache.put(1,5);
//        cache.put(1,2);
//        System.out.println(cache.get(1));
//        System.out.println(cache.get(2));

        LRUCache cache = new LRUCache(2);
        cache.put(2,1);
        cache.put(1,1);
        cache.put(2,3);
        cache.put(4,1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
    }

}