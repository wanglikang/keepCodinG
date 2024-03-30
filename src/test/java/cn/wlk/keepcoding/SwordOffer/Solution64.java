package cn.wlk.keepcoding.SwordOffer;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 2019/3/3 12:06
 * author:WLK
 *
 *滑动窗口的最大值
 *
 *给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。
 * 例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，
 * 他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}，
 * {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}，
 * {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 *
 * 解法：使用双端队列，保存当前窗口内的最大值的下标
 */
public class Solution64 {
    /**
     * 朴素的方法，一个一个的找
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows_old(int [] num, int size){
        int step= num.length-size+1;
        int max = 0;
        ArrayList<Integer> result = new ArrayList<>();
        if(size==0)
            return result;
        for(int i = 0;i<step;i++){
            max = findMaxInArray(num,i,size);
            result.add(max);
        }
        return result;
    }

    public int findMaxInArray(int[] nums,int start,int size){
        int max = nums[start];
        int index = start+1;
        for(;index<start+size;index++){
            if(max<nums[index]){
                max = nums[index];
            }
        }
        return max;
    }


    /**
     * 剑指offer的方法
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> result = new ArrayList<>();
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        int left = 0;

        if(size==0)
            return  result;

        for(int i = 0;i<num.length;i++){
            left = i-size+1;
            if(queue.isEmpty()){
                queue.add(i);
            }else if(left>queue.peekFirst()){
                queue.pollFirst();
            }

            while(!queue.isEmpty() && num[i]>=num[queue.peekLast()] ){
                queue.pollLast();
            }
            queue.addLast(i);
            if(left>=0){
                result.add(num[queue.peekFirst()]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution64 s = new Solution64();
//        int[] nums = {2,3,4,2,6,2,5,1};
        int[] nums = {16,14,12,10,8,6,4};

        ArrayList result = s.maxInWindows(nums,5);
        Iterator it = result.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}
