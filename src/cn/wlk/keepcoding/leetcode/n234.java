package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 234. 回文链表
 * 请判断一个链表是否为回文链表。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2
 * 输出: false
 * 示例 2:
 * <p>
 * 输入: 1->2->2->1
 * 输出: true
 * 进阶：
 * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
public class n234 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode oldHead = head;

        ListNode newHead = new ListNode(head.val);
        head = head.next;
        while (head != null) {
            ListNode n = new ListNode(head.val);
            n.next = newHead;
            newHead =n;
            head = head.next;
        }
        for (; oldHead != null && newHead != null;
             oldHead = oldHead.next, newHead = newHead.next) {
//            System.out.println(oldHead.val+":"+newHead.val);
            if (oldHead.val != newHead.val) {
                return false;
            }
        }
        return true;

    }

    @Test
    public void test() {
        n234 t = new n234();
        ListNode l1 = new ListNode(1);
        ListNode l2= new ListNode(2);
        ListNode l3= new ListNode(2);
        ListNode l4= new ListNode(1);
        l1.next  = l2;
        l2.next = l3;
        l3.next = l4;
        System.out.println(t.isPalindrome(l1));
    }

}
