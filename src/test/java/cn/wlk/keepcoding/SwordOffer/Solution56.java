package cn.wlk.keepcoding.SwordOffer;

import org.junit.Test;

/**
 * 2019/4/7-14:35
 * author:WLK
 * 删除链表中重复的结点
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，
 * 请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 解法：新建一个头节点last，其next指向pHead，指针curr指向last.next.next
 *          有相同的元素则curr后移，直到不同为止，
 *          然后赋值last的next（即删除了所有的相同的节点）
 */
public class Solution56 {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    @Test
    public void test() {
        Solution56 t = new Solution56();
    }

    /**
     * 新建一个头节点，
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null)
            return null;
        if (pHead.next == null)
            return pHead;
        ListNode head = new ListNode(-1);
        head.next = pHead;
        ListNode last = head;
        ListNode curr = pHead.next;
        while (curr != null) {
            if (last.next.val == curr.val) {
                while (curr != null && last.next.val == curr.val) {
                    curr = curr.next;
                }
                last.next = curr;
            } else {
                last = last.next;
            }
            if (curr != null)
                curr = curr.next;

        }
        return head.next;
    }


}