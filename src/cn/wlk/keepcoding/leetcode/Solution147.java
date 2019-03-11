package cn.wlk.keepcoding.leetcode;
/**
9. 回文数

*/
public class Solution147 {
	static  class ListNode {
	     int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	     public ListNode add(int n){
	     	this.next = new ListNode(n);
	     	return this.next;
		 }
 	}

	public static void main(String[] args) {
		ListNode n1 = new ListNode(4);
		n1.add(2).add(1);
		Solution147 s = new Solution147();
		ListNode result = s.insertionSortList(n1);
		result = result;
		while (result!=null){
			System.out.println(result.val);
			result  = result.next;
		}

	}
	public ListNode insertionSortList(ListNode headp) {
		// System.out.println(head.val);
		ListNode head  = new ListNode(Integer.MIN_VALUE);
		head.next = headp;
		ListNode p = head;
		ListNode pre = head;
		ListNode target = head.next;
		if(target==null)
			return head.next;
		while(pre.next!=null){
			insertNode(head,pre,target);
			if(pre.next==target) {
				pre = pre.next;
				target = target.next;
			}else target = pre.next;
		}
		return head.next;
	}

	public void insertNode(ListNode head,ListNode pre,ListNode target){
		if(head==null ||head.next==null||head.next.next==null)
			return ;

		ListNode p=head;
		while(p.next!=null && p!=pre){
			if(p.next.val>target.val){
				pre.next = target.next;
				target.next = p.next;
				p.next = target;
				return ;
			}else p = p.next;
		}
		return ;
	}

}
