package cn.wlk.keepcoding.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 143. 重排链表
 * <p>
 * 给定一个单链表 L 的头节点 head ，单链表 L 表示为：
 * <p>
 * L0 → L1 → … → Ln - 1 → Ln
 * 请将其重新排列后变为：
 * <p>
 * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
 * 不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：head = [1,2,3,4]
 * 输出：[1,4,2,3]
 * 示例 2：
 * <p>
 * <p>
 * <p>
 * 输入：head = [1,2,3,4,5]
 * 输出：[1,5,2,4,3]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 链表的长度范围为 [1, 5 * 104]
 * 1 <= node.val <= 1000
 */

/**
 * 解法1：
 *  先遍历一遍，求长度，并把每个元素放到数组里
 *  然后遍历数据，改变节点的指向
 *  记得每次改变后，将被插入节点的前一个节点的next置为null，避免出现环
 *
 * 解法2：
 *  1、先找链表的中点
 *  2、再将右半端反转
 *  3、最后将左半边和右半边合并即可（记得切断左右两边链表的中间链接，避免出现环）
 *
 *
 */
public class n143 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}

        ListNode(int val) {this.val = val;}

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public void reorderList(ListNode head) {
        List<ListNode> list = new ArrayList();
        //先遍历一遍
        ListNode p = head;
        int len = 0;
        while(p!=null){
            list.add(p);
            p = p.next;
            len++;
        }
        int l = 0;
        int r = len-1;
        while(l < r && l < len/2){
            ListNode needInsertAfterNode = list.get(l);
            ListNode insertNode = list.get(r);
            ListNode beforeInsertNode = list.get(r-1);
            beforeInsertNode.next = null;
            ListNode tmp = needInsertAfterNode.next;
            needInsertAfterNode.next = insertNode;
            insertNode.next = tmp;
            l++;
            r--;
        }

    }

    /**
     * 解法2的
     * @param head
     */
    public void reorderListV2(ListNode head) {
        List<ListNode> list = new ArrayList();
        //先找中点
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next!= null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next!=null){
                fast = fast.next;
            }
        }
        //从slow开始进行反转

        ListNode newRightHead = reverseListNode(slow);
        // 最后合并左边和右边的链表，从左边开始合并
        ListNode left = head;
        ListNode right = newRightHead;
        while(left!= null && right!= null){
            ListNode tmp = left.next;
            ListNode tmpRight = right.next;
            left.next = right;
            right.next = tmp;

            right  = tmpRight;
            left = tmp;
        }

        //记得要置为null，避免链表出现环
        if(left !=null){
            left.next = null;
        }
        if(right != null){
            right.next = null;
        }
    }
    public ListNode reverseListNode(ListNode root) {

        if(root.next == null){
            return root;
        }
        ListNode listNode = reverseListNode(root.next);
        root.next.next  = root;
        root.next = null;
        return listNode;
    }
}
