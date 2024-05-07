package cn.wlk.keepcoding.mianshi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 字节一面的算法题，算法这部分应该是通过了
 * 原来是leetCode 31 原题
 * 见：cn.wlk.keepcoding.leetcode.n031
 * 题目：下一个更大
 * 题目描述：
 * 给定一个数字（正数，不超过10位），返回这几个数字排列组合中下一个更大的数字
 * 比如数字：1234，输入：1243
 * 如果没有，返回-1
 *
 * 解法：
 * 先将数字转换为数组
 * 先一遍遍历，得到最后一个相邻递增的两个数，A、B， 其中，A < B
 * 然后交换一下位置，并将 B 和 数组之后的元素，一起排序
 * 然后将排序后的位置，依次填充到原数组中
 * 在将数组转换为数字即可
 *
 * @author 奈昕
 * @date 2024/5/7 21:08:00
 */
public class zijieyimian20240507 {
    public static void main(String[] args) {
        System.out.println(nextBig(1234));
        System.out.println(nextBig(14521));
        System.out.println(nextBig(54321));
    }

    public static int nextBig(int x) {
        // 转换为数组，一遍遍历，找出最后一个上升的子序列
        //交换最大的那个，然后那个第二大的直接，和后面的值一起排个序，倒序赋值

        int[] arr = new int[10];
        int index = 9;
        while (x > 0) {
            arr[index--] = x % 10;
            x = x / 10;
        }
        int start = ++index;
        int end = 9;
        //只有一位，则认为没有下一个更大的数
        if (start == end) {
            return -1;
        }

        int lastIndex = -1;
        for (int i = start; i < end; i++) {
            int pre = arr[i];
            int next = arr[i + 1];
            if (pre < next) {
                lastIndex = i;
            }
        }
        //System.out.println(lastIndex);

        if(lastIndex == -1){
            return  -1;
        }
        int tmp = arr[lastIndex];
        arr[lastIndex] = arr[lastIndex+1];

        List<Integer> needSort = new ArrayList<>();
        needSort.add(tmp);
        for (int i = lastIndex + 2; i <= end; i++) {
            needSort.add(arr[i]);
        }

        Collections.sort(needSort);
        for (int i = 0; i < needSort.size(); i++) {
            arr[++lastIndex] = needSort.get(i);
        }

        int result = 0;
        for (int i = start; i <= end; i++) {
            result = result * 10 + arr[i];
        }
        return result;

    }
}
