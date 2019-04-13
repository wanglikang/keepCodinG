package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2019/4/13-11:07
 * author:WLK
 * <p>
 * 142. 环形链表 II
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
 * <p>
 * 说明：不允许修改给定的链表。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [3,2,0,-4], pos = 1
 * 输出：tail connects to node index 1
 * 解释：链表中有一个环，其尾部连接到第二个节点。
 * 见图n142-circularlinkedlist.jpg
 * <p>
 * 示例 2：
 * <p>
 * 输入：head = [1,2], pos = 0
 * 输出：tail connects to node index 0
 * 解释：链表中有一个环，其尾部连接到第一个节点。
 * 见图见图n142-circularlinkedlist-test2.jpg
 * <p>
 * 示例 3：
 * <p>
 * 输入：head = [1], pos = -1
 * 输出：no cycle
 * 解释：链表中没有环。
 * <p>
 * <p>
 * <p>
 * 进阶：
 * 你是否可以不用额外空间解决此题？
 *
 * 解法：先快慢指针，再设一头节点在相遇出同时出发，，相遇则为环的入口
 */
public class n142 {
    //     * Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    @Test
    public void test() {
        n142 t = new n142();
        ListNode p1 = new ListNode(3);
        ListNode p2 = new ListNode(2);
        ListNode p3 = new ListNode(0);
        ListNode p4 = new ListNode(-4);
        p1.next= p2;
        p2.next = p3;
        p3.next = p4;
        p4.next = p2;
        ListNode result = t.detectCycle(p1);
        System.out.println(result.val);
    }

    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow  = head;
        if(head==null || head.next == null){
            return null;
        }
        while (fast!=null && fast.next !=null ){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast){
                break;
            }
        }
        if(slow!=fast){
            return null;
        }
        ListNode start = head;
        while(start!=slow){
            start = start.next;
            slow = slow.next;
        }
        return start;
    }
}