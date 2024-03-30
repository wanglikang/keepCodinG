package test;

import org.junit.Test;

/**
 * 2020/4/21 12:41
 * author:WLK
 */

public class tttt2 {

    @Test
    public void test() {
        tttt2 t = new tttt2();
        int[] height = new int[]{1,2,3,1,7,4,1,3,2};
        System.out.println(t.func(height));

    }

    public int func(int[] height){
        if(height.length < 3) return 0;

        int left = 0, right = height.length - 1;
        int leftmax = height[left], rightmax = height[right];
        int res = 0;

        while(left < right){
            if(leftmax < rightmax){
                res += leftmax - height[left];
                left++;
                leftmax = Math.max(height[left], leftmax);
            }else{
                res += rightmax - height[right];
                right--;
                rightmax = Math.max(height[right], rightmax);
            }
        }

        return res;

    }

}
