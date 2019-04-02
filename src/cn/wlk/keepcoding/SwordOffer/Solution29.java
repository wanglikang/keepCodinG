package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 2019/4/2 11:32
 * author:WLK
 *
 * 最小的K个数
 *
 * 输入n个整数，找出其中最小的K个数。
 * 例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 * 解法：使用堆，时间复杂度为O(nlogk)，即java中的PriorityQueue
 */
public class Solution29 {
    @Test
    public void test() {
        Solution29 t = new Solution29();
        int[] arr = {4,5,1,6,2,7,3,8};
        ArrayList<Integer> result = t.GetLeastNumbers_Solution(arr, 0);
        for (Integer e : result) {
            System.out.println(e);
        }
    }

    /**
     * 先排序，再求前K个
     * 还可以用冒泡排序
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution_sort(int [] input, int k) {
        Arrays.sort(input) ;
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = 0;i<Math.min(k,input.length);i++){
            result.add(input[i]);
        }
        return result;
    }

    /**
     * 使用堆，时间复杂度为O(nlogk)
     *  java中的PriorityQueue，当
     *  compare(Integer o1, Integer o2){
     *      o2-o1
     *  }
     *  时是大顶堆
     *  compare(Integer o1, Integer o2){
     *     o1-o2
     *  }
     *  时是小顶堆
     *
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {

        ArrayList<Integer> result = new ArrayList<>();
        if(k>input.length ||k==0)
            return result;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int i =0;i<k;i++){
            queue.add(input[i]);
        }
        for(int i =k;i<input.length;i++){
            if(queue.peek()>input[i]){
                queue.poll();
                queue.add(input[i]);
            }
        }
        return new ArrayList<>(queue);
    }

}
