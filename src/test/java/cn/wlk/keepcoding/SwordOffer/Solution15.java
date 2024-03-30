package cn.wlk.keepcoding.SwordOffer;

import java.util.Stack;

/*********
 * 反转链表
 * 
 * 输入一个链表，反转链表后，输出链表的所有元素。
 * 
 * @author WLK
 *
 */

public class Solution15 {

	class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public static void main(String[] args) {
		Solution15 s15 = new Solution15();
		ListNode head = s15.new ListNode(4);
		ListNode head1 = s15.new ListNode(5);
		ListNode head2 = s15.new ListNode(6);
		ListNode head3 = s15.new ListNode(7);
		ListNode head4 = s15.new ListNode(8);
		ListNode head5 = s15.new ListNode(9);
		head.next = head1;
		head1.next = head2;
		head2.next = head3;
		head3.next = head4;
		head4.next = head5;
		head5.next = null;

		ListNode result = s15.ReverseList(head);
		while(result!=null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

	public ListNode ReverseList(ListNode head) {
        if(head==null)
            return  null;
		Stack<ListNode> stack = new Stack<>();
		
		while (head != null) {
			stack.add(new ListNode(head.val));
			head = head.next;
		}
		ListNode result = stack.pop();
		result.next = doWith(stack);
		return result;

	}

	public ListNode doWith(Stack<ListNode> stack) {
		if (stack.isEmpty())
			return null;
		ListNode te = stack.pop();
		te.next = doWith(stack);
		return te;
	}
}
