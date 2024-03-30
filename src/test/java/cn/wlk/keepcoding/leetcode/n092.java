package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/2/1 15:22
 * author:WLK
 * 92. 反转链表 II
 * 反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
 * <p>
 * 说明:
 * 1 ≤ m ≤ n ≤ 链表长度。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL, m = 2, n = 4
 * 输出: 1->4->3->2->5->NULL
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-linked-list-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：链表交换位置而已
 */

public class n092 {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

    }

    @Test
    public void test() {

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        n092 t = new n092();


        ListNode r = t.reverseBetween(node1, 1, 1);
        while (r != null) {
            System.out.print(r.val + " ");
            r = r.next;
        }


    }

    /**
     * 交换
     * anchor -> [a .->.->.->.a_end] -> b -> ?
     * 为
     * anchor ->b->  [a .->.->.->.a_end] -> ?
     *
     *
     * @param head
     * @param m
     * @param n
     * @return
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (m == n) {
            return head;
        }


        ListNode result = new ListNode(-1);

        result.next = head;
        int count = 1;
        ListNode anchor = result;
        ListNode a = result.next;
        ListNode a_end = null;
        ListNode b = null;


        for (; count < m; count++) {
            anchor = anchor.next;
        }
        a = anchor.next;
        a_end = a;
        b = a.next;

        for (; count < n; count++) {

            anchor.next = b;
            a_end.next = b.next;
            b.next = a;


            a = anchor.next;
            b = a_end.next;
        }

        return result.next;
    }


}

