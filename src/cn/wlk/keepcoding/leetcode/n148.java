package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/13-12:24
 * author:WLK
 * <p>
 * 148. 排序链表
 * <p>
 * 在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 4->2->1->3
 * 输出: 1->2->3->4
 * <p>
 * 示例 2:
 * <p>
 * 输入: -1->5->3->4->0
 * 输出: -1->0->3->4->5
 * 解法：思路是用归并排序。注意，在求出中间节点之后，需要断开两个子链表，否则会出现环，导致死循环
 */
public class n148 {


    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    @Test
    public void test() {
        n148 t = new n148();
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(-4);
        p1.next = p2;
        p2.next = p3;
        p3.next = p4;
        ListNode result = t.sortList(p1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

    /**
     * 思路是用归并排序
     * 注意，在求出中间节点之后，需要断开两个子链表，否则会出现环，导致死循环
     *
     * @param head
     * @return
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        else
            return mergerSort(head);
    }

    public ListNode mergerSort(ListNode root) {

        if (root.next == null) {
            return root;
        }

        ListNode temp, result;
        //先分成两段
        ListNode mid = root;
        ListNode right = root;
        ListNode pre = root;
        while (right != null && right.next != null) {
            pre = mid;
            mid = mid.next;
            right = right.next.next;

        }
        pre.next = null;
        ListNode left = mergerSort(root);
        right = mergerSort(mid);

        if (left.val < right.val) {
            temp = left;
            result = left;
            left = left.next;
        } else {
            temp = right;
            result = right;
            right = right.next;
        }


        //在归并merge
        while (left != null && right != null) {
            if (left.val < right.val) {
                temp.next = left;
                left = left.next;
            } else {
                temp.next = right;
                right = right.next;
            }
            temp = temp.next;
        }
        if (left != null) {
            temp.next = left;
        } else if (right != null) {
            temp.next = right;
        }

        return result;
    }

}