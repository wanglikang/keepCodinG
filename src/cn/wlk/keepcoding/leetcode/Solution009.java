package cn.wlk.keepcoding.leetcode;

import java.util.Stack;
/**
9. 回文数

*/
public class Solution009 {
	public static void main(String[] args) {
		Solution009 s = new Solution009();
		System.out.println(s.isPalindrome(234322));

	}
	public boolean isPalindrome(int x) {
		if(x<0)
			return false;
		Stack<Integer> stack1 = new Stack<>();

		int xx = x;
		while(x!=0){
			stack1.push(x%10);
			x = x/10;
		}
		boolean result = true;
		while(!stack1.empty()){
			if(stack1.pop()!=xx%10){
				result = false;
			}
			xx = xx/10;
		}
		return result;
	}
}
