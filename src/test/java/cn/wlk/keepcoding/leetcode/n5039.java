package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.Arrays;

/**
 * 2019/4/28 10:31
 * author:WLK
 *
 * 第 134 场周赛 1
 * 5039. 移动石子直到连续
 *
 *

 三枚石子放置在数轴上，位置分别为 a，b，c。

 每一回合，我们假设这三枚石子当前分别位于位置 x, y, z 且 x < y < z。从位置 x 或者是位置 z 拿起一枚石子，并将该石子移动到某一整数位置 k 处，其中 x < k < z 且 k != y。

 当你无法进行任何移动时，即，这些石子的位置连续时，游戏结束。

 当游戏结束时，你可以执行的最小和最大移动次数分别是多少？ 以长度为 2 的数组形式返回：answer = [minimum_moves, maximum_moves]



 示例 1：

 输入：a = 1, b = 2, c = 5
 输出：[1, 2]
 解释：将石子从 5 移动到 4 再移动到 3，或者我们可以直接将石子移动到 3。

 示例 2：

 输入：a = 4, b = 3, c = 2
 输出：[0, 0]
 解释：我们无法进行任何移动。



 提示：

 1 <= a <= 100
 1 <= b <= 100
 1 <= c <= 100
 a != b, b != c, c != a


 *
 *
 *
 * 测试用例：
 * 输入：3
 * 5
 * 1
 * 输出：[2,2]
 * 预期：[1,2]
 *-----------------
 * 输入：1
 * 9
 * 5
 * 输出：[3,6]
 * 预期：[2,6]
 * ----------------
 * 输入：3
 * 5
 * 1
 * 输出：[2,2]
 * 预期：[1,2]
 *
 * 解法：先排序，然后简单判断位置关系即可
 */
public class n5039 {
    @Test
    public void test() {
        n5039 t = new n5039();
        int[] r = t.numMovesStones(3,5,1);
        System.out.println(r[0]+":"+r[1]);

        r = t.numMovesStones(1,5,9);
        System.out.println(r[0]+":"+r[1]);
    }
    public int[] numMovesStones(int a, int b, int c) {
        int[] arr = {a,b,c};
        int[] result = {0,0};
        Arrays.sort(arr);
        if(arr[1]==arr[0]+1 && arr[2]==arr[1]+1){
            return result;
        }

        if(arr[0]+1==arr[1] || arr[1]+1==arr[2]){
            result[0]=1;
        }else if(arr[0]+2==arr[1] || arr[1]+2==arr[2]){
            result[0] = 1;
        }else{
            result[0] = 2;
        }

        result[1]+=(arr[1]-arr[0]-1);
        result[1]+=(arr[2]-arr[1]-1);

        return result;
    }

}