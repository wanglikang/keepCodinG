package cn.wlk.keepcoding.SwordOffer;

/************合并两个排序的链表 
 * 输入两个单调递增的链表，输出两个链表合成后的链表，
 * 当然我们需要合成后的链表满足单调不减规则。
 * @author WLK
 *
 */
public class Solution16 {
	public static class ListNode {
	    int val;
	    ListNode next = null;

	    ListNode(int val) {
	        this.val = val;
	    }
	}
	  public ListNode Merge(ListNode list1,ListNode list2) {
	        if(list1==null)
	            return list2;
	        if(list2==null)
	            return list1;
	        if(list1==null &&list2==null)
	            return null;
	        
	        ListNode result = new ListNode(list1.val>list2.val?list2.val:list1.val);
	        ListNode curr = result;
	        
	        ListNode ptr1 = list1,ptr2 = list2;
	        while(ptr1!=null && ptr2!=null){
	            if(ptr1.val<=ptr2.val){
	                curr.next = ptr1;
	                curr = ptr1;
	                ptr1 = ptr1.next;
	                
	            }else {
	                curr.next = ptr2;
	                curr = ptr2;
	                ptr2 = ptr2.next;
	            }
	        }
	        if(ptr1==null)
	            curr.next = ptr2;
	        else if(ptr2==null)
	            curr.next = ptr1;
	        return result.next;
	    }

}
