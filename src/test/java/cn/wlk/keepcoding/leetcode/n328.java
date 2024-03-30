package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 328. 奇偶链表
 * 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 * <p>
 * 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 * <p>
 * 示例 1:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 1->3->5->2->4->NULL
 * 示例 2:
 * <p>
 * 输入: 2->1->3->5->6->4->7->NULL
 * 输出: 2->3->6->7->1->5->4->NULL
 * 说明:
 * <p>
 * 应当保持奇数节点和偶数节点的相对顺序。
 * 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
//done
public class n328 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return null;
        ListNode odd = head;
        ListNode oddd = odd;
        ListNode eve;
        if (head.next != null)
            eve = head.next;
        else return head;
        ListNode evee = eve;
        while (true) {
            if (eve.next == null) {
                odd.next = null;
                break;
            }
            odd.next = odd.next.next;
            odd = odd.next;
            if (odd.next == null) {
                eve.next = null;
                break;
            }
            eve.next = eve.next.next;
            eve = eve.next;
        }
        odd.next = evee;
        return oddd;
    }


    @Test
    public void test() {
        n328 t = new n328();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;
        ListNode l6 = new ListNode(6);
        l5.next = l6;
        ListNode l7 = new ListNode(7);
        l6.next = l7;
        l7.next = null;

        ListNode result = t.oddEvenList(l1);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
