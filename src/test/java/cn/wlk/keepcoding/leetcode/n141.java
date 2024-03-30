package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 141. 环形链表
 * <p>
 * <p>
 * 给定一个链表，判断链表中是否有环。
 * <p>
 * 进阶：
 * 你能否不使用额外空间解决此题？
 */
//done

/**
 * 解题方法：
 * 设两个指针p1，p2，
 * 两个指针分别每次后移一个节点、后移两个节点，
 * 若有环，则这两个节点必会在某个节点上相等，
 * 若无环，则会出现等于null的情况
 *
 */
public class n141 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null)
            return false;
        ListNode p1, p2;
        p1 = head;
        if(head.next==null)
            return false;
        if(head.next.next==null)
            return false;
        p2= head.next.next;
        while (p1 != null && p2 != null) {
            if (p1.next != null) {
                p1 = p1.next;
            } else break;

            if (p2.next != null && p2.next.next != null) {
                p2 = p2.next.next;
            } else break;

            if (p1 == p2)
                return true;
        }
        return false;
    }

    @Test
    public void test() {
        n141 t = new n141();
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        ListNode n5 = new ListNode(1);
        ListNode n6 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
//        n6.next = n4;
        System.out.println(t.hasCycle(n1));
        n6.next = n4;
        System.out.println(t.hasCycle(n1));
    }

}
