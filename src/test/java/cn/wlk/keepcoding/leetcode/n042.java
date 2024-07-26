package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Stack;


/**
 * 42：接雨水
 * <p>
 * https://leetcode-cn.com/problems/trapping-rain-water/
 * <p>
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 感谢 Marcos 贡献此图。
 * <p>
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class n042 {

    @Test
    public void test() {
        n042 n = new n042();
        int[] arr = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(n.trap(arr));
        System.out.println();
        int[] arr2 = {4,2,0,3,2,5};
        System.out.println(n.trap(arr2));
        System.out.println();
        int[] arr3 = { 5,5,1,7,1,1,5,2,7,6};
        System.out.println(n.trap(arr3));
    }

    public int trap(int[] height) {
        Stack<Integer> stack = new Stack<>();

        int sum = 0;
        for(int i = 0;i<height.length;i++){
            if(stack.isEmpty()){
                stack.push(i);
                continue;
            }
            Integer peek = stack.peek();
            int leftHeight = height[peek];
            int currentHeight = height[i];
            if(currentHeight <= leftHeight){
                stack.push(i);
                continue;
            }
            // 即    currentHeight > leftHeight
            while(!stack.empty() && height[stack.peek()] < height[i]){
                Integer cur = stack.pop();
                int lastLowHeight = height[cur];
                if(lastLowHeight < currentHeight && !stack.empty()){
                    Integer l = stack.peek();
                    int r = i;
                    int h = Math.min(height[r], height[l]) - height[cur];
                    sum+=h*(r - l - 1);
//                    System.out.println(l+"->"+r+"\t:"+h);
//                    System.out.println("after add:"+sum);
                }else{
                    break;
                }
            }
            stack.push(i);
        }
        return sum;
    }
}
