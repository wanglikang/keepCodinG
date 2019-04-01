package cn.wlk.keepcoding.SwordOffer;

import java.util.Stack;

/******链表中倒数第k个结点 
 * 
 * 输入一个链表，输出该链表中倒数第k个结点。	
 * 
 * @author WLK
 *
 */


class ListNode14 {
    int val;
    ListNode14 next = null;

    ListNode14(int val) {
        this.val = val;
    }
}
public class Solution14 {
	public ListNode14 FindKthToTail(ListNode14 head,int k) {

        int len = 0;
        Stack<ListNode14> stack = new Stack<>();
        while(head!=null){
            len++;
            stack.add(head);
            head = head.next;
        }
        if(k>len)
            return null;
        if(k==0)
            return null;
        for(int i = 0;i<k-1;i++){
            stack.pop();
        }
        
        return stack.pop();	
	}
}
