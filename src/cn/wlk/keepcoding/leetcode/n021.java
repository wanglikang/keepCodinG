package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 21. 合并两个有序链表
 * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 * <p>
 * 示例：
 * <p>
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
//done
public class n021 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode result = new ListNode(-1);
        ListNode head = result;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                result.next = l1;
                l1 = l1.next;
                result = result.next;

            } else {
                result.next = l2;
                l2 = l2.next;
                result = result.next;
            }
        }
        if (l1 != null) {
            result.next = l1;

        }
        if (l2 != null) {
            result.next = l2;
        }
        return head.next;
    }

    @Test
    public void test() {
        n021 t = new n021();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;

        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(2);
        ListNode n6 = new ListNode(3);
        ListNode n7 = new ListNode(4);
        n4.next = n5;
        n5.next = n6;
        n6.next = n7;

        ListNode result = t.mergeTwoLists(n1,n4);
        while(result!=null){
            System.out.print(result.val);
            result  =  result.next;
        }
    }

}
