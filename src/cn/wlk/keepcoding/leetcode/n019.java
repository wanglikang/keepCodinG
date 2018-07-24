package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 19. 删除链表的倒数第N个节点
 * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 * <p>
 * 示例：
 * <p>
 * 给定一个链表: 1->2->3->4->5, 和 n = 2.
 * <p>
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 * 说明：
 * <p>
 * 给定的 n 保证是有效的。
 * <p>
 * 进阶：
 * <p>
 * 你能尝试使用一趟扫描实现吗？
 */
//done
public class n019 {

    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {


        //加个头节点
        ListNode result = new ListNode(-1);
        result.next = head;

        ListNode key = result;
        ListNode next = head;
        for(int i = 0;i<n;i++){
            next = next.next;
        }
        //从现在开始，key节点和next之前相关了n个节点，即key.next是要删除的节点
        while(next!=null){
            next = next.next;
            key = key.next;
        }
        key.next = key.next.next;
        return result.next;

    }

    @Test
    public void test() {

    }

}
