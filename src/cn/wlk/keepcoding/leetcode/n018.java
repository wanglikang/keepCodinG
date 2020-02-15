package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.*;

/**
 * 18. 四数之和
 *
 * 给定一个包含 n 个整数的数组 nums 和一个目标值 target，判断 nums 中是否存在四个元素 a，b，c 和 d ，
 * 使得 a + b + c + d 的值与 target 相等？找出所有满足条件且不重复的四元组。
 *
 * 注意：
 *
 * 答案中不可以包含重复的四元组。
 *
 * 示例：
 *
 * 给定数组 nums = [1, 0, -1, 0, -2, 2]，和 target = 0。
 *
 * 满足要求的四元组集合为：
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 */
public class n018 {

    @Test
    public void test() {
        n018 t = new n018();
//        int[] in = new int[]{1, 0, -1, 0, -2, 2};
        int[] in = new int[]{0,0,0,0};
        List<List<Integer>> result = t.fourSum(in, 0);
        result.stream().forEach(v->{
            v.stream().forEach(vv-> System.out.print(vv+" "));
            System.out.println();
        });
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        int n = nums.length;
        if(n<4){
            return result;
        }
        int a,b,c,d;
        for(a = 0;a<=n-4;a++){
            if(a>0 && nums[a]==nums[a-1] ) {
                //确保没有重复的结果元素
                continue;
            }
            for(b = a+1;b<=n-3;b++){
                if(b>a+1 && nums[b]==nums[b-1]){
                    continue;
                }
                c = b+1;
                d = n-1;
                while(c<d){

                    if(nums[a]+nums[b]+nums[c]+nums[d]<target){
                        c++;
                    }else if(nums[a]+nums[b]+nums[c]+nums[d]>target){
                        d--;
                    }else {
                        result.add(new ArrayList<>(Arrays.asList(nums[a],nums[b],nums[c],nums[d])));
                        while(c<d && nums[c+1]==nums[c]){
                            c++;
                        }
                        while(c<d && nums[d-1]==nums[d]){
                            d--;
                        }

                        c++;
                        d--;
                    }
//                    System.out.println(c+"-"+d);
                }
            }
        }

        return result;
    }

}
