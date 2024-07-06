package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2019/4/7-20:22
 * author:WLK
 * 数据流中的中位数
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 我们使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 *
 * 解法:使用两个堆，分别保存小于中位数的，大于中位数的数字，
 *              其中，大顶堆保存小于中位数的，小顶堆保存大于中位数的
 *              插入的时候判断两个堆的大小关系，以及两堆堆顶元素的大小关系
 *              取中位数的时候，判断两堆的大小关系，以及两堆的堆顶元素的关系即可
 */
public class Solution63 {
    @Test
    public void test() {
        Solution63 t = new Solution63();
        int[] arr = {4, 3, 5, 6, 2, 4, 3, 2, 7, 5, 8, 2, 1, 5};
        //RriorityQueue默认是小顶堆
//        PriorityQueue<Integer> q = new PriorityQueue<>(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
////                return o1-o2;//正常排序，还是小顶堆
//                return o2 - o1;//大顶堆
//            }
//        });
//        for (int i = 0; i < arr.length; i++) {
//            q.add(arr[i]);
//            System.out.println(q.peek());
//        }
        for(int i = 0;i<arr.length;i++){
            t.Insert(arr[i]);
            System.out.println(t.GetMedian());
        }
    }

    public PriorityQueue<Integer> queue1 = new PriorityQueue<Integer>(new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    });
    public PriorityQueue<Integer> queue2 = new PriorityQueue<Integer>();

    /**
     * 拟采用两个堆进行处理
     *
     * @param e
     */
    public void Insert(Integer e) {
        int len1 = queue1.size();
        int len2 = queue2.size();
        int t1;
        int t2;
        if (queue1.size() == 0) {
            queue1.add(e);
            return;
        }
        if ((len1 + len2) % 2 == 1) {
            t1 = queue1.peek();

            if (queue1.size() > queue2.size()) {
                if (e <= t1) {
                    queue1.poll();
                    queue2.add(t1);
                    queue1.add(e);
                } else {
                    queue2.add(e);
                }
            } else {
                t2 = queue2.peek();
                if (e >= t2) {
                    queue2.poll();
                    queue1.add(t2);
                    queue2.add(e);
                } else {
                    queue1.add(e);
                }
            }
        } else {
            t1 = queue1.peek();
            t2 = queue2.peek();
            if (e <= t1) {
                queue1.add(e);
            } else {
                queue2.add(e);
            }
        }
    }

    public Double GetMedian() {
        int len1 = queue1.size();
        int len2 = queue2.size();
        if ((len1 + len2) % 2 == 1) {//奇数
            if (len1 > len2) {
                return queue1.peek() * 1.0;
            } else return queue2.peek() * 1.0;
        } else {//偶数
            if (queue1.size() == 0 && queue2.size() == 0) {
                return 0.0;
            } else
                return (queue1.peek() + queue2.peek()) * 1.0 / 2;
        }
    }

}