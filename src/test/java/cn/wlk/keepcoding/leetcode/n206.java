package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 206. 反转链表
 * <p>
 * 反转一个单链表。
 * <p>
 * 示例:
 * <p>
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 进阶:
 * 你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 * 解法：头部插入即可
 */
//done
public class n206 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        ListNode result = new ListNode(head.val);
        head=head.next;
        while(head!=null){
            ListNode n = new ListNode(head.val);
            n.next = result;
            result =n;
            head = head.next;
        }
        return result;
    }

    @Test
    public void test() {
        n206 t = new n206();
        System.out.println();
    }

}
