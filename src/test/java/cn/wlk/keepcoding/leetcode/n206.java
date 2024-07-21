package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

import java.util.List;

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
        public int val;
        public ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    /**
     * 创建新链表节点返回
     * @param head
     * @return
     */
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

    /**
     * 原地反转
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){
        ListNode pre = null;
        ListNode current = head;
        while(current != null){
            ListNode currentNext= current.next;
            current.next = pre;
            pre = current;
            current = currentNext;
        }
        return pre;
    }


    @Test
    public void test() {
        n206 t = new n206();
        ListNode root = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        root.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        Utils.showLinkedList(root);
        ListNode listNode = reverseList2(root);
        System.out.println("=======");
        Utils.showLinkedList(listNode);
    }

}
