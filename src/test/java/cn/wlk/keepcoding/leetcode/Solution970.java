package cn.wlk.keepcoding.leetcode;

import java.nio.Buffer;
import java.util.*;

/**
 * 970. 强整数
 * 给定两个正整数 x 和 y，如果某一整数等于 x^i + y^j，其中整数 i >= 0 且 j >= 0，那么我们认为该整数是一个强整数。
 *
 * 返回值小于或等于 bound 的所有强整数组成的列表。
 *
 * 你可以按任何顺序返回答案。在你的回答中，每个值最多出现一次。
 *
 *
 *
 * 示例 1：
 *
 * 输入：x = 2, y = 3, bound = 10
 * 输出：[2,3,4,5,7,9,10]
 * 解释：
 * 2 = 2^0 + 3^0
 * 3 = 2^1 + 3^0
 * 4 = 2^0 + 3^1
 * 5 = 2^1 + 3^1
 * 7 = 2^2 + 3^1
 * 9 = 2^3 + 3^0
 * 10 = 2^0 + 3^2
 *
 * 示例 2：
 *
 * 输入：x = 3, y = 5, bound = 15
 * 输出：[2,4,6,8,10,14]
 *
 *
 *
 * 提示：
 *
 *     1 <= x <= 100
 *     1 <= y <= 100
 *     0 <= bound <= 10^6
 */
public class Solution970 {
	public static void main(String[] args) {
		Solution970 s = new Solution970();
		List<Integer> result = s.powerfulIntegers(2, 3, 10);
		for (Integer e : result) {
			System.out.println(e);

		}

	}
	public List<Integer> powerfulIntegers(int x, int y, int bound) {
		List<Integer> result = new ArrayList<>();
		int xx = x>y?y:x;//xx是较小的
		int yy = x>y?x:y;//yy是较大的
		Set<Integer> set  = new HashSet<>();
		for(int i = 0;i<100;i++){
			for(int j  = 0;j<100;j++){
				int temp = (int) ((int)Math.pow(xx, i)+Math.pow(yy,j));
				if(temp<=bound)
					set.add(temp);
				else break;
			}
		}
		result.addAll(set);
		return result;

	}
}
