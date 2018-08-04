package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 347. 前K个高频元素
 * 给定一个非空的整数数组，返回其中出现频率前 k 高的元素。
 * <p>
 * 例如，
 * <p>
 * 给定数组 [1,1,1,2,2,3] , 和 k = 2，返回 [1,2]。
 * <p>
 * 注意：
 * <p>
 * 你可以假设给定的 k 总是合理的，1 ≤ k ≤ 数组中不相同的元素的个数。
 * 你的算法的时间复杂度必须优于 O(n log n) , n 是数组的大小。
 */
//done

/**
 * 解法：
 * 哈希+使用大顶堆
 */
public class n347 {
    public List<Integer> topKFrequent(int[] nums, int k) {
        PriorityQueue<HashMap.Entry<Integer, Integer>> heap = new PriorityQueue<>(new Comparator<HashMap.Entry<Integer, Integer>>() {
            @Override
            public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                if (o1.getValue() > o2.getValue())
                    return -1;
                else if (o1.getValue() == o2.getValue())
                    return 0;
                else return 1;
            }
        });
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        for (HashMap.Entry<Integer, Integer> entry : map.entrySet()) {
            heap.add(entry);
        }

        for (int i = 0; i < k; i++) {
            result.add(heap.poll().getKey());
        }
        return result;
    }

    @Test
    public void test() {
        n347 t = new n347();
        int nums[] = {1, 1, 1, 2, 2, 3};


        List<Integer> result = t.topKFrequent(nums, 2);
        for (int i : result)
            System.out.print(i + " ");
        System.out.println();

    }


    @Test
    public void test2() {
        int[] arr = {1,2,3,4,5,6,7,8};
        ArrayList<Integer> list = new ArrayList<>();
        for (int i : arr)
            list.add(i);
        Comparator<Integer> comper = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                System.out.println("compare:"+o1+":"+o2);
                if (o1 < o2)
                    return 1;
                else if (o1.equals(o2))
                    return 0;
                else return -1;
            }
        };
        System.out.println("排序前");
        for (int i : list) {
            System.out.print(i + " ");

        }
        System.out.println();
        System.out.println("排序后");
        Collections.sort(list, comper);

        for (int i : list) {
            System.out.print(i + " ");

        }
    }
}