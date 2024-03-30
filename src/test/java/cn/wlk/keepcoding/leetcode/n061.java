package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/13-10:20
 * author:WLK
 * <p>
 * 61. 旋转链表
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 * <p>
 * 示例 2:
 * <p>
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 *
 * 解法：常规题，先求链表长度，在求差，然后改变几个节点指针即可
 */
public class n061 {
    //      Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
        public ListNode addNode(ListNode node){
            this.next = node;
            return node;
        }
    }

    @Test
    public void test() {
        n061 t = new n061();
    }

    public ListNode rotateRight(ListNode head, int k) {
        int len = 0;
        if(head==null){
            return null;
        }
        if (head.next == null)
            return head;

        ListNode curr = head;
        ListNode tail = curr;
        while (curr != null) {
            tail = curr;
            curr = curr.next;
            len++;
        }
        k = k % len;
        curr = head;
        int index = len - k-1;
        while (index > 0) {
            curr = curr.next;
            index--;
        }

        tail.next = head;

        ListNode result = curr.next;
        curr.next = null;


        return result;
    }

}