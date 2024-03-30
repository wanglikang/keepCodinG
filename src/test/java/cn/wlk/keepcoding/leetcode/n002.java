package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2. 两数相加
 * <p>
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * <p>
 * 示例：
 * <p>
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */
//done
public class n002 {
    //     * Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int up = 0;
        ListNode head = new ListNode(0);
        ListNode result = head;
        while (l1 != null && l2 != null) {
            int value = l1.val + l2.val + up;
            up = value > 9 ? 1 : 0;
            ListNode l = new ListNode(value%10);
            head.next = l;
            head = head.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while (l1 != null) {
            int value = l1.val + up;
            up = value > 9 ? 1 : 0;
            ListNode l = new ListNode(value%10);
            head.next = l;
            head = head.next;
            l1 = l1.next;

        }
        while (l2 != null) {
            int value = l2.val + up;
            up = value > 9 ? 1 : 0;
            ListNode l = new ListNode(value%10);
            head.next = l;
            head = head.next;
            l2 = l2.next;
        }
        if(up!=0){
            ListNode l = new ListNode(up);
            head.next = l;
            head = head.next;
        }
        return result.next;

    }

    @Test
    public void test() {

    }

}
