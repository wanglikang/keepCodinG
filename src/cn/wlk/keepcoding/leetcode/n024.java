package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/2/1 23:55
 * author:WLK
 * 24. 两两交换链表中的节点
 * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 *
 * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 *
 *
 * 示例:
 *
 * 给定 1->2->3->4, 你应该返回 2->1->4->3.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：设两个指针就行
 */

public class n024 {
     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }


    @Test
    public void test() {
        n024 t = new n024();

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        ListNode re = t.swapPairs(l1);
        while (re!=null) {
            System.out.print(re.val + " ");
            re = re.next;
        }


    }
    public ListNode swapPairs(ListNode head) {

         if(head==null){
             return null;
         }
         if(head.next == null){
             return head;
         }

         ListNode result = new ListNode(-1);
         result.next = head;

         ListNode a = result;
         ListNode b = head.next;

         ListNode t;
         while (a!=null && b!=null){
             t = a.next;
             a.next = b;
             t.next = b.next;
             b.next = t;


             a = t;
             if(t.next!=null) {
                 b = t.next.next;
             }else{
                 break;
             }
         }
         return result.next;
    }

}
