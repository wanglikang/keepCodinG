package cn.wlk.keepcoding.SwordOffer;

import java.util.ArrayList;
import java.util.Stack;
/*******从尾到头打印链表 
 * 输入一个链表，从尾到头打印链表每个节点的值。
 * 
 * @author WLK
 *
 */
class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}

public class Solution3 {
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		Stack<Integer> stack = new Stack<>();
		ListNode ptr = listNode;
		while (ptr!=null) {
			stack.push(ptr.val);
			ptr = ptr.next;
		}
		ArrayList<Integer> result = new ArrayList<>();
		while (!stack.isEmpty()) {
			result.add(stack.pop());
		}
		return result;

	}

}
