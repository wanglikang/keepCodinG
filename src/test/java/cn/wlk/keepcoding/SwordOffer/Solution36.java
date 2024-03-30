package cn.wlk.keepcoding.SwordOffer;

import java.util.List;
import java.util.Stack;

/**
 * 36. 两个链表的第一个公共结点
 * <p>
 * 输入两个链表，找出它们的第一个公共结点。
 * 解法：先求两个链表的长度，在让长的先走，然后同步走即可
 */
public class Solution36 {
    public static void main(String[] args) {
        ListNode list1 = new ListNode(1);
        ListNode list2 = new ListNode(2);
        Solution36 nn = new Solution36();
        ListNode result = nn.FindFirstCommonNode(list1, list1);
        while (result != null) {
            System.out.println(result);
            result = result.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 以前做的时候的方法，，使用两个栈，分别入栈，再同步出战，第一个不相等的节点的前一个节点就是第一个共同节点
     * 缺点，空间复杂度太高。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode_Old(ListNode pHead1, ListNode pHead2) {
        Stack<ListNode> stack1 = new Stack<>();
        Stack<ListNode> stack2 = new Stack<>();
        while (pHead1 != null) {
            stack1.push(pHead1);
            pHead1 = pHead1.next;
        }
        while (pHead2 != null) {
            stack2.push(pHead2);
            pHead2 = pHead2.next;
        }
        ListNode result = null;
        while (!stack1.empty() && !stack2.empty() && stack1.peek() == stack2.peek()) {
            stack1.pop();
            stack2.pop();
            result = pHead1;
        }
        return result;
    }

    /**
     * 新版本的，先求一下两个链表的长度，然后让长的那个链表先走长度差步，
     * 在同步走，第一个相同的节点就是第一个共同节点。
     *
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        int len1 = 0;
        int len2 = 0;
        ListNode node = pHead1;
        while (node != null) {
            len1++;
            node = node.next;
        }
        node = pHead2;
        while (node != null) {
            len2++;
            node = node.next;
        }
        ListNode n1 = pHead1;
        ListNode n2 = pHead2;
        if (len1 > len2) {
            for (int i = 0; i < len1 - len2; i++) {
                n1 = n1.next;
            }
        } else if (len2 > len1) {
            for (int i = 0; i < len2 - len1; i++) {
                n2 = n2.next;
            }
        }

        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1 == n2 ? n1 : null;
    }

}
