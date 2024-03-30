package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;

/**
 * 2020/4/29 9:30
 * author:WLK
 *
 *
 * 解法：使用单调栈去求解，
 *          （需要提前对输入数据做个处理）
 */

public class n084 {

    @Test
    public void test() {
        n084 t = new n084();
        int[] arr = new int[]{2,1,5,6,2,3};
//        int[] arr = new int[]{1};
//        int[] arr = new int[]{1,1};
        System.out.println(t.largestRectangleArea(arr));
    }


    public int largestRectangleArea(int[] height_old) {

        int n = height_old.length;
        int[] heights = new int[n+2];
        for(int i = 1;i<=n;i++){
            heights[i]=height_old[i-1];
        }

        Stack<Integer> stack = new Stack<>();
        int max = -1;
        stack.add(0);
        int maxArea  = 0;
        int r ;
        int lastH;
        for(int i = 0;i<n+2;i++){

            int h = heights[i];
//            if(h<=heights[lastIndex]){
                while( !stack.empty() && heights[stack.peek()]>h){
                    lastH = heights[stack.pop()];
                    int l = stack.peek()+1;
                    maxArea = Math.max(maxArea,lastH*(i-l));
                }
//            }

            stack.add(i);
        }
//
//
//        lastIndex = stack.peek();
//        lastH = heights[stack.pop()];
//        int l = stack.peek()+1;
//        maxArea = Math.max(maxArea,lastH*(n -1-l+1));
        return maxArea;
    }


}
