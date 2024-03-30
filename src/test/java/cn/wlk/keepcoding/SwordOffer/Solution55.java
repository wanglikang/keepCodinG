package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-13:57
 * author:WLK
 * 链表中环的入口结点
 * <p>
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 * 解法：快慢指针求是否有环，然后在开头和重逢的地方同步走，相遇的节点则一定是入口节点。
 *      图示见Solution55.jpg
 */
public class Solution55 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Solution55 t = new Solution55();
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        ListNode fast = pHead;
        ListNode slow = pHead;
        while(fast!=null){
            if(slow!=null && fast.next!=null){
                slow = slow.next;
                fast = fast.next.next;
            }else{
                return null;
            }
            if(slow==fast){
                break;
            }
        }
        ListNode start = pHead;
        while (start!=slow){
            start =start.next;
            slow = slow.next;
        }
        return slow;
    }

}