package SwordOffer;

import java.util.Stack;

/***
 * 包含min函数的栈
 *
 * 题目描述 定义栈的数据结构，请在该类型中实现一个能够得到栈最小元素的min函数。
 * 
 * @author WLK
 *
 */
public class Solution20 {

	Stack<Integer> stack = new Stack<>();
	Stack<Integer> minstack = new Stack<>();

	public static void main(String[] args) {
		Solution20 s = new Solution20();
		/*
		 * ["PSH3","MIN", "PSH4","MIN", "PSH2","MIN", "PSH3","MIN", "POP","MIN",
		 * "POP","MIN", "POP","MIN", "PSH0","MIN"]
		 */
		s.push(3);
		System.out.println(s.min());
		s.push(4);
		System.out.println(s.min());
		s.push(2);
		System.out.println(s.min());
		s.push(3);
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.pop();
		System.out.println(s.min());
		s.push(0);
		System.out.println(s.min());

	}

	public void push(int node) {
		stack.push(node);
		if (minstack.isEmpty())
			minstack.add(node);
		else if (minstack.peek() >= node)
			minstack.add(node);
		else {
			int te = minstack.peek();
			int count = 0;
			while (te < node && !minstack.isEmpty()) {
				count++;
				te = minstack.pop();
				stack.add(te);
			}
			minstack.add(node);
			for (int i = 0; i < count; i++)
				minstack.add(stack.pop());
		}
	}

	public void pop() {
		int key = stack.pop();
		int count = 0;
		int top;
		for (; !minstack.isEmpty();) {
			top = minstack.pop();
			if(top>=key)
				break;
			if (top < key) {
				count++;
				stack.add(top);
			}
		}
		while (count > 0) {
			minstack.add(stack.pop());
			count--;
		}
	}

	public int top() {
		return stack.peek();

	}

	public int min() {
		int result = minstack.peek();
		return result;
	}
}
