package cn.wlk.keepcoding.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 551. 学生出勤记录 I
 *
 * 给定一个字符串来代表一个学生的出勤记录，这个记录仅包含以下三个字符：
 *
 *     'A' : Absent，缺勤
 *     'L' : Late，迟到
 *     'P' : Present，到场
 *
 * 如果一个学生的出勤记录中不超过一个'A'(缺勤)并且不超过两个连续的'L'(迟到),那么这个学生会被奖赏。
 *
 * 你需要根据这个学生的出勤记录判断他是否会被奖赏。
 *
 * 示例 1:
 *
 * 输入: "PPALLP"
 * 输出: True
 *
 * 示例 2:
 *
 * 输入: "PPALLL"
 * 输出: False
 *
 */
public class Solution551 {
	public static void main(String[] args) {
		Solution551 s = new Solution551();
		boolean result = s.checkRecord("PPALLLP");
		System.out.println(result);

	}
	public boolean checkRecord(String s) {
		char[] arrs = s.toCharArray();
		boolean result = true;
		int lastState = 0;//0:P正常,1:L迟到,2:A缺勤
		int a = 0;
		for(int i = 0;i<arrs.length;i++) {
			switch (arrs[i]) {
				case 'A':
					a++;
					lastState = 0;
					break;
				case 'L':
					if(lastState==0) {
						lastState = 1;
					}else if (lastState == 1) {
						lastState = 2;
					}else if(lastState ==2){
						result = false;
						return result;
					}
					break;
				case 'P':
					lastState = 0;
					break;
			}
		}
		return  result&&a<2;

	}

}
