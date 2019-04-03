package cn.wlk.keepcoding.SwordOffer;

import java.util.Stack;

/**
 * 36. 两个链表的第一个公共结点
 *
 输入两个链表，找出它们的第一个公共结点。
 *
 *
 */
public class Solution36 {
	public static void main(String[] args) {
		ListNode list1 = new ListNode(1);
		ListNode list2 = new ListNode(2);
		Solution36 nn = new Solution36();
		ListNode  result = nn.FindFirstCommonNode(list1,list1 );
		while(result!=null) {
			System.out.println(result);
			result = result.next;
		}
	}
	static class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
		Stack<ListNode> stack1 = new Stack<>();
		Stack<ListNode> stack2 = new Stack<>();
		while(pHead1!=null){
			stack1.push(pHead1);
			pHead1 = pHead1.next;
		}
		while(pHead2!=null){
			stack2.push(pHead2);
			pHead2 = pHead2.next;
		}
		ListNode result = null;
		while(!stack1.empty() && !stack2.empty()&&stack1.peek()==stack2.peek()){
			stack1.pop();
			stack2.pop();
			result = pHead1;
		}
		return result;

	}

}
