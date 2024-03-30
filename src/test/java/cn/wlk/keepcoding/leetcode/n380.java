package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * 380. 常数时间插入、删除和获取随机元素
 * <p>
 * 设计一个支持在平均 时间复杂度 O(1) 下，执行以下操作的数据结构。
 * <p>
 * insert(val)：当元素 val 不存在时，向集合中插入该项。
 * remove(val)：元素 val 存在时，从集合中移除该项。
 * getRandom：随机返回现有集合中的一项。每个元素应该有相同的概率被返回。
 * 示例 :
 * <p>
 * // 初始化一个空的集合。
 * n380 randomSet = new n380();
 * <p>
 * // 向集合中插入 1 。返回 true 表示 1 被成功地插入。
 * randomSet.insert(1);
 * <p>
 * // 返回 false ，表示集合中不存在 2 。
 * randomSet.remove(2);
 * <p>
 * // 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
 * randomSet.insert(2);
 * <p>
 * // getRandom 应随机返回 1 或 2 。
 * randomSet.getRandom();
 * <p>
 * // 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
 * randomSet.remove(1);
 * <p>
 * // 2 已在集合中，所以返回 false 。
 * randomSet.insert(2);
 * <p>
 * // 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
 * randomSet.getRandom();
 */

//没有意义的题目
public class n380 {
    Set<Integer> set;

    /**
     * Initialize your data structure here.
     */
    public n380() {
        set = new HashSet<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        return set.add(val);
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        return set.remove(val);

    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        int len = set.size();
        int rand  =new Random(System.currentTimeMillis()).nextInt(len);
       // System.out.println("len:"+len+"rand:"+rand);
        Iterator<Integer> iterator = set.iterator();
        while(iterator.hasNext()){
            if(rand==0)
                return iterator.next();
            else {
                rand--;
                iterator.next();
            }
        }

        return iterator.next();

    }

    @Test
    public void test() {
        n380 t = new n380();
        t.insert(1);
        t.insert(2);
        t.insert(3);
        t.insert(4);
        t.insert(5);
        t.insert(6);
        t.insert(7);
        t.insert(8);
        t.remove(4);
        t.remove(2);
        for(int i = 0;i<10;i++)
            System.out.println(t.getRandom());
        System.out.println();
    }

}
