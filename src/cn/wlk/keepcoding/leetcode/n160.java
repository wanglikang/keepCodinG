package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 160. 相交链表
 * 编写一个程序，找到两个单链表相交的起始节点。
 * <p>
 * <p>
 * <p>
 * 例如，下面的两个链表：
 * <p>
 * A:          a1 → a2
 * ↘
 * c1 → c2 → c3
 * ↗
 * B:     b1 → b2 → b3
 * 在节点 c1 开始相交。
 * <p>
 * <p>
 * <p>
 * 注意：
 * <p>
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 * 可假定整个链表结构中没有循环。
 * 程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。
 */
//done

/**
 * 解法：
 * 分别遍历两个链表，求出各自的长度，
 * 然后求出差diff，让长的那个链表先遍历diff个，然后在判断是不是相同的节点，
 * 是，则有交点
 * 否，则没有交点
 */
public class n160 {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode l1 = headA;
        ListNode l2 = headB;
        while(headA!=null){
            headA=headA.next;
            len1++;
        }
        while(headB!=null){
            headB=headB.next;
            len2++;
        }
        int diff;
        if(len1>=len2){
            diff = len1-len2;
            while(diff>0){
                l1 = l1.next;
                diff--;
            }
            while(l1!=null &&l2!=null) {
                if (l1 == l2)
                    return l1;
                else {
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            return null;
        }else {
            diff = len2-len1;
            while(diff>0){
                diff--;
                l2 = l2.next;
            }
            while(l1!=null &&l2!=null) {
                if (l1 == l2)
                    return l1;
                else {
                    l1 = l1.next;
                    l2 = l2.next;
                }
            }
            return null;
        }

    }

    @Test
    public void test() {
        n160 t = new n160();
        System.out.println();
    }

}
