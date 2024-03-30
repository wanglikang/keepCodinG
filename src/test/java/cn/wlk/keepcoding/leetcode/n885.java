package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 885. 救生艇
 * Weekly Contest 96
 *
 * 用户通过次数 0
 * 用户尝试次数 0
 * 通过次数 0
 * 提交次数 0
 * 题目难度 Medium
 * 第 i 个人的体重为 people[i]，每艘船可以承载的最大重量为 limit。
 *
 * 每艘船最多可同时载两人，但条件是这些人的重量之和最多为 limit。
 *
 * 返回载到每一个人所需的最小船数。(保证每个人都能被船载)。
 *
 *
 *
 * 示例 1：
 *
 * 输入：people = [1,2], limit = 3
 * 输出：1
 * 解释：1 艘船载 (1, 2)
 * 示例 2：
 *
 * 输入：people = [3,2,2,1], limit = 3
 * 输出：3
 * 解释：3 艘船分别载 (1, 2), (2) 和 (3)
 * 示例 3：
 *
 * 输入：people = [3,5,3,4], limit = 5
 * 输出：4
 * 解释：4 艘船分别载 (3), (3), (4), (5)
 * 提示：
 *
 * 1 <= people.length <= 50000
 * 1 <= people[i] <= limit <= 30000
 */
//done
public class n885 {
    public int numRescueBoats(int[] people, int limit) {
        int len = people.length;
        Arrays.sort(people);
        int l = 0;
        int r = len-1;
        int result = 0;
        while(l<=r){
            if(people[r]>=limit){
                result++;
                r--;
            }else if(people[l]+people[r]>limit){
                result++;
                r--;
            }else if(people[l]+people[r]<=limit) {
                result++;
                l++;
                r--;
            }
        }
        return result;
    }
    @Test
    public void test() {
        n885 t = new n885();
        int [] peoples = {3,5,3,4};
        int limit  = 5;
        System.out.println(t.numRescueBoats(peoples,limit));
        System.out.println();
    }

}
