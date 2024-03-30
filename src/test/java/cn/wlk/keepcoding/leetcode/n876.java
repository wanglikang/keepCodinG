package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 876. 链表的中间结点
 * <p>
 * 给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
 * <p>
 * 如果有两个中间结点，则返回第二个中间结点。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：[1,2,3,4,5]
 * 输出：此列表中的结点 3 (序列化形式：[3,4,5])
 * 返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
 * 注意，我们返回了一个 ListNode 类型的对象 ans，这样：
 * ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
 * 示例 2：
 * <p>
 * 输入：[1,2,3,4,5,6]
 * 输出：此列表中的结点 4 (序列化形式：[4,5,6])
 * 由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。
 */
//done
public class n876 {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 题目很智障，明明说了带头结点，比赛输入的时候却是不带头结点的数据
     * @param head
     * @return
     */
    public ListNode middleNode(ListNode head) {
        ListNode h = new ListNode(0);
        h.next = head;
        ListNode half = h;
        ListNode full = h;

//        ListNode half = head;
//        ListNode full = head;
        while (full != null) {
            half = half.next;

            if (full.next == null) {
                return half;
            } else if (full.next.next == null) {
                return half;
            }else full = full.next.next;
        }
        return half;

    }

    @Test
    public void test() {
        n876 t = new n876();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        ListNode l6 = new ListNode(6);
        ListNode head = new ListNode(0);
        head.next = l1;
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
      //  l5.next = l6;
        ListNode result = t.middleNode(head);
        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }

}
