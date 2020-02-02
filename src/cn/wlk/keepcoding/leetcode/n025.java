package cn.wlk.keepcoding.leetcode;

import org.junit.Test;

/**
 * 2020/2/2 12:59
 * author:WLK
 *
 * 25. K 个一组翻转链表
 *
 * 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。
 *
 * k 是一个正整数，它的值小于或等于链表的长度。
 *
 * 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
 *
 * 示例 :
 *
 * 给定这个链表：1->2->3->4->5
 *
 * 当 k = 2 时，应当返回: 2->1->4->3->5
 *
 * 当 k = 3 时，应当返回: 3->2->1->4->5
 *
 * 说明 :
 *
 *     你的算法只能使用常数的额外空间。
 *     你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * 解法：新建虚拟头节点，设anchor指针初始指向虚拟节点，
 *      anchor -> [(x->)*->p_pre] -> p -> a -> b -> xxxx
 *-> k-1次
 *      anchor -> p-> [(x->)*->p_pre] -> a -> b xx
 *
 *      设置循环k-1次，，，
 *      若最后一轮不够k次，，则再将最后一个anchor后的节点再翻转回来
 *
 *
 */

public class n025 {
    public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    @Test
    public void test() {
        n025 t = new n025();
        int[] arr = new int[]{1,2,3,4,5,6,7,8,9,10};
//        Utils.createListByArray(ListNode.class,arr);

        ListNode n1  = new ListNode(1);
        ListNode n2  = new ListNode(2);
        ListNode n3  = new ListNode(3);
        ListNode n4  = new ListNode(4);
        ListNode n5  = new ListNode(5);
        ListNode n6  = new ListNode(6);
        ListNode n7  = new ListNode(7);
        ListNode n8  = new ListNode(8);
        ListNode n9  = new ListNode(9);
        n1.next  = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n5;
        n5.next = n6;
        n6.next =  n7;
        n7.next = n8;
        n8.next = n9;
        ListNode r = t.reverseKGroup(n1, 3);
        while (r!=null){
            System.out.print(r.val+" ");
            r = r.next;
        }

    }

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode result = new ListNode(-1);
        result.next = head;
        if(head==null){
            return  null;
        }
        if(head.next == null || k==1){
            return  head;
        }

        ListNode anchor = result;
        ListNode p = head.next;
        ListNode p_Pre = head;
        ListNode t;
        ListNode n;

        while(p!=null){
            int i = 1;
            for( i =1;i<k && p!=null;i++){
                n = p.next;
                t = anchor.next;
                anchor.next = p;
                p_Pre.next = p.next;
                p.next = t;
                p = n;
            }
            //不够k个，，再翻回来
            if(i<k){
                p_Pre = anchor.next;
                p = p_Pre.next;
                while(p!=null){
                    n = p.next;
                    t = anchor.next;
                    anchor.next = p;
                    p_Pre.next = p.next;
                    p.next = t;
                    p = n;
                }
                break;
            }

            anchor = p_Pre;
            p_Pre = anchor.next;
            if(p_Pre==null){
                break;
            }
            p=p_Pre.next;
            if(p==null){
                break;
            }
        }



        return result.next;
    }

}
